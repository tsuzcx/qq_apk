package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;

class GetConfig$MyResourcePluginListener
  extends ResourcePluginListener
{
  private GetConfig$MyResourcePluginListener(GetConfig paramGetConfig) {}
  
  public void a(byte paramByte)
  {
    if (this.a.mStepId == 44)
    {
      if (paramByte != 2) {}
      ((ILebaHelperService)this.a.mAutomator.k.getRuntimeService(ILebaHelperService.class, "")).removeLebaListener(GetConfig.a(this.a));
      this.a.setResult(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if (paramByte != 2) {}
    this.a.mAutomator.k.removeAboutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig.MyResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */