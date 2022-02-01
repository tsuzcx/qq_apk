package com.tencent.mobileqq.activity;

import Override;
import aesu;
import aesv;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import anni;
import bcst;
import bglp;
import bgpa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bgpa jdField_a_of_type_Bgpa;
  private String jdField_a_of_type_JavaLangString;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559516);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
    paramBundle = anni.a(2131706680);
    this.jdField_a_of_type_Bgpa = null;
    this.jdField_a_of_type_Bgpa = bglp.a(this, 230);
    this.jdField_a_of_type_Bgpa.setContentView(2131558985);
    this.jdField_a_of_type_Bgpa.setTitle(null).setMessage(getString(2131694181)).setPositiveButton(2131694180, new aesu(this));
    this.jdField_a_of_type_Bgpa.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bgpa.setOnKeyListener(new aesv(this));
    this.jdField_a_of_type_Bgpa.show();
    bcst.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
    this.jdField_a_of_type_Bgpa = null;
    super.finish();
  }
  
  public void onBackPressed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */