package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.os.Build;
import apmp;
import apsa;
import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CameraProxy$2
  implements Runnable
{
  public CameraProxy$2(apsa paramapsa, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    QLog.i("CameraProxy", 2, "startCameraPreview.");
    if ((apsa.a(this.this$0) != 2) || (apsa.a(this.this$0) == null) || (apsa.a(this.this$0)))
    {
      QLog.i("CameraProxy", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", new Object[] { Integer.valueOf(apsa.a(this.this$0)), apsa.a(this.this$0), Boolean.valueOf(apsa.a(this.this$0)) }));
      return;
    }
    apsa.b(this.this$0, apsa.a(this.this$0).a());
    apsa.c(this.this$0, apsa.a(this.this$0).b());
    apsa.d(this.this$0, apsa.a(this.this$0).c());
    apsa.a(this.this$0, apsa.a(this.this$0).a(this.this$0, this.a, this.this$0));
    if (apsa.a(this.this$0))
    {
      QLog.i("CameraProxy", 2, "start preview successfully. mCurCameraState = " + apsa.a(this.this$0));
      apsa.a(this.this$0, true, 0, 1);
      QLog.i("CameraProxy", 2, "openCamera end. mIsCameraPreviewing = " + apsa.a(this.this$0));
      return;
    }
    QLog.i("CameraProxy", 2, "start preview failed. mCurCameraState = " + apsa.a(this.this$0));
    apsa.a(this.this$0).a();
    apsa.a(this.this$0, 0);
    apsa.a(this.this$0, false, 0, 2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("ar_type", "2");
    localHashMap.put("ar_reason", String.valueOf(-4));
    bdmc.a(BaseApplication.getContext()).a("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.2
 * JD-Core Version:    0.7.0.1
 */