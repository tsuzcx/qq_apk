package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;

abstract class ShapeEffect$ControlPoint
{
  private float b;
  private float c;
  
  protected ShapeEffect$ControlPoint(ShapeEffect paramShapeEffect) {}
  
  protected void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return i == 3;
        }
        float f1 = (paramMotionEvent.getX() - this.b) / ShapeEffect.a(this.a);
        float f2 = (paramMotionEvent.getY() - this.c) / ShapeEffect.a(this.a);
        this.b = paramMotionEvent.getX();
        this.c = paramMotionEvent.getY();
        a(paramMotionEvent, f1, f2);
        return true;
      }
      c(paramMotionEvent);
      return true;
    }
    this.b = paramMotionEvent.getX();
    this.c = paramMotionEvent.getY();
    b(paramMotionEvent);
    return true;
  }
  
  protected void b(MotionEvent paramMotionEvent) {}
  
  protected void c(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.ControlPoint
 * JD-Core Version:    0.7.0.1
 */