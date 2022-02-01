package com.tencent.mobileqq.ar.arcloud;

import com.tencent.mobileqq.ar.ARLBSObserver;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;

class ARCloudFileUpload$1
  extends ARLBSObserver
{
  ARCloudFileUpload$1(ARCloudFileUpload paramARCloudFileUpload) {}
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    if (ARCloudFileUpload.a(this.a) != null) {
      ARCloudFileUpload.a(this.a).a(paramARCloudLBSLocationCheckResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.1
 * JD-Core Version:    0.7.0.1
 */