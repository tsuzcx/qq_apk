package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.os.Build;
import aogc;
import aoln;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CameraProxy$2
  implements Runnable
{
  public CameraProxy$2(aoln paramaoln, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    QLog.i("CameraProxy", 2, "startCameraPreview.");
    if ((aoln.a(this.this$0) != 2) || (aoln.a(this.this$0) == null) || (aoln.a(this.this$0)))
    {
      QLog.i("CameraProxy", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", new Object[] { Integer.valueOf(aoln.a(this.this$0)), aoln.a(this.this$0), Boolean.valueOf(aoln.a(this.this$0)) }));
      return;
    }
    aoln.b(this.this$0, aoln.a(this.this$0).a());
    aoln.c(this.this$0, aoln.a(this.this$0).b());
    aoln.d(this.this$0, aoln.a(this.this$0).c());
    aoln.a(this.this$0, aoln.a(this.this$0).a(this.this$0, this.a, this.this$0));
    if (aoln.a(this.this$0))
    {
      QLog.i("CameraProxy", 2, "start preview successfully. mCurCameraState = " + aoln.a(this.this$0));
      aoln.a(this.this$0, true, 0, 1);
      QLog.i("CameraProxy", 2, "openCamera end. mIsCameraPreviewing = " + aoln.a(this.this$0));
      return;
    }
    QLog.i("CameraProxy", 2, "start preview failed. mCurCameraState = " + aoln.a(this.this$0));
    aoln.a(this.this$0).a();
    aoln.a(this.this$0, 0);
    aoln.a(this.this$0, false, 0, 2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("ar_type", "2");
    localHashMap.put("ar_reason", String.valueOf(-4));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.2
 * JD-Core Version:    0.7.0.1
 */