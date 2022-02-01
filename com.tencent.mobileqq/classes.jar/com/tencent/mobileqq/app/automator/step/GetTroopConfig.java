package com.tencent.mobileqq.app.automator.step;

import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopConfig
  extends AsyncStep
{
  public int a()
  {
    if (this.a.app != null) {
      ((aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopConfig
 * JD-Core Version:    0.7.0.1
 */