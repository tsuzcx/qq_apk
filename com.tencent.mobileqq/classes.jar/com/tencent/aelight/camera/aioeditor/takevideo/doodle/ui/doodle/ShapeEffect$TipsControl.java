package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;

class ShapeEffect$TipsControl
  extends ShapeEffect.ControlPoint
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private float jdField_b_of_type_Float;
  
  private ShapeEffect$TipsControl(ShapeEffect paramShapeEffect, Context paramContext)
  {
    super(paramShapeEffect);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      boolean bool2 = false;
      if (i != 1) {
        return false;
      }
      long l = paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime();
      boolean bool1;
      if (l <= ShapeEffect.b()) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      float f1 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
      float f2 = paramMotionEvent.getY() - this.jdField_b_of_type_Float;
      if (Math.sqrt(f1 * f1 + f2 * f2) <= ShapeEffect.c()) {
        bool2 = true;
      }
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleTouchEvent--UP--elapse=");
      paramMotionEvent.append(l);
      paramMotionEvent.append(", inTapTime=");
      paramMotionEvent.append(bool1);
      paramMotionEvent.append(", inTapDis=");
      paramMotionEvent.append(bool2);
      AEQLog.a("TipsControl", paramMotionEvent.toString());
      if ((bool1) && (bool2)) {
        ShapeEffect.c(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
      }
      return true;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect.TipsControl
 * JD-Core Version:    0.7.0.1
 */