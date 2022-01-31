package com.tencent.mobileqq.activity;

import abqn;
import abqo;
import ajyc;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import axqw;
import bbcv;
import bbgg;
import com.tencent.mobileqq.app.BaseActivity;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bbgg jdField_a_of_type_Bbgg;
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
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    paramBundle = ajyc.a(2131707908);
    this.jdField_a_of_type_Bbgg = null;
    this.jdField_a_of_type_Bbgg = bbcv.a(this, 230);
    this.jdField_a_of_type_Bbgg.setContentView(2131558883);
    this.jdField_a_of_type_Bbgg.setTitle(null).setMessage(getString(2131694973)).setPositiveButton(2131694972, new abqn(this));
    this.jdField_a_of_type_Bbgg.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bbgg.setOnKeyListener(new abqo(this));
    this.jdField_a_of_type_Bbgg.show();
    axqw.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    this.jdField_a_of_type_Bbgg = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */