package com.tencent.avgame.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.qphone.base.util.QLog;

class AvGameLoadingActivity$1
  extends BroadcastReceiver
{
  AvGameLoadingActivity$1(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d("AvGameLoadingActivity", 2, "receive broadcast");
    if ("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH".equals(paramContext))
    {
      AVGamePerfReporter.a().a("param_StepLoading", 0);
      AvGameLoadingActivity.a(this.a, true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.1
 * JD-Core Version:    0.7.0.1
 */