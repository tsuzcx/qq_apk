package com.tencent.avgame.gameroom.video;

import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.report.AVGameQualityCameraReportUtil;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUIImpl$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    Object localObject = AVGameBusinessCtrl.b();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask ctrl is null.");
      }
      return;
    }
    localObject = ((AVGameBusinessCtrl)localObject).a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask no session.");
      }
      return;
    }
    long l = QQAudioHelper.b();
    boolean bool1 = true;
    boolean bool2 = ((AVGameSession)localObject).a(1);
    if (bool2)
    {
      localObject = CameraUtils.a(BaseApplicationImpl.getApplication());
      if ((!((ICameraManagerApi)localObject).isCameraOpened(l)) && (!((ICameraManagerApi)localObject).isCameraOpening(l)))
      {
        ((ICameraManagerApi)localObject).openCamera(l);
        AVGameQualityCameraReportUtil.a(4);
        break label118;
      }
    }
    bool1 = false;
    label118:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CheckCameraTask hasLocalCameraVideo[");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("], needOpenCamera[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */