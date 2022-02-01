package com.tencent.mobileqq.activity.springfestival.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class SpringHbReportManager$1
  extends BroadcastReceiver
{
  SpringHbReportManager$1(SpringHbReportManager paramSpringHbReportManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    if (("com.tencent.plugin.state.change".equals(paramContext)) && (paramIntent.getIntExtra("key_plugin_state", 0) == 0))
    {
      QLog.i("shua2021report_SpringHbReportManager", 1, "[onReceive] bg action");
      this.a.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.1
 * JD-Core Version:    0.7.0.1
 */