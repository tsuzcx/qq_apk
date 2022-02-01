package com.tencent.mobileqq.activity;

import adyh;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import bdla;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ForwardRecentActivity$10$1
  implements Runnable
{
  public ForwardRecentActivity$10$1(adyh paramadyh, Intent paramIntent) {}
  
  public void run()
  {
    ForwardRecentActivity.a(this.jdField_a_of_type_Adyh.a, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidContentIntent.setClass(this.jdField_a_of_type_Adyh.a, PhoneFrameActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_req_type", 2);
    Intent localIntent = this.jdField_a_of_type_Adyh.a.getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("forward_type"))) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", localIntent.getIntExtra("forward_type", 2147483647));
    }
    this.jdField_a_of_type_Adyh.a.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 20000);
    bdla.b(this.jdField_a_of_type_Adyh.a.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Adyh.a.getSharedPreferences(this.jdField_a_of_type_Adyh.a.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
    ForwardRecentActivity.a(this.jdField_a_of_type_Adyh.a).findViewById(2131369131).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10.1
 * JD-Core Version:    0.7.0.1
 */