package com.tencent.mobileqq.activity;

import acxk;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import azqs;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ForwardRecentActivity$10$1
  implements Runnable
{
  public ForwardRecentActivity$10$1(acxk paramacxk, Intent paramIntent) {}
  
  public void run()
  {
    ForwardRecentActivity.a(this.jdField_a_of_type_Acxk.a, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidContentIntent.setClass(this.jdField_a_of_type_Acxk.a, PhoneFrameActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_req_type", 2);
    Intent localIntent = this.jdField_a_of_type_Acxk.a.getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("forward_type"))) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", localIntent.getIntExtra("forward_type", 2147483647));
    }
    this.jdField_a_of_type_Acxk.a.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 20000);
    azqs.b(this.jdField_a_of_type_Acxk.a.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Acxk.a.getSharedPreferences(this.jdField_a_of_type_Acxk.a.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
    ForwardRecentActivity.a(this.jdField_a_of_type_Acxk.a).findViewById(2131368542).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10.1
 * JD-Core Version:    0.7.0.1
 */