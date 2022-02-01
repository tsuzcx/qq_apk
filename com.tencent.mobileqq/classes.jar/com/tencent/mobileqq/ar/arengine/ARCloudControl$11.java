package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudLBSLocationCheckCallback;
import com.tencent.qphone.base.util.QLog;

class ARCloudControl$11
  implements ARCloudFileUpload.ARCloudLBSLocationCheckCallback
{
  ARCloudControl$11(ARCloudControl paramARCloudControl) {}
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    ARCloudControl.f(this.a, false);
    if (ARCloudControl.a(this.a)) {
      return;
    }
    if (ARCloudControl.d(this.a) != null) {
      ARCloudControl.d(this.a).removeMessages(2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARCloudLBSLocationCheckComplete. retCode = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.a);
    localStringBuilder.append(", imageId = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.b);
    QLog.i("AREngine_ARCloudControl", 1, localStringBuilder.toString());
    if (ARCloudControl.b(this.a) != null)
    {
      ARCloudRecogResult.a(this.a.n.recognitions, ARCloudControl.h(this.a), paramARCloudLBSLocationCheckResult);
      ARCloudControl.b(this.a).a(0, ARCloudControl.h(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.11
 * JD-Core Version:    0.7.0.1
 */