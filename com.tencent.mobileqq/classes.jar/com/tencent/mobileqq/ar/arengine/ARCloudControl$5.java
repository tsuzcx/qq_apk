package com.tencent.mobileqq.ar.arengine;

import apmt;
import apmz;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$5
  implements Runnable
{
  public ARCloudControl$5(apmt paramapmt) {}
  
  public void run()
  {
    if ((apmt.a(this.this$0) != null) && (apmt.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!apmt.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    apmt.a(this.this$0, true);
    apmt.a(this.this$0).a(1, null);
    this.this$0.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */