package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.os.Build;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CameraProxy$2
  implements Runnable
{
  CameraProxy$2(CameraProxy paramCameraProxy, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    QLog.i("CameraProxy", 2, "startCameraPreview.");
    if ((CameraProxy.a(this.this$0) == 2) && (CameraProxy.b(this.this$0) != null) && (!CameraProxy.f(this.this$0)))
    {
      Object localObject = this.this$0;
      CameraProxy.b((CameraProxy)localObject, CameraProxy.b((CameraProxy)localObject).a());
      localObject = this.this$0;
      CameraProxy.c((CameraProxy)localObject, CameraProxy.b((CameraProxy)localObject).b());
      localObject = this.this$0;
      CameraProxy.d((CameraProxy)localObject, CameraProxy.b((CameraProxy)localObject).c());
      localObject = this.this$0;
      ARCamera localARCamera = CameraProxy.b((CameraProxy)localObject);
      CameraProxy localCameraProxy = this.this$0;
      CameraProxy.a((CameraProxy)localObject, localARCamera.a(localCameraProxy, this.a, localCameraProxy));
      if (CameraProxy.f(this.this$0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start preview successfully. mCurCameraState = ");
        ((StringBuilder)localObject).append(CameraProxy.a(this.this$0));
        QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
        CameraProxy.a(this.this$0, true, 0, 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openCamera end. mIsCameraPreviewing = ");
        ((StringBuilder)localObject).append(CameraProxy.f(this.this$0));
        QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start preview failed. mCurCameraState = ");
      ((StringBuilder)localObject).append(CameraProxy.a(this.this$0));
      QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
      CameraProxy.b(this.this$0).g();
      CameraProxy.a(this.this$0, 0);
      CameraProxy.a(this.this$0, false, 0, 2);
      localObject = new HashMap();
      ((HashMap)localObject).put("ar_model", Build.MODEL);
      ((HashMap)localObject).put("ar_type", "2");
      ((HashMap)localObject).put("ar_reason", String.valueOf(-4));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, (HashMap)localObject, "", true);
      return;
    }
    QLog.i("CameraProxy", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", new Object[] { Integer.valueOf(CameraProxy.a(this.this$0)), CameraProxy.b(this.this$0), Boolean.valueOf(CameraProxy.f(this.this$0)) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.2
 * JD-Core Version:    0.7.0.1
 */