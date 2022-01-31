package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;
import zrg;
import zrh;

public class QQComicStep
  extends AsyncStep
{
  protected int a()
  {
    this.a.a.addObserver(new zrg(this), true);
    ThreadManager.getUIHandler().postDelayed(new zrh(this), 3000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQComicStep
 * JD-Core Version:    0.7.0.1
 */