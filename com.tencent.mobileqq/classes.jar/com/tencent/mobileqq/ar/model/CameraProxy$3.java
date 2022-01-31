package com.tencent.mobileqq.ar.model;

import anai;
import anft;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(anft paramanft) {}
  
  public void run()
  {
    if ((anft.a(this.this$0) != 3) || (anft.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + anft.a(this.this$0));
      return;
    }
    if (anft.a(this.this$0)) {
      anft.a(this.this$0).a();
    }
    anft.a(this.this$0, false);
    anft.a(this.this$0).a();
    if (anft.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + anft.a(this.this$0));
      return;
    }
    anft.a(this.this$0, 0);
    anft.a(this.this$0, null);
    anft.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + anft.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */