package com.tencent.mobileqq.ar.model;

import aogc;
import aoln;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(aoln paramaoln) {}
  
  public void run()
  {
    if ((aoln.a(this.this$0) != 3) || (aoln.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + aoln.a(this.this$0));
      return;
    }
    if (aoln.a(this.this$0)) {
      aoln.a(this.this$0).a();
    }
    aoln.a(this.this$0, false);
    aoln.a(this.this$0).a();
    if (aoln.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + aoln.a(this.this$0));
      return;
    }
    aoln.a(this.this$0, 0);
    aoln.a(this.this$0, null);
    aoln.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + aoln.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */