package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String jdField_a_of_type_JavaLangString;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559628);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    paramBundle = HardCodeUtil.a(2131707895);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131559060);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null).setMessage(getString(2131694732)).setPositiveButton(2131694731, new PCActiveNoticeActiviy.1(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTextContentDescription(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new PCActiveNoticeActiviy.2(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    ReportController.b(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
    return false;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */