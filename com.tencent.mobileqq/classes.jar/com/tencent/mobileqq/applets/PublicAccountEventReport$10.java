package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class PublicAccountEventReport$10
  implements Runnable
{
  PublicAccountEventReport$10(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2) {}
  
  public void run()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB6", "0X8009EB6", this.jdField_a_of_type_Int, 0, "" + this.jdField_b_of_type_Int, "", this.jdField_a_of_type_Long + "", "");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc05007", "", this.jdField_a_of_type_JavaLangString, "0X8009EB6", "0X8009EB6", this.jdField_a_of_type_Int, 0, "" + this.jdField_b_of_type_Int, "", this.jdField_a_of_type_Long + "", this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.10
 * JD-Core Version:    0.7.0.1
 */