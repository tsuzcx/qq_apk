package com.tencent.mobileqq.ar.arengine;

import apmt;
import apmz;
import apnb;
import apnt;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(apmt paramapmt) {}
  
  public void run()
  {
    if ((apmt.a(this.this$0) != null) && (apmt.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Apcq);
      if (!apmt.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    apnb localapnb = new apnb();
    localapnb.a = 2;
    apnt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, apmt.a(this.this$0), localapnb);
    if (apmt.a(this.this$0) != null) {
      apmt.a(this.this$0).a(0, apmt.a(this.this$0));
    }
    apmt.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */