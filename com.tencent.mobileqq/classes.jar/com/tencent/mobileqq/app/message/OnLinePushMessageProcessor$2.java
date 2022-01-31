package com.tencent.mobileqq.app.message;

import akqe;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public class OnLinePushMessageProcessor$2
  implements Runnable
{
  public OnLinePushMessageProcessor$2(akqe paramakqe, int paramInt) {}
  
  public void run()
  {
    bcql.a(BaseApplicationImpl.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.a, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */