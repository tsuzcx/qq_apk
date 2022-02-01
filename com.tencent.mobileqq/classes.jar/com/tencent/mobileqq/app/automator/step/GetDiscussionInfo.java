package com.tencent.mobileqq.app.automator.step;

import antl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetDiscussionInfo
  extends AsyncStep
{
  public int a()
  {
    ((antl)this.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).c();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDiscussionInfo
 * JD-Core Version:    0.7.0.1
 */