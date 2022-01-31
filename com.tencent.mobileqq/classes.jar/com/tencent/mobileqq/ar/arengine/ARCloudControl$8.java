package com.tencent.mobileqq.ar.arengine;

import akrc;
import akri;
import akrk;
import aksc;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(akrc paramakrc) {}
  
  public void run()
  {
    if ((akrc.a(this.this$0) != null) && (akrc.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Akgd);
      if (!akrc.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    akrk localakrk = new akrk();
    localakrk.a = 2;
    aksc.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, akrc.a(this.this$0), localakrk);
    if (akrc.a(this.this$0) != null) {
      akrc.a(this.this$0).a(0, akrc.a(this.this$0));
    }
    akrc.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */