package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$3
  implements View.OnClickListener
{
  GeneralSettingActivity$3(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369680)
    {
      if (i == 2131374445)
      {
        ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100194");
        Intent localIntent = new Intent();
        localIntent.putExtra("set_display_type", 1);
        PublicFragmentActivity.a(this.a.getActivity(), localIntent, QQSettingMsgClearFragment.class);
        if (SettingsConfigHelper.a(this.a.app)) {
          ReportController.a(this.a.app, "0X800B870");
        } else {
          ReportController.b(this.a.app, "CliOper", "", "", "0X800A1F2", "0X800A1F2", 0, 0, "", "", "", "");
        }
        ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
      }
    }
    else {
      GeneralSettingActivity.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */