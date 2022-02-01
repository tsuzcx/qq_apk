package com.tencent.mobileqq.applets;

import ahdq;
import alzs;
import aoqq;
import bcst;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$7
  implements Runnable
{
  public PublicAccountEventReport$7(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      aoqq.a(str1, 138, str2, bool);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB4", "0X8009EB4", 2, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.c, "");
      if (ahdq.a(this.jdField_a_of_type_JavaLangString)) {
        alzs.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.7
 * JD-Core Version:    0.7.0.1
 */