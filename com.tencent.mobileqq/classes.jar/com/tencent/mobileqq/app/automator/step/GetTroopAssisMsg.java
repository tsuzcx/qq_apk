package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private MessageObserver a;
  
  protected int doStep()
  {
    this.mAutomator.a.getMsgHandler().a(3, true);
    return 2;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.a == null)
    {
      this.a = new GetTroopAssisMsg.MyMessageObserver(this, null);
      this.mAutomator.a.addDefaultObservers(this.a);
    }
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
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */