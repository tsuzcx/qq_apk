package com.tencent.mobileqq.activity;

import abqj;
import abqk;
import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import axqy;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bbgu jdField_a_of_type_Bbgu;
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559347);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    paramBundle = ajya.a(2131707919);
    this.jdField_a_of_type_Bbgu = null;
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 230);
    this.jdField_a_of_type_Bbgu.setContentView(2131558883);
    this.jdField_a_of_type_Bbgu.setTitle(null).setMessage(getString(2131694974)).setPositiveButton(2131694973, new abqj(this));
    this.jdField_a_of_type_Bbgu.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bbgu.setOnKeyListener(new abqk(this));
    this.jdField_a_of_type_Bbgu.show();
    axqy.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    this.jdField_a_of_type_Bbgu = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */