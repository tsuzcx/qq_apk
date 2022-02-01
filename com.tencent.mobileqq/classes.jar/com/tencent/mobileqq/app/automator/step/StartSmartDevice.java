package com.tencent.mobileqq.app.automator.step;

import abqn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;

public class StartSmartDevice
  extends AsyncStep
{
  public int a()
  {
    abqn localabqn = (abqn)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51);
    QLog.i("smartdevice", 1, "start device when device bind flag:" + localabqn.a());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSmartDevice
 * JD-Core Version:    0.7.0.1
 */