package com.tencent.mobileqq.applets;

import amnk;
import android.text.TextUtils;
import azmj;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$2
  implements Runnable
{
  public PublicAccountEventReport$2(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      amnk.a(str1, 101, str2, bool);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.c, "");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc05007", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.c, this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.2
 * JD-Core Version:    0.7.0.1
 */