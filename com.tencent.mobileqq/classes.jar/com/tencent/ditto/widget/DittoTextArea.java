package com.tencent.ditto.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import com.tencent.ditto.widget.text.StaticLayoutWithMaxLines;

public class DittoTextArea
  extends DittoArea
{
  @DittoJsonElement("字体")
  public static final String FONT_FAMILY = "font_family";
  @DittoJsonElement("字间距, 默认0, 单位em")
  public static final String LETTER_SPACE = "text_letter_space";
  public static final String LineSpace = "line_space";
  public static final String LinkColor = "link_color";
  public static final String MaxLine = "max_line";
  @DittoJsonElement("文字阴影颜色")
  public static final String SHADOW_BG_COLOR = "shadow_bg_color";
  @DittoJsonElement("文字阴影dx, 单位默认px")
  public static final String SHADOW_DX = "shadow_dx";
  @DittoJsonElement("文字阴影dy")
  public static final String SHADOW_DY = "shadow_dy";
  @DittoJsonElement("文字阴影圆角")
  public static final String SHADOW_RADIUS = "shadow_radius";
  private static final String TAG = "DittoTextArea";
  public static final String Text = "text";
  @DittoJsonElement
  public static final String TextAlignment = "text_alignment";
  public static final String TextBold = "text_bold";
  public static final String TextColor = "text_color";
  public static final String TextSize = "text_size";
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  private boolean isDirty = false;
  public float letterSpace = 0.0F;
  public BoringLayout.Metrics mBoring;
  private Integer mCacheKey;
  private DittoTextArea.TextCache mCacheText = null;
  private int mCurTextColor;
  private float mCurrTextSize;
  private TextUtils.TruncateAt mEllipsize;
  public String mFontFamily = "sans-serif";
  private boolean mIncludeFontPadding = true;
  private Layout.Alignment mLayoutAlignment = Layout.Alignment.ALIGN_NORMAL;
  public int mLineSpace = 2;
  private float mLineSpacingAdd = 0.0F;
  private float mLineSpacingMult = 1.0F;
  private int mMaxLines = 2147483647;
  private int mOldMaxLines = 2147483647;
  private TextPaint mPaint;
  protected String mText = "";
  public boolean mTextBold = false;
  public Typeface mTypeface = Typeface.DEFAULT;
  public int shadowBgColor = 0;
  public float shadowDx = 1.4E-45F;
  public float shadowDy = 1.4E-45F;
  public float shadowRadius = 1.4E-45F;
  
  public DittoTextArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  private Integer generateCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mText);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mCurTextColor);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mCurrTextSize);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mLayoutAlignment);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mEllipsize);
    localStringBuilder.append("_");
    localStringBuilder.append(this.letterSpace);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mFontFamily);
    return Integer.valueOf(localStringBuilder.toString().hashCode());
  }
  
  private int getDesiredHeight()
  {
    DittoTextArea.TextCache localTextCache = this.mCacheText;
    if ((localTextCache != null) && (DittoTextArea.TextCache.access$000(localTextCache) != null))
    {
      int i = getPaddingTop();
      int j = getPaddingBottom();
      int k = Math.min(this.mMaxLines, DittoTextArea.TextCache.access$000(this.mCacheText).getLineCount());
      return DittoTextArea.TextCache.access$000(this.mCacheText).getLineTop(k) + (i + j);
    }
    return 0;
  }
  
  private Layout makeNewLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    this.mOldMaxLines = this.mMaxLines;
    boolean bool;
    if (this.mEllipsize != null) {
      bool = true;
    } else {
      bool = false;
    }
    return makeSingleLayout(paramInt1, paramMetrics, paramInt2, this.mLayoutAlignment, bool, this.mEllipsize, paramBoolean);
  }
  
  private Layout makeSingleLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
  {
    String str2 = this.mText;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (paramMetrics == UNKNOWN_BORING)
    {
      paramMetrics = BoringLayout.isBoring(str1, this.mPaint, this.mBoring);
      if (paramMetrics != null) {
        this.mBoring = paramMetrics;
      }
    }
    if (paramMetrics != null)
    {
      if ((paramMetrics.width <= paramInt1) && ((paramTruncateAt == null) || (paramMetrics.width <= paramInt2))) {
        return BoringLayout.make(str1, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, paramMetrics, this.mIncludeFontPadding);
      }
      if ((paramBoolean1) && (paramMetrics.width <= paramInt1)) {
        return BoringLayout.make(str1, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, paramMetrics, this.mIncludeFontPadding, paramTruncateAt, paramInt2);
      }
      if (paramBoolean1) {
        return StaticLayoutWithMaxLines.create(str1, 0, str1.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
      }
      return new StaticLayout(str1, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
    }
    if (paramBoolean1) {
      return StaticLayoutWithMaxLines.create(str1, 0, str1.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
    }
    return new StaticLayout(str1, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
  }
  
  private void setTypeface(Typeface paramTypeface)
  {
    TextPaint localTextPaint = this.mPaint;
    if ((localTextPaint != null) && (localTextPaint.getTypeface() != paramTypeface))
    {
      this.mPaint.setTypeface(paramTypeface);
      requestLayout();
    }
  }
  
  public int getMaxLines()
  {
    return this.mMaxLines;
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getWidth() != 0)
    {
      if (getHeight() == 0) {
        return;
      }
      Object localObject = this.mCacheText;
      if ((localObject != null) && (((DittoTextArea.TextCache)localObject).getBitmap() != null))
      {
        paramCanvas.drawBitmap(this.mCacheText.getBitmap(), 0.0F, 0.0F, null);
        return;
      }
      localObject = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      DittoTextArea.TextCache localTextCache = this.mCacheText;
      if ((localTextCache != null) && (DittoTextArea.TextCache.access$000(localTextCache) != null))
      {
        DittoTextArea.TextCache.access$000(this.mCacheText).draw(localCanvas);
        this.mCacheText.setBitmap((Bitmap)localObject);
      }
      localObject = this.mCacheText;
      if (localObject != null) {
        paramCanvas.drawBitmap(((DittoTextArea.TextCache)localObject).getBitmap(), 0.0F, 0.0F, null);
      }
    }
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.isDirty) || (this.mCacheKey == null))
    {
      this.mCacheKey = generateCacheKey();
      this.isDirty = false;
    }
    this.mCacheText = ((DittoTextArea.TextCache)getAreaCache(this.mCacheKey, DittoTextArea.TextCache.class));
    Object localObject1 = this.mCacheText;
    if ((localObject1 != null) && (DittoTextArea.TextCache.access$000((DittoTextArea.TextCache)localObject1) != null) && (!this.mMeasureDirty))
    {
      setMeasuredDimension(DittoTextArea.TextCache.access$100(this.mCacheText), DittoTextArea.TextCache.access$200(this.mCacheText));
      return;
    }
    this.mCacheText = new DittoTextArea.TextCache(this, null);
    addAreaCache(this.mCacheKey, this.mCacheText);
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824)
    {
      DittoTextArea.TextCache.access$102(this.mCacheText, paramInt1);
    }
    else
    {
      Object localObject2 = this.mText;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.mBoring = BoringLayout.isBoring((CharSequence)localObject1, this.mPaint, UNKNOWN_BORING);
      localObject2 = this.mBoring;
      if ((localObject2 != null) && (localObject2 != UNKNOWN_BORING)) {
        DittoTextArea.TextCache.access$102(this.mCacheText, ((BoringLayout.Metrics)localObject2).width);
      } else {
        DittoTextArea.TextCache.access$102(this.mCacheText, (int)Layout.getDesiredWidth((CharSequence)localObject1, this.mPaint));
      }
      localObject1 = this.mCacheText;
      DittoTextArea.TextCache.access$102((DittoTextArea.TextCache)localObject1, DittoTextArea.TextCache.access$100((DittoTextArea.TextCache)localObject1) + (this.paddingLeft + this.paddingRight));
      if (j == -2147483648)
      {
        localObject1 = this.mCacheText;
        DittoTextArea.TextCache.access$102((DittoTextArea.TextCache)localObject1, Math.min(paramInt1, DittoTextArea.TextCache.access$100((DittoTextArea.TextCache)localObject1)));
      }
    }
    paramInt1 = DittoTextArea.TextCache.access$100(this.mCacheText) - this.paddingLeft - this.paddingRight;
    DittoTextArea.TextCache.access$002(this.mCacheText, makeNewLayout(paramInt1, this.mBoring, paramInt1, false));
    if (i == 1073741824)
    {
      DittoTextArea.TextCache.access$202(this.mCacheText, paramInt2);
    }
    else
    {
      DittoTextArea.TextCache.access$202(this.mCacheText, getDesiredHeight());
      if (i == -2147483648)
      {
        localObject1 = this.mCacheText;
        DittoTextArea.TextCache.access$202((DittoTextArea.TextCache)localObject1, Math.min(paramInt2, DittoTextArea.TextCache.access$200((DittoTextArea.TextCache)localObject1)));
      }
    }
    setMeasuredDimension(DittoTextArea.TextCache.access$100(this.mCacheText), DittoTextArea.TextCache.access$200(this.mCacheText));
  }
  
  public void setDirty(boolean paramBoolean)
  {
    this.isDirty = paramBoolean;
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.mEllipsize == paramTruncateAt) {
      return;
    }
    this.isDirty = true;
    this.mEllipsize = paramTruncateAt;
  }
  
  protected void setFontFamily(String paramString)
  {
    this.mFontFamily = paramString;
    if ("sans-serif".equals(paramString))
    {
      this.mTypeface = Typeface.SANS_SERIF;
      this.mFontFamily = paramString;
    }
    else if ("serif".equals(paramString))
    {
      this.mTypeface = Typeface.SERIF;
    }
    else if ("monospace".equals(paramString))
    {
      this.mTypeface = Typeface.MONOSPACE;
    }
    try
    {
      this.mTypeface = Typeface.createFromAsset(getHost().getContext().getResources().getAssets(), paramString);
    }
    catch (Throwable paramString)
    {
      label95:
      break label95;
    }
    this.mTypeface = Typeface.SANS_SERIF;
    this.mFontFamily = "sans-serif";
    setTypeface(this.mTypeface);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    super.setLayoutAttr(paramLayoutAttrSet);
    if (this.mPaint == null)
    {
      this.mPaint = new TextPaint(1);
      this.mPaint.density = getHost().getContext().getResources().getDisplayMetrics().density;
    }
    if (paramLayoutAttrSet != null)
    {
      String str2 = null;
      StringBuilder localStringBuilder2;
      if (paramLayoutAttrSet.getAttr("text_color", null) != null)
      {
        str1 = paramLayoutAttrSet.getAttr("text_color", null);
        if (!TextUtils.isEmpty(str1)) {
          try
          {
            setTextColor(DittoResourcesUtil.parseColor(str1));
          }
          catch (Throwable localThrowable2)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("the text ");
            localStringBuilder2.append(str1);
            localStringBuilder2.append(" can't be parsed as color string");
            DittoLog.e("DITTO_UI", localStringBuilder2.toString(), localThrowable2);
          }
        }
      }
      String str1 = paramLayoutAttrSet.getAttr("link_color", null);
      if (str1 != null) {
        try
        {
          setLinkColor(DittoResourcesUtil.parseColor(str1));
        }
        catch (Throwable localThrowable3)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("the text ");
          localStringBuilder2.append(str1);
          localStringBuilder2.append(" can't be parsed as color string");
          DittoLog.e("DITTO_UI", localStringBuilder2.toString(), localThrowable3);
        }
      }
      if (paramLayoutAttrSet.hasAttr("text_size")) {
        setTextSize(paramLayoutAttrSet.getAttr("text_size", 15));
      }
      if (paramLayoutAttrSet.hasAttr("max_line")) {
        setMaxLines(paramLayoutAttrSet.getAttr("max_line", 2147483647));
      }
      if (paramLayoutAttrSet.hasAttr("line_space")) {
        setLineSpace(paramLayoutAttrSet.getAttr("line_space", 2));
      }
      boolean bool = paramLayoutAttrSet.hasAttr("text_bold");
      int i = 0;
      if (bool)
      {
        if (paramLayoutAttrSet.getAttr("text_bold", 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        setTextBold(bool);
      }
      if (paramLayoutAttrSet.getAttr("text", null) != null)
      {
        str1 = paramLayoutAttrSet.getAttr("text", null);
        if (!TextUtils.isEmpty(str1)) {
          setText(str1);
        }
      }
      if (paramLayoutAttrSet.hasAttr("text_alignment")) {
        str1 = paramLayoutAttrSet.getAttr("text_alignment", "ALIGN_NORMAL");
      } else {
        str1 = "ALIGN_NORMAL";
      }
      int j = str1.hashCode();
      if (j != -1371700497)
      {
        if (j != -1047432319)
        {
          if ((j == 1015327489) && (str1.equals("ALIGN_OPPOSITE")))
          {
            i = 1;
            break label472;
          }
        }
        else if (str1.equals("ALIGN_NORMAL")) {
          break label472;
        }
      }
      else if (str1.equals("ALIGN_CENTER"))
      {
        i = 2;
        break label472;
      }
      i = -1;
      label472:
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            this.mLayoutAlignment = Layout.Alignment.ALIGN_CENTER;
          }
          else
          {
            paramLayoutAttrSet = new StringBuilder();
            paramLayoutAttrSet.append("Text alignment\"");
            paramLayoutAttrSet.append(str1);
            paramLayoutAttrSet.append("\" is not supported");
            throw new RuntimeException(paramLayoutAttrSet.toString());
          }
        }
        else {
          this.mLayoutAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
      }
      else {
        this.mLayoutAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
      if (paramLayoutAttrSet.hasAttr("shadow_dx")) {
        this.shadowDx = paramLayoutAttrSet.getAttr("shadow_dx", 0.0F);
      }
      if (paramLayoutAttrSet.hasAttr("shadow_dy")) {
        this.shadowDy = paramLayoutAttrSet.getAttr("shadow_dy", 0.0F);
      }
      if (paramLayoutAttrSet.hasAttr("shadow_radius")) {
        this.shadowRadius = paramLayoutAttrSet.getAttr("shadow_radius", 0.0F);
      }
      if (paramLayoutAttrSet.hasAttr("shadow_bg_color"))
      {
        str1 = str2;
        try
        {
          str2 = paramLayoutAttrSet.getAttr("shadow_bg_color", "#00000000");
          str1 = str2;
          this.shadowBgColor = DittoResourcesUtil.parseColor(str2);
        }
        catch (Throwable localThrowable1)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("the text ");
          localStringBuilder1.append(str1);
          localStringBuilder1.append(" can't be parsed as color string");
          DittoLog.e("DITTO_UI", localStringBuilder1.toString(), localThrowable1);
        }
      }
      if (paramLayoutAttrSet.hasAttr("text_letter_space")) {
        setLetterSpace(paramLayoutAttrSet.getAttr("text_letter_space", 0.0F));
      }
      float f1 = this.shadowDx;
      if (f1 != 1.4E-45F)
      {
        float f2 = this.shadowDy;
        if (f2 != 1.4E-45F)
        {
          float f3 = this.shadowRadius;
          if (f3 != 1.4E-45F)
          {
            i = this.shadowBgColor;
            if (i != 0) {
              this.mPaint.setShadowLayer(f3, f1, f2, i);
            }
          }
        }
      }
      if (paramLayoutAttrSet.hasAttr("font_family")) {
        setFontFamily(paramLayoutAttrSet.getAttr("font_family", "sans-serif"));
      }
    }
  }
  
  public void setLeftDrawable(Drawable paramDrawable, int paramInt) {}
  
  public void setLetterSpace(float paramFloat)
  {
    this.letterSpace = paramFloat;
    if ((this.mPaint != null) && (Build.VERSION.SDK_INT >= 21))
    {
      this.mPaint.setLetterSpacing(paramFloat);
      requestLayout();
    }
  }
  
  public void setLineSpace(int paramInt)
  {
    this.mLineSpace = paramInt;
  }
  
  public void setLinkColor(int paramInt) {}
  
  public void setMaxLines(int paramInt)
  {
    this.mMaxLines = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    this.isDirty = true;
    requestLayout();
  }
  
  public void setText(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramInt <= 0) {
        return;
      }
      if (paramString1.length() <= paramInt)
      {
        this.mText = paramString1;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1.substring(0, paramInt - 1));
        localStringBuilder.append(paramString2);
        this.mText = localStringBuilder.toString();
      }
      this.isDirty = true;
      requestLayout();
    }
  }
  
  public void setTextAlignment(Layout.Alignment paramAlignment)
  {
    if (this.mLayoutAlignment == paramAlignment) {
      return;
    }
    this.isDirty = true;
    this.mLayoutAlignment = paramAlignment;
    requestLayout();
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.mTextBold = paramBoolean;
    this.mPaint.setFakeBoldText(true);
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mCurTextColor == paramInt) {
      return;
    }
    this.mCurTextColor = paramInt;
    this.mPaint.setColor(paramInt);
    this.isDirty = true;
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, getContext().getResources().getDisplayMetrics());
    if (this.mPaint.getTextSize() == paramFloat) {
      return;
    }
    this.isDirty = true;
    this.mPaint.setTextSize(paramFloat);
    this.mCurrTextSize = paramFloat;
    requestLayout();
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    TextPaint localTextPaint = this.mPaint;
    if (localTextPaint != null)
    {
      float f = 0.0F;
      boolean bool = false;
      if (paramInt > 0)
      {
        if (paramTypeface == null) {
          paramTypeface = Typeface.defaultFromStyle(paramInt);
        } else {
          paramTypeface = Typeface.create(paramTypeface, paramInt);
        }
        setTypeface(paramTypeface);
        int i;
        if (paramTypeface != null) {
          i = paramTypeface.getStyle();
        } else {
          i = 0;
        }
        paramInt = (i ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.mPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.mPaint;
        if ((paramInt & 0x2) != 0) {
          f = -0.25F;
        }
        paramTypeface.setTextSkewX(f);
        return;
      }
      localTextPaint.setFakeBoldText(false);
      this.mPaint.setTextSkewX(0.0F);
      setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoTextArea
 * JD-Core Version:    0.7.0.1
 */