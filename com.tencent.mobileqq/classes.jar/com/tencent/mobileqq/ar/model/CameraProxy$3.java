package com.tencent.mobileqq.ar.model;

import amvz;
import anbk;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(anbk paramanbk) {}
  
  public void run()
  {
    if ((anbk.a(this.this$0) != 3) || (anbk.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + anbk.a(this.this$0));
      return;
    }
    if (anbk.a(this.this$0)) {
      anbk.a(this.this$0).a();
    }
    anbk.a(this.this$0, false);
    anbk.a(this.this$0).a();
    if (anbk.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + anbk.a(this.this$0));
      return;
    }
    anbk.a(this.this$0, 0);
    anbk.a(this.this$0, null);
    anbk.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + anbk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */