package com.tencent.mobileqq.apollo.sdk;

import com.tencent.qphone.base.util.QLog;

public final class CmShowTest$3
  implements Runnable
{
  public void run()
  {
    QLog.i("CmShowTest", 1, "testPreAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.a = 3000272;
    localPlayActionConfig.jdField_b_of_type_Int = 100;
    localPlayActionConfig.jdField_b_of_type_Boolean = false;
    localPlayActionConfig.c = 1;
    this.a.a(localPlayActionConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.3
 * JD-Core Version:    0.7.0.1
 */