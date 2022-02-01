package com.tencent.mobileqq.activity;

import Override;
import afby;
import afbz;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import anzj;
import bdll;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private bhpc jdField_a_of_type_Bhpc;
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
    super.setContentView(2131559521);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    paramBundle = anzj.a(2131706789);
    this.jdField_a_of_type_Bhpc = null;
    this.jdField_a_of_type_Bhpc = bhlq.a(this, 230);
    this.jdField_a_of_type_Bhpc.setContentView(2131558984);
    this.jdField_a_of_type_Bhpc.setTitle(null).setMessage(getString(2131694199)).setPositiveButton(2131694198, new afby(this));
    this.jdField_a_of_type_Bhpc.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_Bhpc.setOnKeyListener(new afbz(this));
    this.jdField_a_of_type_Bhpc.show();
    bdll.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    this.jdField_a_of_type_Bhpc = null;
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