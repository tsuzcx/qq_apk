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
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", str, "0X8009EB6", "0X8009EB6", i, 0, (String)localObject, "", localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      ReportController.b(localQQAppInterface, "dc05007", "", str, "0X8009EB6", "0X8009EB6", i, 0, (String)localObject, "", localStringBuilder.toString(), this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.10
 * JD-Core Version:    0.7.0.1
 */