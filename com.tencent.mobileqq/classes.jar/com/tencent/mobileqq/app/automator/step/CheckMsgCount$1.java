package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.MultiMsgProxy;

class CheckMsgCount$1
  implements Runnable
{
  CheckMsgCount$1(CheckMsgCount paramCheckMsgCount) {}
  
  public void run()
  {
    this.this$0.mAutomator.a.getMultiMessageProxy().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckMsgCount.1
 * JD-Core Version:    0.7.0.1
 */