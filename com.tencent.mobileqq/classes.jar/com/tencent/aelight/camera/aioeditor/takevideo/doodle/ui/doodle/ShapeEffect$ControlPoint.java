package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;

abstract class ShapeEffect$ControlPoint
{
  private float jdField_a_of_type_Float;
  private float b;
  
  protected ShapeEffect$ControlPoint(ShapeEffect paramShapeEffect) {}
  
  protected void a(MotionEvent paramMotionEvent) {}
  
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
        float f1 = (paramMotionEvent.getX() - this.jdField_a_of_type_Float) / ShapeEffect.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
        float f2 = (paramMotionEvent.getY() - this.b) / ShapeEffect.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.b = paramMotionEvent.getY();
        a(paramMotionEvent, f1, f2);
        return true;
      }
      b(paramMotionEvent);
      return true;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.b = paramMotionEvent.getY();
    a(paramMotionEvent);
    return true;
  }
  
  protected void b(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.ControlPoint
 * JD-Core Version:    0.7.0.1
 */