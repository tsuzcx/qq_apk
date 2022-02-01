package com.tencent.mobileqq.app.automator.step;

import aysq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetLocalRedtouchStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "reconnect pullRedTouchs");
    }
    ((aysq)this.a.app.getManager(160)).b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetLocalRedtouchStep
 * JD-Core Version:    0.7.0.1
 */