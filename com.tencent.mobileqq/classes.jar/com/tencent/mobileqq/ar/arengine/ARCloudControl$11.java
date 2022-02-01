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
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).removeMessages(2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARCloudLBSLocationCheckComplete. retCode = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int);
    localStringBuilder.append(", imageId = ");
    localStringBuilder.append(paramARCloudLBSLocationCheckResult.jdField_a_of_type_JavaLangString);
    QLog.i("AREngine_ARCloudControl", 1, localStringBuilder.toString());
    if (ARCloudControl.a(this.a) != null)
    {
      ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a), paramARCloudLBSLocationCheckResult);
      ARCloudControl.a(this.a).a(0, ARCloudControl.a(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.11
 * JD-Core Version:    0.7.0.1
 */