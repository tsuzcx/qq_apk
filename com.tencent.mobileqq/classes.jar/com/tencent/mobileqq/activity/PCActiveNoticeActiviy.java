package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import ten;
import teo;

public class PCActiveNoticeActiviy
  extends BaseActivity
{
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969139);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("uin"); TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_JavaLangString = null)
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2130968842);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null).setMessage(getString(2131437532)).setPositiveButton(2131437533, new ten(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTextContentDescription("此次启动是由于打开了“PC离线时自动启动QQ手机版”功能，可在“设置 消息通知”中管理此功能");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new teo(this));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PCActiveNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */