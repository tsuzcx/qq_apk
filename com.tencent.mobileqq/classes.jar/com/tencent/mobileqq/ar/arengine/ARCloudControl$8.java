package com.tencent.mobileqq.ar.arengine;

import alfo;
import alfu;
import alfw;
import algo;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(alfo paramalfo) {}
  
  public void run()
  {
    if ((alfo.a(this.this$0) != null) && (alfo.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.b(this.this$0.jdField_a_of_type_Akup);
      if (!alfo.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    alfw localalfw = new alfw();
    localalfw.a = 2;
    algo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, alfo.a(this.this$0), localalfw);
    if (alfo.a(this.this$0) != null) {
      alfo.a(this.this$0).a(0, alfo.a(this.this$0));
    }
    alfo.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */