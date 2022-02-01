package com.tencent.mobileqq.app.automator.step;

import azgu;
import azhk;
import bgyg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;

public class GetSelfPendantId
  extends AsyncStep
{
  private String a()
  {
    if ((this.a.app.getAccount() != null) && (this.a.app.isLogin())) {
      return this.a.app.getAccount();
    }
    return "0";
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetSelfPendantId", 2, "doStep");
    }
    bgyg.a(this.a.app);
    azhk.a(this.a.app);
    azgu.a(this.a.app);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.a.app.a(71);
    localVasExtensionHandler.a(new String[] { a() }, new int[] { 27201, 27025, 40530, 20059, 27041, 27217, 27225, 27224, 42122, 42121, 27234, 27235, 27236, 27238, 45000, 42334, 27373, 27241 });
    localVasExtensionHandler.a(new String[] { a() }, new int[] { 27375 }, 22);
    this.a.app.getManager(44);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfPendantId
 * JD-Core Version:    0.7.0.1
 */