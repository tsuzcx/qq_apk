package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;

public class PerLineModel
  extends BaseTextModel
{
  protected String e;
  protected float f;
  
  public PerLineModel(int paramInt1, int paramInt2, TextPaint paramTextPaint, String paramString, RectF paramRectF, float paramFloat)
  {
    super(paramInt1, paramInt2, paramTextPaint, paramRectF);
    this.e = paramString;
    this.f = paramFloat;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    String str = this.e;
    paramCanvas.drawText(str, 0, str.length(), paramInt1 + this.c.left, paramInt2 + this.f + this.c.top, this.d);
  }
  
  public void a(Canvas paramCanvas, BaseBackgroundDrawer paramBaseBackgroundDrawer, int paramInt1, int paramInt2)
  {
    paramBaseBackgroundDrawer.a(paramCanvas, this.c, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PerLineModel
 * JD-Core Version:    0.7.0.1
 */