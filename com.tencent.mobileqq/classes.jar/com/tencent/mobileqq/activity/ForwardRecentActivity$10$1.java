package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ForwardRecentActivity$10$1
  implements Runnable
{
  ForwardRecentActivity$10$1(ForwardRecentActivity.10 param10, Intent paramIntent) {}
  
  public void run()
  {
    ForwardRecentActivity.access$1600(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidContentIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a, PhoneFrameActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_req_type", 2);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a.getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("forward_type"))) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", localIntent.getIntExtra("forward_type", 2147483647));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 20000);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
    ForwardRecentActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity$10.a).findViewById(2131369110).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10.1
 * JD-Core Version:    0.7.0.1
 */