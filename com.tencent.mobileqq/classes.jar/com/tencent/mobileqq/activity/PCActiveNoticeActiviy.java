package com.tencent.mobileqq.activity;

import abgn;
import abgo;
import ajjy;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import awqx;
import babr;
import bafb;
import com.tencent.mobileqq.app.BaseActivity;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bafb jdField_a_of_type_Bafb;
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131493776);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    paramBundle = ajjy.a(2131642123);
    this.jdField_a_of_type_Bafb = null;
    this.jdField_a_of_type_Bafb = babr.a(this, 230);
    this.jdField_a_of_type_Bafb.setContentView(2131493323);
    this.jdField_a_of_type_Bafb.setTitle(null).setMessage(getString(2131629296)).setPositiveButton(2131629295, new abgn(this));
    this.jdField_a_of_type_Bafb.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bafb.setOnKeyListener(new abgo(this));
    this.jdField_a_of_type_Bafb.show();
    awqx.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    this.jdField_a_of_type_Bafb = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */