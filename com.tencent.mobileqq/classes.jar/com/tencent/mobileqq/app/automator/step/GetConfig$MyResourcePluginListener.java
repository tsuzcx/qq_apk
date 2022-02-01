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
    if (this.a.b == 44)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      ((ILebaHelperService)this.a.a.a.getRuntimeService(ILebaHelperService.class, "")).removeLebaListener(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    this.a.a.a.removeAboutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig.MyResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */