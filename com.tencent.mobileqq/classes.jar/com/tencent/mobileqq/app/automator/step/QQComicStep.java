package com.tencent.mobileqq.app.automator.step;

import akmg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class QQComicStep
  extends AsyncStep
{
  public int a()
  {
    this.a.mApp.addObserver(new akmg(this), true);
    ThreadManager.getUIHandler().postDelayed(new QQComicStep.2(this), 3000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQComicStep
 * JD-Core Version:    0.7.0.1
 */