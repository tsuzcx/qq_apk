package com.tencent.mobileqq.app.automator.step;

import anlo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

class CheckMsgCount$1
  implements Runnable
{
  CheckMsgCount$1(CheckMsgCount paramCheckMsgCount) {}
  
  public void run()
  {
    this.this$0.a.app.getMultiMessageProxy().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckMsgCount.1
 * JD-Core Version:    0.7.0.1
 */