package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

class ARCloudControl$10
  implements Runnable
{
  ARCloudControl$10(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    if ((ARCloudControl.b(this.this$0) != null) && (ARCloudControl.i(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (ARCloudControl.a(this.this$0)) {
        return;
      }
      ARCloudControl.a(this.this$0, true);
      ARCloudControl.b(this.this$0).a(1, null);
      ARCloudControl.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */