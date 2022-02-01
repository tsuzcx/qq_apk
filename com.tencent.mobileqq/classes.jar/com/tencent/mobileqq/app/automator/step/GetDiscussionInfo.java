package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetDiscussionInfo
  extends AsyncStep
{
  protected int doStep()
  {
    ((DiscussionHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).d();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDiscussionInfo
 * JD-Core Version:    0.7.0.1
 */