package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.TipsDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$5
  implements View.OnClickListener
{
  AssistantSettingActivity$5(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    new TipsDialog(this.a).a(this.a.getString(2131695306)).b(this.a.getString(2131695305)).c(this.a.getString(2131692918)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */