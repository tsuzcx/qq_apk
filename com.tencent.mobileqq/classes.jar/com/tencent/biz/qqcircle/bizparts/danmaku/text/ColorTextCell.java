package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;

public class ColorTextCell
  extends TextCell
{
  private static final long serialVersionUID = -7171491901412815564L;
  protected boolean bold;
  private boolean clickable = true;
  
  public ColorTextCell()
  {
    super(0);
  }
  
  public ColorTextCell(int paramInt)
  {
    super(paramInt);
  }
  
  public ColorTextCell(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public ColorTextCell(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString);
    this.textColor = paramInt2;
  }
  
  public boolean clickable()
  {
    boolean bool = super.clickable();
    return (this.clickable) && (bool);
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
    if (((this.type & 0xFF) != 0) && (this.type != 3) && (this.type != 4) && (this.type != 5) && (this.type != 6) && (this.type != 18)) {
      localPaint.setColor(this.textColor);
    } else {
      localPaint.setColor(paramInt3);
    }
    boolean bool1 = localPaint.isFakeBoldText();
    boolean bool2 = this.bold;
    if (bool2) {
      localPaint.setFakeBoldText(bool2);
    }
    bool2 = this.useSuperFont;
    float f = 0.0F;
    Shader localShader;
    if (!bool2)
    {
      localShader = localPaint.getShader();
      localPaint.setShader(null);
      localPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      f = localPaint.getTextSize();
      localPaint.setTextSize(this.fontSize);
    }
    else
    {
      localShader = null;
    }
    paramInt2 = paramRect.top;
    paramInt3 = (int)((paramInt1 - getDescent(localPaint) - getAscent(localPaint)) / 2.0F);
    paramPaint = this.text;
    if (this.text.endsWith("\r\n")) {}
    for (paramPaint = this.text.substring(0, this.text.length() - 2);; paramPaint = this.text.substring(0, this.text.length() - 1))
    {
      break;
      if (!this.text.endsWith("\n")) {
        break;
      }
    }
    if (this.bold) {
      localPaint.setFakeBoldText(bool1);
    }
    if (!TextUtils.isEmpty(this.mFontFamilyUrl)) {
      RFWTypefaceUtil.b(localPaint, this.mFontFamilyUrl);
    }
    if (!this.useSuperFont)
    {
      localPaint.setTextSize(f);
      localPaint.setShader(localShader);
      localPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
    }
    if (!TextUtils.isEmpty(paramPaint)) {
      if ((localPaint instanceof ETPaint)) {
        ((ETPaint)localPaint).a(paramPaint, paramInt1, paramRect.left, paramRect.top, paramCanvas, paramBitmap);
      } else {
        paramCanvas.drawText(paramPaint, paramRect.left, paramInt2 + paramInt3, localPaint);
      }
    }
    localPaint.setTypeface(localTypeface);
    if (!this.useSuperFont)
    {
      localPaint.setTextSize(f);
      localPaint.setShader(localShader);
      localPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
    }
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.clickable = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.bold = paramBoolean;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ColorTextCell
 * JD-Core Version:    0.7.0.1
 */