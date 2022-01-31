package com.tencent.mobileqq.ar.arengine;

import anam;
import anbz;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(anam paramanam, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      anam.a(this.this$0, true);
      anam.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    anbz.a().a();
    anbz.a().a = System.currentTimeMillis();
    anam.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */