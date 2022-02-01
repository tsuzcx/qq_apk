package com.tencent.mobileqq.ar;

import android.content.Context;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FaceUIController
{
  Context a;
  public ARTipsManager a;
  public QQCustomDialog a;
  
  public FaceUIController(Context paramContext, ARTipsManager paramARTipsManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager = paramARTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new FaceUIController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690200, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690199, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131690202);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    ReportController.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceUIController
 * JD-Core Version:    0.7.0.1
 */