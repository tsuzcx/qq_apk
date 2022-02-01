package com.tencent.aelight.camera.ae.view;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AECameraErrorDialog
{
  private static final String jdField_a_of_type_JavaLangString = "AECameraErrorDialog";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  public AECameraErrorDialog(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131699201);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131693890), new AECameraErrorDialog.1(this, paramRunnable));
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    catch (WindowManager.BadTokenException paramRunnable)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "", paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECameraErrorDialog
 * JD-Core Version:    0.7.0.1
 */