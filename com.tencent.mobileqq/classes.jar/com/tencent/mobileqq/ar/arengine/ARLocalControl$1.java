package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARLocalControl$1
  implements Runnable
{
  ARLocalControl$1(ARLocalControl paramARLocalControl, int paramInt1, int paramInt2, Context paramContext, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, long paramLong) {}
  
  public void run()
  {
    if ((ARLocalControl.a(this.this$0) & 0x4) != 0L)
    {
      ??? = new ARFacePreviewResample();
      ((ARFacePreviewResample)???).a(this.a, this.b, 17);
      int i = ((ARFacePreviewResample)???).a();
      int j = ((ARFacePreviewResample)???).b();
      this.this$0.b = new ARLocalFaceRecog();
      this.this$0.b.a((ARFacePreviewResample)???);
      if (!this.this$0.b.a(this.c, i, j, this.d, this.this$0)) {
        this.this$0.b = null;
      }
    }
    synchronized (ARLocalControl.e())
    {
      ARLocalControl.a(this.this$0, true);
      ARLocalControl.e().notifyAll();
      QLog.i("AREngine_ARLocalControl", 1, String.format("initFaceRecogAsync end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.e) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalControl.1
 * JD-Core Version:    0.7.0.1
 */