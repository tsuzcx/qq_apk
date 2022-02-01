package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$5
  implements View.OnClickListener
{
  GeneralSettingActivity$5(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    MsgBackupReporter.a("0X800A22D");
    QPublicFragmentActivity.start(this.a.getActivity(), MsgBackupWelcomeFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */