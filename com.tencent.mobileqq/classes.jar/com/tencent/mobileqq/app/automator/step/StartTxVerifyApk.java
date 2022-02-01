package com.tencent.mobileqq.app.automator.step;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask;

public class StartTxVerifyApk
  extends AsyncStep
{
  protected int doStep()
  {
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new QPTxVerifyApkTimerTask(this.mAutomator.a, false), 180000L);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartTxVerifyApk
 * JD-Core Version:    0.7.0.1
 */