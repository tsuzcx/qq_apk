package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class PickerFore
{
  private int a = -1;
  private int b = 6;
  private Paint c;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private RectF g = new RectF();
  
  public int a(float paramFloat)
  {
    if (!this.g.isEmpty())
    {
      float f4 = this.g.height() / (this.b + 1);
      int i = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      float f3;
      for (;;)
      {
        f3 = f1;
        if (i >= this.b) {
          break;
        }
        f1 = i * f4 + f4 + this.g.top;
        f3 = f1;
        if (paramFloat <= f1) {
          break;
        }
        i += 1;
        f2 = f1;
      }
      int j = this.b;
      if (i == j) {
        return j - 1;
      }
      if (i == 0) {
        return 0;
      }
      if (paramFloat - f2 > f3 - paramFloat) {
        return i;
      }
      return i - 1;
    }
    return 0;
  }
  
  public RectF a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.b) {
        return null;
      }
      if (this.g.isEmpty()) {
        return null;
      }
      float f2 = this.g.height() / (this.b + 1);
      float f1 = this.g.width() / 2.0F;
      f2 = f2 + paramInt * f2 + this.g.top;
      float f3 = this.f;
      return new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCanvas == null) {
      return;
    }
    float f2 = this.g.width();
    float f3 = this.e;
    float f4 = this.d;
    float f1 = this.g.height() / (this.b + 1);
    f2 = (f2 - f3 - f4) / 2.0F + this.d;
    int i = 0;
    while (i < this.b)
    {
      f3 = i * f1 + f1 + this.g.top;
      if ((i != this.b - 1) || (i != paramInt2))
      {
        int j;
        if (i == this.b - 1)
        {
          j = this.c.getAlpha();
          this.c.setAlpha(paramInt1);
          paramCanvas.drawCircle(f2, f3, this.f, this.c);
          this.c.setAlpha(j);
        }
        else if (i == paramInt2)
        {
          j = this.c.getAlpha();
          this.c.setAlpha(paramInt3);
          paramCanvas.drawCircle(f2, f3, this.f, this.c);
          this.c.setAlpha(j);
        }
        else
        {
          j = this.c.getAlpha();
          this.c.setAlpha(paramInt4);
          paramCanvas.drawCircle(f2, f3, this.f, this.c);
          this.c.setAlpha(j);
        }
      }
      i += 1;
    }
  }
  
  public void a(RectF paramRectF)
  {
    if (paramRectF != null) {
      this.g.set(paramRectF);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b = paramInt2;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.a = paramInt1;
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setAntiAlias(true);
    }
    this.c.setColor(this.a);
    this.f = paramFloat1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerFore
 * JD-Core Version:    0.7.0.1
 */