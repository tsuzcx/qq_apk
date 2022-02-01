package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class ARCloudControl$9
  implements QQPermissionCallback
{
  ARCloudControl$9(ARCloudControl paramARCloudControl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new ARCloudLBSLocationCheckResult();
    paramArrayOfString.a = 2;
    ARCloudRecogResult.a(this.a.n.recognitions, ARCloudControl.h(this.a), paramArrayOfString);
    if (ARCloudControl.b(this.a) != null) {
      ARCloudControl.b(this.a).a(0, ARCloudControl.h(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.9
 * JD-Core Version:    0.7.0.1
 */