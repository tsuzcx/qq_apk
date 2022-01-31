package com.tencent.mobileqq.ar.model;

import akqy;
import akwj;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(akwj paramakwj) {}
  
  public void run()
  {
    if ((akwj.a(this.this$0) != 3) || (akwj.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + akwj.a(this.this$0));
      return;
    }
    if (akwj.a(this.this$0)) {
      akwj.a(this.this$0).a();
    }
    akwj.a(this.this$0, false);
    akwj.a(this.this$0).a();
    if (akwj.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + akwj.a(this.this$0));
      return;
    }
    akwj.a(this.this$0, 0);
    akwj.a(this.this$0, null);
    akwj.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + akwj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */