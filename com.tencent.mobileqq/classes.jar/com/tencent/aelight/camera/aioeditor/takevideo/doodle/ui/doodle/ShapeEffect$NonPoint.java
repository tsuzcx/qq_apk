package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;

class ShapeEffect$NonPoint
  extends ShapeEffect.ControlPoint
{
  private ShapeEffect$NonPoint(ShapeEffect paramShapeEffect)
  {
    super(paramShapeEffect);
  }
  
  protected void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    this.b.a(paramFloat1, paramFloat2);
    if (ShapeEffect.b(this.b) != null) {
      ShapeEffect.b(this.b).b(this.b, paramMotionEvent);
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (ShapeEffect.b(this.b) != null) {
      ShapeEffect.b(this.b).a(this.b, paramMotionEvent);
    }
  }
  
  protected void c(MotionEvent paramMotionEvent)
  {
    if (ShapeEffect.b(this.b) != null) {
      ShapeEffect.b(this.b).c(this.b, paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.NonPoint
 * JD-Core Version:    0.7.0.1
 */