package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;

class ARCloudControl$8
  implements Runnable
{
  ARCloudControl$8(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    if ((ARCloudControl.b(this.this$0) != null) && (ARCloudControl.i(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.this$0.C);
      if (ARCloudControl.a(this.this$0)) {
        return;
      }
      ARCloudLBSLocationCheckResult localARCloudLBSLocationCheckResult = new ARCloudLBSLocationCheckResult();
      localARCloudLBSLocationCheckResult.a = 2;
      ARCloudRecogResult.a(this.this$0.n.recognitions, ARCloudControl.h(this.this$0), localARCloudLBSLocationCheckResult);
      if (ARCloudControl.b(this.this$0) != null) {
        ARCloudControl.b(this.this$0).a(0, ARCloudControl.h(this.this$0));
      }
      ARCloudControl.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */