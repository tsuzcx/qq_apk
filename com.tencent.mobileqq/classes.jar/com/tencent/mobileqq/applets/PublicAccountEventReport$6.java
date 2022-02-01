package com.tencent.mobileqq.applets;

import apau;
import bdla;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$6
  implements Runnable
{
  public PublicAccountEventReport$6(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface, String paramString4) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      apau.a(str1, 102, str2, bool, this.c, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.mPosition + "");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB4", "0X8009EB4", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.d, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.6
 * JD-Core Version:    0.7.0.1
 */