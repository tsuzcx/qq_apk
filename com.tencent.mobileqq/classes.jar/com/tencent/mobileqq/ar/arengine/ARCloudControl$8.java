package com.tencent.mobileqq.ar.arengine;

import aogg;
import aogm;
import aogo;
import aohg;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(aogg paramaogg) {}
  
  public void run()
  {
    if ((aogg.a(this.this$0) != null) && (aogg.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.removeOnLocationListener(this.this$0.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      if (!aogg.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    aogo localaogo = new aogo();
    localaogo.a = 2;
    aohg.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, aogg.a(this.this$0), localaogo);
    if (aogg.a(this.this$0) != null) {
      aogg.a(this.this$0).a(0, aogg.a(this.this$0));
    }
    aogg.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */