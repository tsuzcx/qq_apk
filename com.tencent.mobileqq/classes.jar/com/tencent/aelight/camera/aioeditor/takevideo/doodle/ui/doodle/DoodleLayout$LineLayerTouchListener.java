package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$LineLayerTouchListener
  implements BaseLayer.OnLayerTouchListener<LineLayer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  
  private DoodleLayout$LineLayerTouchListener(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(5);
    if (DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout) > System.currentTimeMillis())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(false));
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(true));
      a(false, true);
    }
    DoodleLayout.f(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "LineLayer draw move hide");
    }
  }
  
  private void a(LineLayer paramLineLayer, int paramInt1, int paramInt2)
  {
    if (paramLineLayer.a.b() > 0)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a.setUndoViewEnable(true);
      DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout).setUndoEnabled(true);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 5)
    {
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 2);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(2);
      DoodleLayout.g(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      a(true, true);
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "LineLayer draw up show");
      }
    }
    else if ((Math.abs(paramInt2 - this.jdField_a_of_type_Int) < 3) && (Math.abs(paramInt1 - this.b) < 3))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 6)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(2, Boolean.valueOf(false));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(2);
        DoodleLayout.g(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
        a(true, false);
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "LineLayer tap up show");
        }
      }
      else
      {
        VideoEditReport.b("0X80080E5", VideoEditReport.jdField_a_of_type_Int);
        if (!paramLineLayer.b())
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(6);
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 6);
          DoodleLayout.f(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
          a(false, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Personality", 2, "LineLayer tap up hide");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a()) {
      localObject1 = DoodleLayout.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    long l1 = System.currentTimeMillis();
    long l2 = 500;
    DoodleLayout.a((DoodleLayout)localObject2, l1 + l2);
    if (paramBoolean2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
      DoodleLayout.a((DoodleLayout)localObject2, DoodleLayout.a((DoodleLayout)localObject2) + l2);
    }
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setDuration(l2);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    ((AlphaAnimation)localObject2).setAnimationListener(new DoodleLayout.LineLayerTouchListener.1(this, (View)localObject1));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(l2);
    if (paramBoolean2) {
      localAlphaAnimation.setStartOffset(l2);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new DoodleLayout.LineLayerTouchListener.2(this, (View)localObject1));
    if (paramBoolean1) {
      localObject2 = localAlphaAnimation;
    }
    ((View)localObject1).startAnimation((Animation)localObject2);
    if (localObject1 == this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a.setAnimationEndTime(DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout));
    }
  }
  
  public boolean a(LineLayer paramLineLayer, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a()) {
      DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, paramLineLayer);
    }
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
          if (((Math.abs(j - this.jdField_a_of_type_Int) < 3) && (Math.abs(i - this.b) < 3)) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 6) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h == 5)) {
            break label236;
          }
          if (!paramLineLayer.c())
          {
            a();
            return false;
          }
          if (4 == this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.h) {
            break label236;
          }
          DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 4);
          return false;
        }
      }
      if (paramLineLayer.c())
      {
        AEQLog.b("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.m();
        DoodleLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout, 0);
        return false;
      }
      a(paramLineLayer, i, j);
      return false;
    }
    else
    {
      if (paramLineLayer.c())
      {
        AEQLog.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
        return false;
      }
      this.jdField_a_of_type_Int = Math.round(paramMotionEvent.getX());
      this.b = Math.round(paramMotionEvent.getY());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label236:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.LineLayerTouchListener
 * JD-Core Version:    0.7.0.1
 */