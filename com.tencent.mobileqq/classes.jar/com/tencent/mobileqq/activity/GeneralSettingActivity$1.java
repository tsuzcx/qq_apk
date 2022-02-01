package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$1
  implements View.OnClickListener
{
  GeneralSettingActivity$1(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442615)
    {
      ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100194");
      Intent localIntent = new Intent();
      localIntent.putExtra("set_display_type", 1);
      PublicFragmentActivity.a(this.a.getActivity(), localIntent, QQSettingMsgClearFragment.class);
      ReportController.a(this.a.app, "0X800B870");
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */