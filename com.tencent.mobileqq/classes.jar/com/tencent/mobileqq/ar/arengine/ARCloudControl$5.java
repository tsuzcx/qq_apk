package com.tencent.mobileqq.ar.arengine;

import aozd;
import aozj;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$5
  implements Runnable
{
  public ARCloudControl$5(aozd paramaozd) {}
  
  public void run()
  {
    if ((aozd.a(this.this$0) != null) && (aozd.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!aozd.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aozd.a(this.this$0, true);
    aozd.a(this.this$0).a(1, null);
    this.this$0.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */