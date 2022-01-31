package com.tencent.mobileqq.ar.arengine;

import alfn;
import alha;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(alfn paramalfn, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      alfn.a(this.this$0, true);
      alfn.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    alha.a().a();
    alha.a().a = System.currentTimeMillis();
    alfn.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */