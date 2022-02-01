package com.tencent.avgame.gameroom.video;

import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.util.AVGameQualityCameraReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVGameControlUIImpl$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    boolean bool1 = true;
    Object localObject = AVGameBusinessCtrl.b();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask ctrl is null.");
      }
    }
    for (;;)
    {
      return;
      localObject = ((AVGameBusinessCtrl)localObject).a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask no session.");
        }
      }
      else
      {
        long l = AudioHelper.b();
        boolean bool2 = ((AVGameSession)localObject).a(1);
        if (bool2)
        {
          localObject = CameraUtils.a(BaseApplicationImpl.getApplication());
          if ((!((CameraUtils)localObject).b(l)) && (!((CameraUtils)localObject).a(l)))
          {
            ((CameraUtils)localObject).a(l);
            AVGameQualityCameraReportUtil.a(4);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask hasLocalCameraVideo[" + bool2 + "], needOpenCamera[" + bool1 + "]");
          return;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */