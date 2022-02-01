package com.tencent.mobileqq.applets;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

final class PublicAccountEventReport$6
  implements Runnable
{
  PublicAccountEventReport$6(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface, String paramString4) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    String str = this.jdField_b_of_type_JavaLangString;
    boolean bool;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.mPosition);
    localStringBuilder.append("");
    PublicAccountEventReport.a((String)localObject1, 102, str, bool, (String)localObject2, localStringBuilder.toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    str = this.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", str, "0X8009EB4", "0X8009EB4", 1, 0, (String)localObject2, localStringBuilder.toString(), this.d, "");
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType());
    if (this.jdField_b_of_type_Int > 0) {
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 102, (MessageRecord)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.6
 * JD-Core Version:    0.7.0.1
 */