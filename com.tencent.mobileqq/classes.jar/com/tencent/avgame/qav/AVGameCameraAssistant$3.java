package com.tencent.avgame.qav;

import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.util.WeakReference;

class AVGameCameraAssistant$3
  implements Runnable
{
  AVGameCameraAssistant$3(AVGameCameraAssistant paramAVGameCameraAssistant) {}
  
  public void run()
  {
    Object localObject = (AVGameAppInterface)AVGameCameraAssistant.b(this.this$0).get();
    if (localObject != null)
    {
      long l = QQAudioHelper.d();
      AVGameCameraAssistant.c(this.this$0);
      boolean bool;
      if ((AVGameCameraAssistant.d(this.this$0) != null) && (AVGameCameraAssistant.d(this.this$0).a((AVGameAppInterface)localObject))) {
        bool = true;
      } else {
        bool = false;
      }
      if ((!bool) && ((AVGameCameraAssistant.e(this.this$0).isCameraOpened(l)) || (AVGameCameraAssistant.e(this.this$0).isCameraOpening(l))) && (AVGameCameraAssistant.f(this.this$0) < 5) && (AVGameCameraAssistant.f(this.this$0) > 0)) {
        AVGameCameraAssistant.g(this.this$0).sendEmptyMessageDelayed(1, 10000L);
      }
      if ((!bool) && (AVGameCameraAssistant.h(this.this$0) == null))
      {
        AVGameCameraAssistant.a(this.this$0, new AVGameCameraAssistant.3.1(this));
        ObserverCenter.a().a(AVGameCameraAssistant.h(this.this$0), true);
      }
      else if ((bool) && (AVGameCameraAssistant.h(this.this$0) != null))
      {
        AVGameCameraAssistant.i(this.this$0);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check ptv so ret[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("AVGameCameraAssistant", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("AVGameCameraAssistant", 2, "app is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.3
 * JD-Core Version:    0.7.0.1
 */