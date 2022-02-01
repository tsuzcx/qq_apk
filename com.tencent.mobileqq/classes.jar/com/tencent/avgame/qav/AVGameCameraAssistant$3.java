package com.tencent.avgame.qav;

import bkgm;
import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import mwu;
import ndy;
import neb;

public class AVGameCameraAssistant$3
  implements Runnable
{
  AVGameCameraAssistant$3(AVGameCameraAssistant paramAVGameCameraAssistant) {}
  
  public void run()
  {
    AVGameAppInterface localAVGameAppInterface = (AVGameAppInterface)AVGameCameraAssistant.a(this.this$0).get();
    if (localAVGameAppInterface != null)
    {
      l = AudioHelper.b();
      AVGameCameraAssistant.a(this.this$0);
      if ((AVGameCameraAssistant.a(this.this$0) != null) && (AVGameCameraAssistant.a(this.this$0).a(localAVGameAppInterface)))
      {
        bool = true;
        if ((!bool) && ((AVGameCameraAssistant.a(this.this$0).b(l)) || (AVGameCameraAssistant.a(this.this$0).a(l))) && (AVGameCameraAssistant.b(this.this$0) < 5) && (AVGameCameraAssistant.b(this.this$0) > 0)) {
          AVGameCameraAssistant.a(this.this$0).sendEmptyMessageDelayed(1, 10000L);
        }
        if ((bool) || (AVGameCameraAssistant.a(this.this$0) != null)) {
          break label213;
        }
        AVGameCameraAssistant.a(this.this$0, new ndy(this));
        mwu.a().a(AVGameCameraAssistant.a(this.this$0), true);
        if (QLog.isColorLevel()) {
          QLog.i("AVGameCameraAssistant", 2, "check ptv so ret[" + bool + "]");
        }
      }
    }
    label213:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        return;
        boolean bool = false;
        continue;
        if ((bool) && (AVGameCameraAssistant.a(this.this$0) != null)) {
          AVGameCameraAssistant.a(this.this$0);
        }
      }
    }
    QLog.i("AVGameCameraAssistant", 2, "app is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.3
 * JD-Core Version:    0.7.0.1
 */