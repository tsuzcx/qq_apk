package com.tencent.mobileqq.ar.arengine;

import apmt;
import apmz;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$10
  implements Runnable
{
  public ARCloudControl$10(apmt paramapmt) {}
  
  public void run()
  {
    if ((apmt.a(this.this$0) != null) && (apmt.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!apmt.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    apmt.a(this.this$0, true);
    apmt.a(this.this$0).a(1, null);
    apmt.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */