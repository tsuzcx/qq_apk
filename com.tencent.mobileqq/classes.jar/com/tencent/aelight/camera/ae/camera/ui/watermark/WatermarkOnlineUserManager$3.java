package com.tencent.aelight.camera.ae.camera.ui.watermark;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;

class WatermarkOnlineUserManager$3
  extends CameraPeakServiceObserver
{
  WatermarkOnlineUserManager$3(WatermarkOnlineUserManager paramWatermarkOnlineUserManager, AppInterface paramAppInterface) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("requestOnlineUserNum---isSuccess=");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append(", num=");
    ((StringBuilder)???).append(paramInt);
    AEQLog.b("WatermarkOnlineUserManager", ((StringBuilder)???).toString());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (WatermarkOnlineUserManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager))
      {
        WatermarkOnlineUserManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager.3
 * JD-Core Version:    0.7.0.1
 */