package com.tencent.avgame.ui;

import com.tencent.avgame.report.AVGamePerfReporter;

class AVGameActivity$2
  implements Runnable
{
  AVGameActivity$2(AVGameActivity paramAVGameActivity) {}
  
  public void run()
  {
    AVGamePerfReporter.a().a("param_StepLoading", 0);
    this.this$0.notifyMainProcessLoadingFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.2
 * JD-Core Version:    0.7.0.1
 */