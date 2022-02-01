package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$9
  implements CameraCover.PictureCallback
{
  NewFlowCameraActivity$9(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "onPictureToken path " + paramString);
    }
    this.a.a.b();
    NewFlowCameraActivity.a(this.a, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.9
 * JD-Core Version:    0.7.0.1
 */