package com.tencent.mobileqq.ar.arengine;

import alfn;
import alft;
import alfv;
import algn;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(alfn paramalfn) {}
  
  public void run()
  {
    if ((alfn.a(this.this$0) != null) && (alfn.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Akuo);
      if (!alfn.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    alfv localalfv = new alfv();
    localalfv.a = 2;
    algn.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, alfn.a(this.this$0), localalfv);
    if (alfn.a(this.this$0) != null) {
      alfn.a(this.this$0).a(0, alfn.a(this.this$0));
    }
    alfn.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */