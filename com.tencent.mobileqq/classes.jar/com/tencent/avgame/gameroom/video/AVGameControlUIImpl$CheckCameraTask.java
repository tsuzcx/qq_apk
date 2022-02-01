package com.tencent.avgame.gameroom.video;

import com.tencent.av.camera.CameraUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import nnm;
import nof;
import nqd;

class AVGameControlUIImpl$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    boolean bool1 = true;
    Object localObject = nnm.b();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask ctrl is null.");
      }
    }
    for (;;)
    {
      return;
      localObject = ((nnm)localObject).a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "CheckCameraTask no session.");
        }
      }
      else
      {
        long l = AudioHelper.b();
        boolean bool2 = ((nof)localObject).a(1);
        if (bool2)
        {
          localObject = CameraUtils.a(BaseApplicationImpl.getApplication());
          if ((!((CameraUtils)localObject).b(l)) && (!((CameraUtils)localObject).a(l)))
          {
            ((CameraUtils)localObject).a(l);
            nqd.a(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */