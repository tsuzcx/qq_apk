package com.tencent.mobileqq.ar.arengine;

import apji;
import apkv;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(apji paramapji, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      apji.a(this.this$0, true);
      apji.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    apkv.a().a();
    apkv.a().a = System.currentTimeMillis();
    apji.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */