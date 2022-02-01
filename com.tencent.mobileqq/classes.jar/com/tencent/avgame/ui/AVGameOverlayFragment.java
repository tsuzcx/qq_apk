package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AVGameOverlayFragment
  extends QPublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showKickMeDialog");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setMessage(null).setNegativeButton(null, null).setPositiveButton(2131690280, new AVGameOverlayFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null);
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      str = getString(2131690331);
    } else {
      str = this.jdField_a_of_type_JavaLangString;
    }
    localQQCustomDialog.setMessage(str);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 0);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("tip");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    localQBaseActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameOverlayFragment
 * JD-Core Version:    0.7.0.1
 */