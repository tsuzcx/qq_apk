package com.tencent.mobileqq.ar.arengine;

import amwd;
import amxq;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(amwd paramamwd, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      amwd.a(this.this$0, true);
      amwd.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    amxq.a().a();
    amxq.a().a = System.currentTimeMillis();
    amwd.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */