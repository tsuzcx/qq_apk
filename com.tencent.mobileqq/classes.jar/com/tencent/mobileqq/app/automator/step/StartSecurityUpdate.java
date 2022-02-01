package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask;
import java.util.Timer;

public class StartSecurityUpdate
  extends AsyncStep
{
  protected int doStep()
  {
    ThreadManager.getTimer().schedule(new QPSingleUpdTimerTask(), 60000L, 28800000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityUpdate
 * JD-Core Version:    0.7.0.1
 */