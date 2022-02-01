package com.tencent.mobileqq.ar.arengine;

import apji;
import apjo;
import apjq;
import apki;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(apji paramapji) {}
  
  public void run()
  {
    if ((apji.a(this.this$0) != null) && (apji.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.removeOnLocationListener(this.this$0.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      if (!apji.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    apjq localapjq = new apjq();
    localapjq.a = 2;
    apki.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, apji.a(this.this$0), localapjq);
    if (apji.a(this.this$0) != null) {
      apji.a(this.this$0).a(0, apji.a(this.this$0));
    }
    apji.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */