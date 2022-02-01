package com.tencent.mobileqq.ar.arengine;

import aozd;
import apaq;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(aozd paramaozd, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      aozd.a(this.this$0, true);
      aozd.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    apaq.a().a();
    apaq.a().a = System.currentTimeMillis();
    aozd.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */