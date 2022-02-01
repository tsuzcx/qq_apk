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
      return;
    }
    if (this.this$0.a.recognitions == null) {
      return;
    }
    ARFaceDataCollector.a().a();
    ARFaceDataCollector.a().a = System.currentTimeMillis();
    ARCloudControl localARCloudControl = this.this$0;
    ARCloudControl.a(localARCloudControl, this.a, localARCloudControl.a.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */