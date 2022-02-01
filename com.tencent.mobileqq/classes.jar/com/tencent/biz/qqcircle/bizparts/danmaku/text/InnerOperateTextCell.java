package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

public class InnerOperateTextCell
  extends ColorTextCell
{
  public InnerOperateTextCell(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if ((paramPaint instanceof ETPaint))
    {
      localObject = (ETPaint)paramPaint;
      if ((((ETPaint)localObject).d()) && (!((ETPaint)localObject).a)) {
        return;
      }
    }
    Object localObject = paramPaint.getShader();
    paramPaint.setShader(null);
    paramPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    float f = paramPaint.getTextSize();
    paramPaint.setTextSize(this.fontSize);
    super.draw(paramCanvas, paramPaint, paramInt1, paramRect, this.linkColor, this.linkColor, paramBitmap);
    paramPaint.setTextSize(f);
    paramPaint.setShader((Shader)localObject);
    paramPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.InnerOperateTextCell
 * JD-Core Version:    0.7.0.1
 */