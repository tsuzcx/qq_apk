package com.tencent.mobileqq.app;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FrameHelperActivity$18
  implements View.OnClickListener
{
  FrameHelperActivity$18(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    if (SettingCloneUtil.readValue(this.a.getApplication(), this.a.getAccount(), null, "pcactive_config", false))
    {
      QQAppInterface localQQAppInterface = this.a;
      localQQAppInterface.startPCActivePolling(localQQAppInterface.getAccount(), "logout");
    }
    this.c.a(this.b, this.a);
    if ((FrameHelperActivity.j(this.c) != null) && (FrameHelperActivity.j(this.c).isShowing())) {
      FrameHelperActivity.j(this.c).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.18
 * JD-Core Version:    0.7.0.1
 */