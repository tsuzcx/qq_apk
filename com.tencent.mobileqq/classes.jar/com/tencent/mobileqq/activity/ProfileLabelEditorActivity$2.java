package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileLabelEditorActivity$2
  implements View.OnClickListener
{
  ProfileLabelEditorActivity$2(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getIntent().getStringExtra("uin");
    if ((str != null) && (str.equals(this.a.app.getCurrentAccountUin())))
    {
      ProfileLabelEditorActivity.a(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.2
 * JD-Core Version:    0.7.0.1
 */