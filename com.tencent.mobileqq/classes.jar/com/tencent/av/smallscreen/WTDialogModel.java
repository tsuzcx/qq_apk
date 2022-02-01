package com.tencent.av.smallscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.BaseActivity;

public class WTDialogModel
  extends DialogModelBase
{
  private int jdField_a_of_type_Int = 1;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String jdField_a_of_type_JavaLangString = null;
  
  public WTDialogModel(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_MqqAppBaseActivity, 230).setTitle(null).setMessage(this.jdField_a_of_type_JavaLangString).setNegativeButton(2131695980, new WTDialogModel.1(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null))
    {
      e();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        a("WTDialogModel.onResume", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      }
      return;
    }
    this.jdField_a_of_type_MqqAppBaseActivity.finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_MqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("tag_style", 1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("tag_msg");
    if ((this.jdField_a_of_type_Int == 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_MqqAppBaseActivity.finish();
    }
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.WTDialogModel
 * JD-Core Version:    0.7.0.1
 */