package com.tencent.aelight.camera.ae.config;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class CameraPeakServiceHandler$1
  implements FaceChangeUtils.CropFaceCallback
{
  CameraPeakServiceHandler$1(CameraPeakServiceHandler paramCameraPeakServiceHandler, ToServiceMsg paramToServiceMsg) {}
  
  public void onFail(int paramInt)
  {
    CameraPeakServiceHandler.a(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler);
  }
  
  public void onSuccess(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = CameraPeakServiceHandler.a(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler.a.getApp(), paramBitmap);
      if ((paramBitmap != null) && (paramBitmap.length() >= 1))
      {
        CameraPeakServiceHandler.a(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
        return;
      }
      CameraPeakServiceHandler.a(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler);
      return;
    }
    CameraPeakServiceHandler.a(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler.1
 * JD-Core Version:    0.7.0.1
 */