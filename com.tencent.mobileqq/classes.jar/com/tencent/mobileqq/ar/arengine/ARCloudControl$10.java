package com.tencent.mobileqq.ar.arengine;

import aogg;
import aogm;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$10
  implements Runnable
{
  public ARCloudControl$10(aogg paramaogg) {}
  
  public void run()
  {
    if ((aogg.a(this.this$0) != null) && (aogg.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!aogg.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aogg.a(this.this$0, true);
    aogg.a(this.this$0).a(1, null);
    aogg.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */