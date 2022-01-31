package com.tencent.mobileqq.ar.arengine;

import amwd;
import amwj;
import amwl;
import amxd;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(amwd paramamwd) {}
  
  public void run()
  {
    if ((amwd.a(this.this$0) != null) && (amwd.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Amle);
      if (!amwd.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    amwl localamwl = new amwl();
    localamwl.a = 2;
    amxd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, amwd.a(this.this$0), localamwl);
    if (amwd.a(this.this$0) != null) {
      amwd.a(this.this$0).a(0, amwd.a(this.this$0));
    }
    amwd.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */