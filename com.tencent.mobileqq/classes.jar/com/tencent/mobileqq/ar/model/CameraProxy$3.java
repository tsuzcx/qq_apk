package com.tencent.mobileqq.ar.model;

import alfj;
import alku;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(alku paramalku) {}
  
  public void run()
  {
    if ((alku.a(this.this$0) != 3) || (alku.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + alku.a(this.this$0));
      return;
    }
    if (alku.a(this.this$0)) {
      alku.a(this.this$0).a();
    }
    alku.a(this.this$0, false);
    alku.a(this.this$0).a();
    if (alku.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + alku.a(this.this$0));
      return;
    }
    alku.a(this.this$0, 0);
    alku.a(this.this$0, null);
    alku.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + alku.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */