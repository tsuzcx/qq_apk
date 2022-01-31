package com.tencent.mobileqq.activity;

import adhr;
import adhs;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import azmj;
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bdfq jdField_a_of_type_Bdfq;
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559399);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    paramBundle = alpo.a(2131708291);
    this.jdField_a_of_type_Bdfq = null;
    this.jdField_a_of_type_Bdfq = bdcd.a(this, 230);
    this.jdField_a_of_type_Bdfq.setContentView(2131558920);
    this.jdField_a_of_type_Bdfq.setTitle(null).setMessage(getString(2131695131)).setPositiveButton(2131695130, new adhr(this));
    this.jdField_a_of_type_Bdfq.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bdfq.setOnKeyListener(new adhs(this));
    this.jdField_a_of_type_Bdfq.show();
    azmj.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    this.jdField_a_of_type_Bdfq = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */