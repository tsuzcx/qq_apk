package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.qphone.base.util.QLog;

public class GetLocalRedtouchStep
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "reconnect pullRedTouchs");
    }
    ((LocalRedTouchManager)this.mAutomator.a.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetLocalRedtouchStep
 * JD-Core Version:    0.7.0.1
 */