package com.tencent.mobileqq.ar.arengine;

import aozd;
import aozj;
import aozl;
import apad;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(aozd paramaozd) {}
  
  public void run()
  {
    if ((aozd.a(this.this$0) != null) && (aozd.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Aopa);
      if (!aozd.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aozl localaozl = new aozl();
    localaozl.a = 2;
    apad.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, aozd.a(this.this$0), localaozl);
    if (aozd.a(this.this$0) != null) {
      aozd.a(this.this$0).a(0, aozd.a(this.this$0));
    }
    aozd.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */