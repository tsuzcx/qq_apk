package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccount
  extends AsyncStep
{
  protected int doStep()
  {
    ISubAccountProtocService localISubAccountProtocService = (ISubAccountProtocService)this.mAutomator.k.getRuntimeService(ISubAccountProtocService.class, "");
    if (localISubAccountProtocService != null) {
      localISubAccountProtocService.getBindAccount();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "subaccount onGetSubAccountBind start int QQInitHandler...");
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccount
 * JD-Core Version:    0.7.0.1
 */