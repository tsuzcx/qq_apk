package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$2
  extends CameraObserver
{
  SmallScreenVideoController$2(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (SmallScreenUtils.f()) && ((paramInt == 1) || (paramInt == 3)) && (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null))
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
      return;
    }
    String str;
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = "";
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().r()) {
        break label250;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      return;
      label250:
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
        str = "0X8004888";
      } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
        str = "0X800488E";
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011) || (this.a.jdField_a_of_type_ComTencentAvVideoController.f)))
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.x_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.2
 * JD-Core Version:    0.7.0.1
 */