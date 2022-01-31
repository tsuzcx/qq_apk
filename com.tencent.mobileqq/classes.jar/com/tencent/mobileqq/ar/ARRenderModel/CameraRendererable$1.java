package com.tencent.mobileqq.ar.ARRenderModel;

import amqu;
import amrf;
import com.tencent.qphone.base.util.QLog;

public class CameraRendererable$1
  implements Runnable
{
  public CameraRendererable$1(amrf paramamrf) {}
  
  public void run()
  {
    if (amrf.a(this.this$0) != null) {}
    try
    {
      amrf.a(this.this$0).a();
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(amrf.a(), 2, "requestRender", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable.1
 * JD-Core Version:    0.7.0.1
 */