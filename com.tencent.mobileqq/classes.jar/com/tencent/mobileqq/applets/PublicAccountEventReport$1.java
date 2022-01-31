package com.tencent.mobileqq.applets;

import akwv;
import android.text.TextUtils;
import axqw;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$1
  implements Runnable
{
  public PublicAccountEventReport$1(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      akwv.a(str1, 101, str2, bool);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.c, "");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc05007", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.c, this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.1
 * JD-Core Version:    0.7.0.1
 */