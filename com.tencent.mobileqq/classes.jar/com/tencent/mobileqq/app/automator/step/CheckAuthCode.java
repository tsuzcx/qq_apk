package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckAuthCode
  extends AsyncStep
{
  private ConfigObserver a;
  
  protected int doStep()
  {
    if (this.a == null)
    {
      this.a = new CheckAuthCode.CheckAuthCodeObserver(this, null);
      this.mAutomator.a.addDefaultObservers(this.a);
    }
    if (((ConfigHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a()) {
      return 2;
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.a.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckAuthCode
 * JD-Core Version:    0.7.0.1
 */