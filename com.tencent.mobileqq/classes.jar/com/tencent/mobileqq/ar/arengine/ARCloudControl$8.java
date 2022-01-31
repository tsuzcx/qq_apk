package com.tencent.mobileqq.ar.arengine;

import anam;
import anas;
import anau;
import anbm;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(anam paramanam) {}
  
  public void run()
  {
    if ((anam.a(this.this$0) != null) && (anam.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Ampt);
      if (!anam.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    anau localanau = new anau();
    localanau.a = 2;
    anbm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, anam.a(this.this$0), localanau);
    if (anam.a(this.this$0) != null) {
      anam.a(this.this$0).a(0, anam.a(this.this$0));
    }
    anam.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */