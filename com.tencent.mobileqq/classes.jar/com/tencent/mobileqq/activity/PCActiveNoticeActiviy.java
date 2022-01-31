package com.tencent.mobileqq.activity;

import admg;
import admh;
import alud;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import azqs;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bdjz jdField_a_of_type_Bdjz;
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559398);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    paramBundle = alud.a(2131708303);
    this.jdField_a_of_type_Bdjz = null;
    this.jdField_a_of_type_Bdjz = bdgm.a(this, 230);
    this.jdField_a_of_type_Bdjz.setContentView(2131558919);
    this.jdField_a_of_type_Bdjz.setTitle(null).setMessage(getString(2131695133)).setPositiveButton(2131695132, new admg(this));
    this.jdField_a_of_type_Bdjz.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bdjz.setOnKeyListener(new admh(this));
    this.jdField_a_of_type_Bdjz.show();
    azqs.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */