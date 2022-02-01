package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.view.MotionEvent;

class ShapeEffect$RotatePoint
  extends ShapeEffect.ControlPoint
{
  private float c;
  private float d;
  private float e;
  
  private ShapeEffect$RotatePoint(ShapeEffect paramShapeEffect)
  {
    super(paramShapeEffect);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - ShapeEffect.f(this.b)) / ShapeEffect.a(this.b);
    float f2 = (paramMotionEvent.getY() - ShapeEffect.g(this.b)) / ShapeEffect.a(this.b);
    PointF localPointF = this.b.e();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          f1 -= localPointF.x;
          f2 -= localPointF.y;
          float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          float f4 = this.c;
          float f5 = this.d;
          f4 = (float)Math.sqrt(f4 * f4 + f5 * f5);
          if (f3 != 0.0F)
          {
            f4 = (float)(Math.asin((this.c * f2 - this.d * f1) / (f4 * f3)) * 180.0D / 3.141592653589793D);
            if (this.e != 0.0F) {
              this.b.a(f4);
            }
          }
          this.c = f1;
          this.d = f2;
          this.e = f3;
        }
      }
      return true;
    }
    this.e = 0.0F;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.RotatePoint
 * JD-Core Version:    0.7.0.1
 */