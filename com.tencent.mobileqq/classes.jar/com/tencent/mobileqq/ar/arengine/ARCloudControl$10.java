package com.tencent.mobileqq.ar.arengine;

import aozd;
import aozj;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$10
  implements Runnable
{
  public ARCloudControl$10(aozd paramaozd) {}
  
  public void run()
  {
    if ((aozd.a(this.this$0) != null) && (aozd.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!aozd.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aozd.a(this.this$0, true);
    aozd.a(this.this$0).a(1, null);
    aozd.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */