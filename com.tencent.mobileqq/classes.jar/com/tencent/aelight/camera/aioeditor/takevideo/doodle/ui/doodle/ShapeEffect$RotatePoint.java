package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.view.MotionEvent;

class ShapeEffect$RotatePoint
  extends ShapeEffect.ControlPoint
{
  private float a;
  private float jdField_b_of_type_Float;
  private float c;
  
  private ShapeEffect$RotatePoint(ShapeEffect paramShapeEffect)
  {
    super(paramShapeEffect);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - ShapeEffect.b(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect)) / ShapeEffect.a(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
    float f2 = (paramMotionEvent.getY() - ShapeEffect.c(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect)) / ShapeEffect.a(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
    PointF localPointF = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect.a();
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
          float f4 = this.a;
          float f5 = this.jdField_b_of_type_Float;
          f4 = (float)Math.sqrt(f4 * f4 + f5 * f5);
          if (f3 != 0.0F)
          {
            f4 = (float)(Math.asin((this.a * f2 - this.jdField_b_of_type_Float * f1) / (f4 * f3)) * 180.0D / 3.141592653589793D);
            if (this.c != 0.0F) {
              this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect.a(f4);
            }
          }
          this.a = f1;
          this.jdField_b_of_type_Float = f2;
          this.c = f3;
        }
      }
      return true;
    }
    this.c = 0.0F;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.RotatePoint
 * JD-Core Version:    0.7.0.1
 */