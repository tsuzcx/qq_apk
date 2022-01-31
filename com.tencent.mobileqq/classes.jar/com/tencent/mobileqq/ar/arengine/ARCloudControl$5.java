package com.tencent.mobileqq.ar.arengine;

import anam;
import anas;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$5
  implements Runnable
{
  public ARCloudControl$5(anam paramanam) {}
  
  public void run()
  {
    if ((anam.a(this.this$0) != null) && (anam.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!anam.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    anam.a(this.this$0, true);
    anam.a(this.this$0).a(1, null);
    this.this$0.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */