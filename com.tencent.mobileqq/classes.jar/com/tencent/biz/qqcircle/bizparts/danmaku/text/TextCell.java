package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class TextCell
  implements Serializable, Cloneable
{
  protected static double FADE_LENGTH = ViewUtils.a(10.0F);
  protected static double FADE_SCALE = 200.0D;
  protected static double FADE_START_INTERVAL = 100.0D;
  public static final int FLAG_EMO = 256;
  public static final int FLAG_EMO_MASK = 1044480;
  public static final int FLAG_EMO_SEQ = 4096;
  public static final int FLAG_LINEBREAK_MASK = 267386880;
  public static final int FLAG_LINEBREAK_SEQ = 1048576;
  public static final int FLAG_TYPE_MASK = 255;
  public static final int SIGN_ADV_SUMMARY = 17;
  public static final int SIGN_COLOR = 9;
  public static final int SIGN_COMMENT = 7;
  public static final int SIGN_ELLIPSIS = 20;
  public static final int SIGN_FEED_OWNER = 6;
  public static final int SIGN_GOTO_DETAIL = 5;
  public static final int SIGN_LIKE_NICKNAME = 19;
  public static final int SIGN_LINEBREAK = 16;
  public static final int SIGN_MORE = 10;
  public static final int SIGN_NORMAL = 0;
  public static final int SIGN_PACK_OR_UNPACK = 18;
  public static final int SIGN_REPLY = 8;
  public static final int SIGN_TOPIC = 1;
  public static final int SIGN_URL = 4;
  public static final int SIGN_USER = 3;
  public static final int SIGN_WALL = 2;
  static final String ellipsis = "...";
  private static final long serialVersionUID = 5342730555874002105L;
  private boolean canCopy = true;
  public int cellIndex = 0;
  public int commentSpanHeight = 0;
  protected float fontSize;
  public boolean isDrawableLoaded = true;
  public boolean isPresseding = false;
  public MotionEvent lastClickEvent = null;
  public int linebreak = 0;
  public int linebreakSeq = 0;
  protected int linkColor;
  protected float mAscent = -1.0F;
  protected float mDefaultAscent = -1.0F;
  protected float mDefaultDescent = -1.0F;
  protected float mDescent = -1.0F;
  protected String mFontFamilyUrl;
  protected int mShadowColor;
  protected int mShadowRadius;
  protected int mShadowX;
  protected int mShadowY;
  public int maxCommentHeight = 0;
  public boolean needHighLight = false;
  private Pair<Integer, Integer> points;
  public String post;
  public transient Rect rect;
  public String text;
  protected int textColor;
  public int type = 0;
  protected Long uin;
  private String url;
  public boolean useDefaultFont = false;
  protected boolean useHanyiColorFont = true;
  public boolean useSuperFont = true;
  
  public TextCell()
  {
    this.type = 0;
  }
  
  public TextCell(int paramInt)
  {
    this.type = paramInt;
  }
  
  public TextCell(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.text = paramString;
  }
  
  private float a(Paint paramPaint)
  {
    boolean bool = TextUtils.isEmpty(this.text);
    float f = 0.0F;
    if (bool) {
      return 0.0F;
    }
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    int k = this.text.length();
    int j;
    for (int i = 0; i < k; i = j)
    {
      j = Character.charCount(this.text.codePointAt(i));
      paramPaint = this.text;
      j += i;
      f += localPaint.measureText(paramPaint, i, j);
    }
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    return f;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, String paramString, Rect paramRect, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    paramPaint.setAlpha(paramInt3);
    if ((paramPaint instanceof ETPaint))
    {
      ((ETPaint)paramPaint).a(paramString, paramInt1, paramRect.left, paramRect.top, paramCanvas, paramBitmap);
      return;
    }
    paramCanvas.drawText(paramString, paramRect.left, paramInt2, paramPaint);
  }
  
  public boolean canBreak()
  {
    return true;
  }
  
  public boolean canCopy()
  {
    return this.canCopy;
  }
  
  public boolean clickable()
  {
    int i = this.type & 0xFF;
    return (i != 0) && (i != 16) && (i != 7) && (i != 8);
  }
  
  public TextCell copy()
  {
    try
    {
      TextCell localTextCell = (TextCell)clone();
      return localTextCell;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    if ((this.type & 0xFF) == 0) {
      localPaint.setColor(paramInt2);
    } else {
      localPaint.setColor(paramInt3);
    }
    boolean bool = this.useSuperFont;
    Shader localShader = null;
    float f = 0.0F;
    if (!bool)
    {
      localShader = localPaint.getShader();
      localPaint.setShader(null);
      localPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      f = localPaint.getTextSize();
      localPaint.setTextSize(this.fontSize);
    }
    paramInt2 = paramRect.top;
    paramInt3 = (int)((paramInt1 - getDescent(localPaint) - getAscent(localPaint)) / 2.0F);
    paramPaint = this.text;
    if (paramPaint.endsWith("\r\n")) {
      paramPaint = this.text;
    }
    for (paramPaint = paramPaint.substring(0, paramPaint.length() - 2);; paramPaint = paramPaint.substring(0, paramPaint.length() - 1))
    {
      break;
      if (!this.text.endsWith("\n")) {
        break;
      }
      paramPaint = this.text;
    }
    if (!TextUtils.isEmpty(this.mFontFamilyUrl)) {
      RFWTypefaceUtil.b(localPaint, this.mFontFamilyUrl);
    }
    try
    {
      if ((localPaint instanceof ETPaint)) {
        ((ETPaint)localPaint).a(paramPaint, paramInt1, paramRect.left, paramRect.top, paramCanvas, paramBitmap);
      } else {
        paramCanvas.drawText(paramPaint, paramRect.left, paramInt2 + paramInt3, localPaint);
      }
    }
    catch (Throwable paramCanvas)
    {
      QLog.e("TextCell", 1, paramCanvas.getMessage());
    }
    localPaint.setTypeface(localTypeface);
    if (!this.useSuperFont)
    {
      localPaint.setTextSize(f);
      localPaint.setShader(localShader);
      localPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
    }
  }
  
  public boolean fadedDraw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, long paramLong)
  {
    Object localObject = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    if ((this.type & 0xFF) == 0) {
      localPaint.setColor(paramInt2);
    } else {
      localPaint.setColor(paramInt3);
    }
    int i = paramRect.top + (int)((paramInt1 - getDescent(localPaint) - getAscent(localPaint)) / 2.0F);
    paramPaint = this.text;
    if (paramPaint.endsWith("\r\n"))
    {
      paramPaint = this.text;
      paramPaint = paramPaint.substring(0, paramPaint.length() - 2);
    }
    else if (this.text.endsWith("\n"))
    {
      paramPaint = this.text;
      paramPaint = paramPaint.substring(0, paramPaint.length() - 1);
    }
    if (localObject != null) {
      localPaint.setTypeface((Typeface)localObject);
    }
    double d2 = paramLong;
    double d1 = FADE_START_INTERVAL;
    Double.isNaN(d2);
    paramInt2 = (int)Math.floor(d2 / d1) - paramInt4;
    boolean bool;
    if (paramInt2 >= paramPaint.length())
    {
      paramInt2 = paramPaint.length();
      bool = false;
    }
    else
    {
      if (paramInt2 < 0) {
        paramInt2 = 0;
      }
      bool = true;
    }
    int j = localPaint.getAlpha();
    if (paramInt2 > 0) {
      a(paramCanvas, localPaint, paramInt1, paramPaint.substring(0, paramInt2), paramRect, i, paramBitmap, 255);
    }
    localObject = HardCodeUtil.a(2131912169);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append((String)localObject);
    d1 = localPaint.measureText(localStringBuilder.toString()) - localPaint.measureText((String)localObject) * 2.0F;
    while (paramInt2 < paramPaint.length())
    {
      double d3 = paramInt2 + paramInt4;
      double d4 = FADE_START_INTERVAL;
      Double.isNaN(d3);
      Double.isNaN(d2);
      d3 = d2 - d3 * d4;
      if (d3 <= 0.0D) {
        break;
      }
      d4 = FADE_SCALE;
      d3 = d3 % d4 / d4;
      int k = (int)(255.0D * d3);
      paramInt3 = (int)((1.0D - d3) * FADE_LENGTH) + paramRect.left;
      if (paramInt2 != 0)
      {
        d3 = paramInt3;
        d4 = (int)localPaint.measureText(paramPaint, 0, paramInt2);
        Double.isNaN(d4);
        Double.isNaN(d1);
        Double.isNaN(d3);
        paramInt3 = (int)(d3 + (d4 + d1));
      }
      localObject = new Rect(paramRect);
      ((Rect)localObject).left = paramInt3;
      paramInt3 = paramInt2 + 1;
      a(paramCanvas, localPaint, paramInt1, paramPaint.substring(paramInt2, paramInt3), (Rect)localObject, i, paramBitmap, k);
      paramInt2 = paramInt3;
    }
    localPaint.setAlpha(j);
    return bool;
  }
  
  protected float getAscent(Paint paramPaint)
  {
    if ((!this.useDefaultFont) && (this.useHanyiColorFont) && (this.useSuperFont))
    {
      float f2 = this.mAscent;
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = paramPaint.ascent();
      }
      return f1;
    }
    if (this.mDefaultAscent <= 0.0F) {
      this.mDefaultAscent = paramPaint.ascent();
    }
    return this.mDefaultAscent;
  }
  
  protected float getDescent(Paint paramPaint)
  {
    if ((!this.useDefaultFont) && (this.useHanyiColorFont) && (this.useSuperFont))
    {
      float f2 = this.mDescent;
      float f1 = f2;
      if (f2 <= 0.0F) {
        f1 = paramPaint.descent();
      }
      return f1;
    }
    if (this.mDefaultDescent <= 0.0F) {
      this.mDefaultDescent = paramPaint.descent();
    }
    return this.mDefaultDescent;
  }
  
  public int getDrawTextLength()
  {
    if (this.text.endsWith("\r\n")) {
      return this.text.length() - 2;
    }
    if (this.text.endsWith("\n")) {
      return this.text.length() - 1;
    }
    return this.text.length();
  }
  
  public int getHeight(Paint paramPaint)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    int i = (int)(getDescent(localPaint) - getAscent(localPaint));
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    return i;
  }
  
  public Intent getIntent()
  {
    return null;
  }
  
  public int getLength()
  {
    String str = this.text;
    if (str != null) {
      return str.length();
    }
    return 0;
  }
  
  public Pair<Integer, Integer> getPoint()
  {
    return this.points;
  }
  
  public String getPost()
  {
    if (!TextUtils.isEmpty(this.post)) {
      return this.post;
    }
    return "";
  }
  
  public ClickableSpan getSpan()
  {
    return new TextCell.1(this);
  }
  
  public String getText()
  {
    String str2 = this.text;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public Long getUin()
  {
    return this.uin;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public float getWidth(Paint paramPaint)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    float f = localPaint.measureText(this.text);
    if (f <= 0.0F) {
      f = a(localPaint);
    }
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    return f;
  }
  
  public int getWidths(Paint paramPaint, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (TextUtils.isEmpty(this.text)) {
      return 0;
    }
    int i = paramInt2 + paramInt1;
    paramInt2 = i;
    if (i > this.text.length()) {
      paramInt2 = this.text.length();
    }
    if (paramInt1 >= paramInt2) {
      return 0;
    }
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof ETPaint)) {
        localPaint = ((ETPaint)paramPaint).a();
      }
    }
    paramInt1 = localPaint.getTextWidths(this.text, paramInt1, paramInt2, paramArrayOfFloat);
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    return paramInt1;
  }
  
  protected Typeface initFontInfo(Paint paramPaint)
  {
    Paint localPaint1;
    int i;
    Paint localPaint2;
    if ((!this.useHanyiColorFont) && ((paramPaint instanceof ETPaint)))
    {
      localPaint1 = ((ETPaint)paramPaint).a();
      paramPaint = localPaint1.getTypeface();
      localPaint1.setTypeface(null);
      i = 1;
    }
    else
    {
      i = 0;
      localPaint2 = null;
      localPaint1 = paramPaint;
      paramPaint = localPaint2;
    }
    Object localObject = paramPaint;
    if (this.useDefaultFont)
    {
      localPaint2 = localPaint1;
      if ((localPaint1 instanceof ETPaint)) {
        localPaint2 = ((ETPaint)localPaint1).a();
      }
      localObject = paramPaint;
      if (i == 0)
      {
        localObject = localPaint2.getTypeface();
        localPaint2.setTypeface(null);
      }
    }
    return localObject;
  }
  
  public boolean isEmo()
  {
    return false;
  }
  
  public void setCanCopy(boolean paramBoolean)
  {
    this.canCopy = paramBoolean;
  }
  
  public void setDefaultShadowLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mShadowRadius = paramInt1;
    this.mShadowX = paramInt2;
    this.mShadowY = paramInt3;
    this.mShadowColor = paramInt4;
  }
  
  public void setFontFamilyUrl(String paramString)
  {
    this.mFontFamilyUrl = paramString;
  }
  
  public void setFontSize(Paint paramPaint, float paramFloat)
  {
    this.fontSize = paramFloat;
    this.mDescent = paramPaint.descent();
    this.mAscent = paramPaint.ascent();
    this.mDefaultDescent = -1.0F;
    this.mDefaultAscent = -1.0F;
  }
  
  public void setLinkColor(int paramInt)
  {
    this.linkColor = paramInt;
  }
  
  public void setPoint(int paramInt1, int paramInt2)
  {
    this.points = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void setPost(String paramString)
  {
    this.post = paramString;
  }
  
  public void setUin(Long paramLong)
  {
    this.uin = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell
 * JD-Core Version:    0.7.0.1
 */