package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$2
  extends CameraObserver
{
  SmallScreenVideoController$2(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAfterOpenCamera, success[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], preSessionType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (SmallScreenUtils.f()) && ((paramInt == 1) || (paramInt == 3)) && (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null))
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p()) {
          localObject = "0X8004894";
        }
        for (;;)
        {
          break;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e == 1) {
            localObject = "0X8004888";
          } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e == 2) {
            localObject = "0X800488E";
          } else {
            localObject = "";
          }
        }
        ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      }
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k == 1011))
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.2
 * JD-Core Version:    0.7.0.1
 */