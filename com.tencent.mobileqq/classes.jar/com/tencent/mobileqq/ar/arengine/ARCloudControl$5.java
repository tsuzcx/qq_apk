package com.tencent.mobileqq.ar.arengine;

import aogg;
import aogm;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$5
  implements Runnable
{
  public ARCloudControl$5(aogg paramaogg) {}
  
  public void run()
  {
    if ((aogg.a(this.this$0) != null) && (aogg.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!aogg.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aogg.a(this.this$0, true);
    aogg.a(this.this$0).a(1, null);
    this.this$0.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */