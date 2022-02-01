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
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
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
  private static final String TAG = DittoTextArea.class.getSimpleName();
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
    return Integer.valueOf((this.mText + "_" + this.mCurTextColor + "_" + this.mCurrTextSize + "_" + this.mLayoutAlignment + "_" + this.mEllipsize + "_" + this.letterSpace + "_" + this.mFontFamily).hashCode());
  }
  
  private int getDesiredHeight()
  {
    if ((this.mCacheText == null) || (DittoTextArea.TextCache.access$000(this.mCacheText) == null)) {
      return 0;
    }
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = Math.min(this.mMaxLines, DittoTextArea.TextCache.access$000(this.mCacheText).getLineCount());
    return i + j + DittoTextArea.TextCache.access$000(this.mCacheText).getLineTop(k);
  }
  
  private Layout makeNewLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.mOldMaxLines = this.mMaxLines;
      if (this.mEllipsize != null) {}
      for (boolean bool = true;; bool = false) {
        return makeSingleLayout(paramInt1, paramMetrics, paramInt2, this.mLayoutAlignment, bool, this.mEllipsize, paramBoolean);
      }
    }
  }
  
  private Layout makeSingleLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
  {
    String str;
    if (this.mText == null)
    {
      str = "";
      if (paramMetrics != UNKNOWN_BORING) {
        break label296;
      }
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(str, this.mPaint, this.mBoring);
      paramMetrics = localMetrics;
      if (localMetrics != null)
      {
        this.mBoring = localMetrics;
        paramMetrics = localMetrics;
      }
    }
    label296:
    for (;;)
    {
      if (paramMetrics != null)
      {
        if ((paramMetrics.width <= paramInt1) && ((paramTruncateAt == null) || (paramMetrics.width <= paramInt2)))
        {
          return BoringLayout.make(str, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, paramMetrics, this.mIncludeFontPadding);
          str = this.mText;
          break;
        }
        if ((paramBoolean1) && (paramMetrics.width <= paramInt1)) {
          return BoringLayout.make(str, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, paramMetrics, this.mIncludeFontPadding, paramTruncateAt, paramInt2);
        }
        if (paramBoolean1) {
          return StaticLayoutWithMaxLines.create(str, 0, str.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
        }
        return new StaticLayout(str, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
      }
      if (paramBoolean1) {
        return StaticLayoutWithMaxLines.create(str, 0, str.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
      }
      return new StaticLayout(str, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
    }
  }
  
  private void setTypeface(Typeface paramTypeface)
  {
    if ((this.mPaint != null) && (this.mPaint.getTypeface() != paramTypeface))
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
    if ((getWidth() == 0) || (getHeight() == 0)) {}
    do
    {
      return;
      if ((this.mCacheText != null) && (this.mCacheText.getBitmap() != null))
      {
        paramCanvas.drawBitmap(this.mCacheText.getBitmap(), 0.0F, 0.0F, null);
        return;
      }
      Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(localBitmap);
      if ((this.mCacheText != null) && (DittoTextArea.TextCache.access$000(this.mCacheText) != null))
      {
        DittoTextArea.TextCache.access$000(this.mCacheText).draw(localCanvas);
        this.mCacheText.setBitmap(localBitmap);
      }
    } while (this.mCacheText == null);
    paramCanvas.drawBitmap(this.mCacheText.getBitmap(), 0.0F, 0.0F, null);
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
    if ((this.mCacheText != null) && (DittoTextArea.TextCache.access$000(this.mCacheText) != null) && (!this.mMeasureDirty))
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
      paramInt1 = DittoTextArea.TextCache.access$100(this.mCacheText) - this.paddingLeft - this.paddingRight;
      DittoTextArea.TextCache.access$002(this.mCacheText, makeNewLayout(paramInt1, this.mBoring, paramInt1, false));
      if (i != 1073741824) {
        break label368;
      }
      DittoTextArea.TextCache.access$202(this.mCacheText, paramInt2);
    }
    for (;;)
    {
      setMeasuredDimension(DittoTextArea.TextCache.access$100(this.mCacheText), DittoTextArea.TextCache.access$200(this.mCacheText));
      return;
      Object localObject;
      if (this.mText == null)
      {
        localObject = "";
        label233:
        this.mBoring = BoringLayout.isBoring((CharSequence)localObject, this.mPaint, UNKNOWN_BORING);
        if ((this.mBoring != null) && (this.mBoring != UNKNOWN_BORING)) {
          break label350;
        }
        DittoTextArea.TextCache.access$102(this.mCacheText, (int)Layout.getDesiredWidth((CharSequence)localObject, this.mPaint));
      }
      for (;;)
      {
        localObject = this.mCacheText;
        DittoTextArea.TextCache.access$102((DittoTextArea.TextCache)localObject, DittoTextArea.TextCache.access$100((DittoTextArea.TextCache)localObject) + (this.paddingLeft + this.paddingRight));
        if (j != -2147483648) {
          break;
        }
        DittoTextArea.TextCache.access$102(this.mCacheText, Math.min(paramInt1, DittoTextArea.TextCache.access$100(this.mCacheText)));
        break;
        localObject = this.mText;
        break label233;
        label350:
        DittoTextArea.TextCache.access$102(this.mCacheText, this.mBoring.width);
      }
      label368:
      DittoTextArea.TextCache.access$202(this.mCacheText, getDesiredHeight());
      if (i == -2147483648) {
        DittoTextArea.TextCache.access$202(this.mCacheText, Math.min(paramInt2, DittoTextArea.TextCache.access$200(this.mCacheText)));
      }
    }
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
    for (;;)
    {
      setTypeface(this.mTypeface);
      return;
      if ("serif".equals(paramString)) {
        this.mTypeface = Typeface.SERIF;
      } else if ("monospace".equals(paramString)) {
        this.mTypeface = Typeface.MONOSPACE;
      } else {
        try
        {
          this.mTypeface = Typeface.createFromAsset(getHost().getContext().getResources().getAssets(), paramString);
        }
        catch (Throwable paramString)
        {
          this.mTypeface = Typeface.SANS_SERIF;
          this.mFontFamily = "sans-serif";
        }
      }
    }
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.mIncludeFontPadding = paramBoolean;
  }
  
  /* Error */
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 465	com/tencent/ditto/area/DittoArea:setLayoutAttr	(Lcom/tencent/ditto/shell/LayoutAttrSet;)V
    //   7: aload_0
    //   8: getfield 250	com/tencent/ditto/widget/DittoTextArea:mPaint	Landroid/text/TextPaint;
    //   11: ifnonnull +40 -> 51
    //   14: aload_0
    //   15: new 286	android/text/TextPaint
    //   18: dup
    //   19: iconst_1
    //   20: invokespecial 468	android/text/TextPaint:<init>	(I)V
    //   23: putfield 250	com/tencent/ditto/widget/DittoTextArea:mPaint	Landroid/text/TextPaint;
    //   26: aload_0
    //   27: getfield 250	com/tencent/ditto/widget/DittoTextArea:mPaint	Landroid/text/TextPaint;
    //   30: aload_0
    //   31: invokevirtual 438	com/tencent/ditto/widget/DittoTextArea:getHost	()Lcom/tencent/ditto/area/DittoHost;
    //   34: invokeinterface 444 1 0
    //   39: invokevirtual 450	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: invokevirtual 472	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   45: getfield 477	android/util/DisplayMetrics:density	F
    //   48: putfield 478	android/text/TextPaint:density	F
    //   51: aload_1
    //   52: ifnull +639 -> 691
    //   55: aload_1
    //   56: ldc 53
    //   58: aconst_null
    //   59: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: ifnull +29 -> 91
    //   65: aload_1
    //   66: ldc 53
    //   68: aconst_null
    //   69: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +12 -> 91
    //   82: aload_0
    //   83: aload 4
    //   85: invokestatic 496	com/tencent/ditto/utils/DittoResourcesUtil:parseColor	(Ljava/lang/String;)I
    //   88: invokevirtual 499	com/tencent/ditto/widget/DittoTextArea:setTextColor	(I)V
    //   91: aload_1
    //   92: ldc 21
    //   94: aconst_null
    //   95: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +12 -> 114
    //   105: aload_0
    //   106: aload 4
    //   108: invokestatic 496	com/tencent/ditto/utils/DittoResourcesUtil:parseColor	(Ljava/lang/String;)I
    //   111: invokevirtual 502	com/tencent/ditto/widget/DittoTextArea:setLinkColor	(I)V
    //   114: aload_1
    //   115: ldc 56
    //   117: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   120: ifeq +16 -> 136
    //   123: aload_0
    //   124: aload_1
    //   125: ldc 56
    //   127: bipush 15
    //   129: invokevirtual 509	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;I)I
    //   132: i2f
    //   133: invokevirtual 513	com/tencent/ditto/widget/DittoTextArea:setTextSize	(F)V
    //   136: aload_1
    //   137: ldc 24
    //   139: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   142: ifeq +15 -> 157
    //   145: aload_0
    //   146: aload_1
    //   147: ldc 24
    //   149: ldc 119
    //   151: invokevirtual 509	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;I)I
    //   154: invokevirtual 516	com/tencent/ditto/widget/DittoTextArea:setMaxLines	(I)V
    //   157: aload_1
    //   158: ldc 18
    //   160: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   163: ifeq +14 -> 177
    //   166: aload_0
    //   167: aload_1
    //   168: ldc 18
    //   170: iconst_2
    //   171: invokevirtual 509	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;I)I
    //   174: invokevirtual 519	com/tencent/ditto/widget/DittoTextArea:setLineSpace	(I)V
    //   177: aload_1
    //   178: ldc 50
    //   180: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   183: ifeq +21 -> 204
    //   186: aload_1
    //   187: ldc 50
    //   189: iconst_0
    //   190: invokevirtual 509	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;I)I
    //   193: iconst_1
    //   194: if_icmpne +249 -> 443
    //   197: iconst_1
    //   198: istore_3
    //   199: aload_0
    //   200: iload_3
    //   201: invokevirtual 522	com/tencent/ditto/widget/DittoTextArea:setTextBold	(Z)V
    //   204: aload_1
    //   205: ldc 44
    //   207: aconst_null
    //   208: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: ifnull +26 -> 237
    //   214: aload_1
    //   215: ldc 44
    //   217: aconst_null
    //   218: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 4
    //   223: aload 4
    //   225: invokestatic 490	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +9 -> 237
    //   231: aload_0
    //   232: aload 4
    //   234: invokevirtual 525	com/tencent/ditto/widget/DittoTextArea:setText	(Ljava/lang/String;)V
    //   237: ldc_w 526
    //   240: astore 4
    //   242: aload_1
    //   243: ldc 47
    //   245: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   248: ifeq +14 -> 262
    //   251: aload_1
    //   252: ldc 47
    //   254: ldc_w 526
    //   257: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 208	java/lang/String:hashCode	()I
    //   267: lookupswitch	default:+33->300, -1371700497:+211->478, -1047432319:+181->448, 1015327489:+195->462
    //   301: istore_2
    //   302: iload_2
    //   303: tableswitch	default:+25 -> 328, 0:+191->494, 1:+389->692, 2:+399->702
    //   329: iconst_m1
    //   330: bipush 89
    //   332: new 177	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 530
    //   342: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 4
    //   347: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 532
    //   353: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokespecial 534	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   362: athrow
    //   363: astore 5
    //   365: ldc_w 536
    //   368: new 177	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 538
    //   378: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 4
    //   383: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w 540
    //   389: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: aload 5
    //   397: invokestatic 546	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   400: goto -309 -> 91
    //   403: astore 5
    //   405: ldc_w 536
    //   408: new 177	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 538
    //   418: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 4
    //   423: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 540
    //   429: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: aload 5
    //   437: invokestatic 546	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   440: goto -326 -> 114
    //   443: iconst_0
    //   444: istore_3
    //   445: goto -246 -> 199
    //   448: aload 4
    //   450: ldc_w 526
    //   453: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifeq -156 -> 300
    //   459: goto -157 -> 302
    //   462: aload 4
    //   464: ldc_w 548
    //   467: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifeq -170 -> 300
    //   473: iconst_1
    //   474: istore_2
    //   475: goto -173 -> 302
    //   478: aload 4
    //   480: ldc_w 550
    //   483: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   486: ifeq -186 -> 300
    //   489: iconst_2
    //   490: istore_2
    //   491: goto -189 -> 302
    //   494: aload_0
    //   495: getstatic 138	android/text/Layout$Alignment:ALIGN_NORMAL	Landroid/text/Layout$Alignment;
    //   498: putfield 140	com/tencent/ditto/widget/DittoTextArea:mLayoutAlignment	Landroid/text/Layout$Alignment;
    //   501: aload_1
    //   502: ldc 31
    //   504: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   507: ifeq +14 -> 521
    //   510: aload_0
    //   511: aload_1
    //   512: ldc 31
    //   514: fconst_0
    //   515: invokevirtual 553	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;F)F
    //   518: putfield 147	com/tencent/ditto/widget/DittoTextArea:shadowDx	F
    //   521: aload_1
    //   522: ldc 35
    //   524: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   527: ifeq +14 -> 541
    //   530: aload_0
    //   531: aload_1
    //   532: ldc 35
    //   534: fconst_0
    //   535: invokevirtual 553	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;F)F
    //   538: putfield 149	com/tencent/ditto/widget/DittoTextArea:shadowDy	F
    //   541: aload_1
    //   542: ldc 39
    //   544: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   547: ifeq +14 -> 561
    //   550: aload_0
    //   551: aload_1
    //   552: ldc 39
    //   554: fconst_0
    //   555: invokevirtual 553	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;F)F
    //   558: putfield 151	com/tencent/ditto/widget/DittoTextArea:shadowRadius	F
    //   561: aload_1
    //   562: ldc 27
    //   564: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   567: ifeq +23 -> 590
    //   570: aload_1
    //   571: ldc 27
    //   573: ldc_w 555
    //   576: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   579: astore 4
    //   581: aload_0
    //   582: aload 4
    //   584: invokestatic 496	com/tencent/ditto/utils/DittoResourcesUtil:parseColor	(Ljava/lang/String;)I
    //   587: putfield 153	com/tencent/ditto/widget/DittoTextArea:shadowBgColor	I
    //   590: aload_1
    //   591: ldc 14
    //   593: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   596: ifeq +14 -> 610
    //   599: aload_0
    //   600: aload_1
    //   601: ldc 14
    //   603: fconst_0
    //   604: invokevirtual 553	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;F)F
    //   607: invokevirtual 558	com/tencent/ditto/widget/DittoTextArea:setLetterSpace	(F)V
    //   610: aload_0
    //   611: getfield 147	com/tencent/ditto/widget/DittoTextArea:shadowDx	F
    //   614: ldc 145
    //   616: fcmpl
    //   617: ifeq +53 -> 670
    //   620: aload_0
    //   621: getfield 149	com/tencent/ditto/widget/DittoTextArea:shadowDy	F
    //   624: ldc 145
    //   626: fcmpl
    //   627: ifeq +43 -> 670
    //   630: aload_0
    //   631: getfield 151	com/tencent/ditto/widget/DittoTextArea:shadowRadius	F
    //   634: ldc 145
    //   636: fcmpl
    //   637: ifeq +33 -> 670
    //   640: aload_0
    //   641: getfield 153	com/tencent/ditto/widget/DittoTextArea:shadowBgColor	I
    //   644: ifeq +26 -> 670
    //   647: aload_0
    //   648: getfield 250	com/tencent/ditto/widget/DittoTextArea:mPaint	Landroid/text/TextPaint;
    //   651: aload_0
    //   652: getfield 151	com/tencent/ditto/widget/DittoTextArea:shadowRadius	F
    //   655: aload_0
    //   656: getfield 147	com/tencent/ditto/widget/DittoTextArea:shadowDx	F
    //   659: aload_0
    //   660: getfield 149	com/tencent/ditto/widget/DittoTextArea:shadowDy	F
    //   663: aload_0
    //   664: getfield 153	com/tencent/ditto/widget/DittoTextArea:shadowBgColor	I
    //   667: invokevirtual 562	android/text/TextPaint:setShadowLayer	(FFFI)V
    //   670: aload_1
    //   671: ldc 8
    //   673: invokevirtual 506	com/tencent/ditto/shell/LayoutAttrSet:hasAttr	(Ljava/lang/String;)Z
    //   676: ifeq +15 -> 691
    //   679: aload_0
    //   680: aload_1
    //   681: ldc 8
    //   683: ldc 162
    //   685: invokevirtual 484	com/tencent/ditto/shell/LayoutAttrSet:getAttr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   688: invokevirtual 564	com/tencent/ditto/widget/DittoTextArea:setFontFamily	(Ljava/lang/String;)V
    //   691: return
    //   692: aload_0
    //   693: getstatic 566	android/text/Layout$Alignment:ALIGN_OPPOSITE	Landroid/text/Layout$Alignment;
    //   696: putfield 140	com/tencent/ditto/widget/DittoTextArea:mLayoutAlignment	Landroid/text/Layout$Alignment;
    //   699: goto -198 -> 501
    //   702: aload_0
    //   703: getstatic 568	android/text/Layout$Alignment:ALIGN_CENTER	Landroid/text/Layout$Alignment;
    //   706: putfield 140	com/tencent/ditto/widget/DittoTextArea:mLayoutAlignment	Landroid/text/Layout$Alignment;
    //   709: goto -208 -> 501
    //   712: astore 5
    //   714: aconst_null
    //   715: astore 4
    //   717: ldc_w 536
    //   720: new 177	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 538
    //   730: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 4
    //   735: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc_w 540
    //   741: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: aload 5
    //   749: invokestatic 546	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   752: goto -162 -> 590
    //   755: astore 5
    //   757: goto -40 -> 717
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	DittoTextArea
    //   0	760	1	paramLayoutAttrSet	LayoutAttrSet
    //   1	490	2	i	int
    //   198	247	3	bool	boolean
    //   72	662	4	str	String
    //   363	33	5	localThrowable1	Throwable
    //   403	33	5	localThrowable2	Throwable
    //   712	36	5	localThrowable3	Throwable
    //   755	1	5	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   82	91	363	java/lang/Throwable
    //   105	114	403	java/lang/Throwable
    //   570	581	712	java/lang/Throwable
    //   581	590	755	java/lang/Throwable
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
    if ((paramString1 == null) || (paramInt <= 0)) {
      return;
    }
    if (paramString1.length() <= paramInt) {}
    for (this.mText = paramString1;; this.mText = (paramString1.substring(0, paramInt - 1) + paramString2))
    {
      this.isDirty = true;
      requestLayout();
      return;
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
    boolean bool = false;
    int i;
    if (this.mPaint != null)
    {
      if (paramInt <= 0) {
        break label106;
      }
      if (paramTypeface != null) {
        break label86;
      }
      paramTypeface = Typeface.defaultFromStyle(paramInt);
      setTypeface(paramTypeface);
      if (paramTypeface == null) {
        break label95;
      }
      i = paramTypeface.getStyle();
      label38:
      paramInt = (i ^ 0xFFFFFFFF) & paramInt;
      paramTypeface = this.mPaint;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramTypeface.setFakeBoldText(bool);
      paramTypeface = this.mPaint;
      if ((paramInt & 0x2) == 0) {
        break label101;
      }
    }
    label86:
    label95:
    label101:
    for (float f = -0.25F;; f = 0.0F)
    {
      paramTypeface.setTextSkewX(f);
      return;
      paramTypeface = Typeface.create(paramTypeface, paramInt);
      break;
      i = 0;
      break label38;
    }
    label106:
    this.mPaint.setFakeBoldText(false);
    this.mPaint.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoTextArea
 * JD-Core Version:    0.7.0.1
 */