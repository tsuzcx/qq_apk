package com.tencent.mobileqq.app.automator.step;

import avsm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class getLocalRedtouchStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "reconnect pullRedTouchs");
    }
    ((avsm)this.a.app.getManager(160)).b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.getLocalRedtouchStep
 * JD-Core Version:    0.7.0.1
 */