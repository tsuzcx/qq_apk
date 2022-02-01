package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$ShapeLayerTouchListener
  implements BaseLayer.OnLayerTouchListener<ShapeLayer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  
  private DoodleLayout$ShapeLayerTouchListener(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(10);
    if (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout) > System.currentTimeMillis())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(10, Boolean.valueOf(false));
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(10, Boolean.valueOf(true));
      if (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout).getVisibility() == 0) {
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, false, true);
      }
    }
    DoodleLayout.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "LineLayer draw move hide");
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 10)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(9, Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(9);
      DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 9)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(9, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(9);
      DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
  }
  
  public boolean a(ShapeLayer paramShapeLayer, MotionEvent paramMotionEvent)
  {
    int i = Math.round(paramMotionEvent.getY());
    int j = Math.round(paramMotionEvent.getX());
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return false;
          }
        }
        else
        {
          if (((Math.abs(j - this.jdField_a_of_type_Int) >= 3) || (Math.abs(i - this.b) >= 3)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h != 11) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h != 10)) {
            if (!paramShapeLayer.c()) {
              a();
            } else if (4 != this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h) {
              DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 4);
            }
          }
          if (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout).getVisibility() != 0) {
            break label296;
          }
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
          return false;
        }
      }
      if (paramShapeLayer.b())
      {
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, paramShapeLayer.a().a());
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 10) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(9);
        }
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 12);
        return false;
      }
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      if (paramShapeLayer.c())
      {
        AEQLog.b("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.m();
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 0);
        return false;
      }
      b();
      return false;
    }
    else
    {
      if (paramShapeLayer.c())
      {
        AEQLog.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
        return false;
      }
      this.jdField_a_of_type_Int = Math.round(paramMotionEvent.getX());
      this.b = Math.round(paramMotionEvent.getY());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label296:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.ShapeLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */