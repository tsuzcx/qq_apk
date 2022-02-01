package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

class ARCloudControl$5
  implements Runnable
{
  ARCloudControl$5(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    if ((ARCloudControl.a(this.this$0) != null) && (ARCloudControl.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!ARCloudControl.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    ARCloudControl.a(this.this$0, true);
    ARCloudControl.a(this.this$0).a(1, null);
    this.this$0.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */