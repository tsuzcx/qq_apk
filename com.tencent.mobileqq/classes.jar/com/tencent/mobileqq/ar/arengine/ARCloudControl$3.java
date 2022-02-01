package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

class ARCloudControl$3
  implements Runnable
{
  ARCloudControl$3(ARCloudControl paramARCloudControl, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a == null)
    {
      ARCloudControl.a(this.this$0, true);
      ARCloudControl.b(this.this$0, true);
    }
    while (this.this$0.a.recognitions == null) {
      return;
    }
    ARFaceDataCollector.a().a();
    ARFaceDataCollector.a().a = System.currentTimeMillis();
    ARCloudControl.a(this.this$0, this.a, this.this$0.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */