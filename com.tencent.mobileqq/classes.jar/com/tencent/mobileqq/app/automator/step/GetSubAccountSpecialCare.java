package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccountSpecialCare
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetSubAccountSpecialCare step...");
    }
    if ((this.mStepId == 95) && ((((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isThirdAccountDisplayFunc(this.mAutomator.a, true)) || (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc(this.mAutomator.a, true)))) {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).startGetThirdQQUnreadNum(this.mAutomator.a, false);
    }
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getSubAccountSpecialCareListFromService(this.mAutomator.a, true, null);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare
 * JD-Core Version:    0.7.0.1
 */