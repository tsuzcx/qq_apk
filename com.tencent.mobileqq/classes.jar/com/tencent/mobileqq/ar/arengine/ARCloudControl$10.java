package com.tencent.mobileqq.ar.arengine;

import amwd;
import amwj;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$10
  implements Runnable
{
  public ARCloudControl$10(amwd paramamwd) {}
  
  public void run()
  {
    if ((amwd.a(this.this$0) != null) && (amwd.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!amwd.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    amwd.a(this.this$0, true);
    amwd.a(this.this$0).a(1, null);
    amwd.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */