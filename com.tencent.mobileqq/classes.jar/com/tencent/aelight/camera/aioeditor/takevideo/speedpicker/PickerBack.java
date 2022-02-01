package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class PickerBack
{
  private int a = 0;
  private Paint b;
  private RectF c = new RectF();
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 1.0F;
  
  public void a() {}
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.a = paramInt;
    this.d = paramFloat1;
    this.e = paramFloat2;
    if (this.b == null)
    {
      this.b = new Paint();
      this.b.setAntiAlias(true);
    }
    this.b.setColor(this.a);
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (paramCanvas == null) {
      return;
    }
    this.b.setAlpha(paramInt);
    float f2 = this.c.width() - this.d - this.e;
    float f1 = this.f * f2;
    paramCanvas.save();
    RectF localRectF = new RectF(this.c.left + this.d, this.c.top, this.c.left + this.d + f2, this.c.top + f1);
    f2 = localRectF.left;
    float f3 = localRectF.top;
    float f4 = localRectF.right;
    float f5 = localRectF.top;
    float f6 = f1 / 2.0F;
    paramCanvas.clipRect(f2, f3, f4, f5 + f6);
    paramCanvas.drawOval(localRectF, this.b);
    paramCanvas.restore();
    paramCanvas.save();
    localRectF.top = (this.c.bottom - f1);
    localRectF.bottom = this.c.bottom;
    paramCanvas.clipRect(localRectF.left, localRectF.top + f6, localRectF.right, localRectF.bottom);
    paramCanvas.drawOval(localRectF, this.b);
    paramCanvas.restore();
    localRectF.top = Math.round(this.c.top + f6);
    localRectF.bottom = Math.round(this.c.bottom - f6);
    paramCanvas.drawRect(localRectF, this.b);
  }
  
  public void a(RectF paramRectF)
  {
    this.c.set(paramRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBack
 * JD-Core Version:    0.7.0.1
 */