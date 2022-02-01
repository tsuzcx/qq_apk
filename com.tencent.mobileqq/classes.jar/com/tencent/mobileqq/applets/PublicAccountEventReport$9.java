package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class PublicAccountEventReport$9
  implements Runnable
{
  PublicAccountEventReport$9(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.b);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", str, "0X8009EB5", "0X8009EB5", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.9
 * JD-Core Version:    0.7.0.1
 */