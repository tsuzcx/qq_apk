package com.tencent.mobileqq.ar.arengine;

import apmt;
import apog;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(apmt paramapmt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      apmt.a(this.this$0, true);
      apmt.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    apog.a().a();
    apog.a().a = System.currentTimeMillis();
    apmt.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */