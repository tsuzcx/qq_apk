package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ForwardRecentActivity$11$1
  implements Runnable
{
  ForwardRecentActivity$11$1(ForwardRecentActivity.11 param11, Intent paramIntent) {}
  
  public void run()
  {
    ForwardRecentActivity.access$500(this.b.a, this.a);
    this.a.setClass(this.b.a, PhoneFrameActivity.class);
    this.a.putExtra("key_req_type", 2);
    Intent localIntent = this.b.a.getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("forward_type"))) {
      this.a.putExtra("forward_type", localIntent.getIntExtra("forward_type", 2147483647));
    }
    this.b.a.startActivityForResult(this.a, 20000);
    ReportController.b(this.b.a.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
    this.b.a.getSharedPreferences(this.b.a.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
    ForwardRecentActivity.access$1800(this.b.a).findViewById(2131436080).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.11.1
 * JD-Core Version:    0.7.0.1
 */