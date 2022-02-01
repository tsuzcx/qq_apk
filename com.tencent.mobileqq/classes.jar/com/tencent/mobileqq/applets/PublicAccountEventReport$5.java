package com.tencent.mobileqq.applets;

import ahcf;
import amed;
import android.text.TextUtils;
import apau;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$5
  implements Runnable
{
  public PublicAccountEventReport$5(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface, String paramString5) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      apau.a(str1, 137, str2, bool, this.c, this.d);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 2, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.e, "");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc05007", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 2, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.e, this.jdField_b_of_type_JavaLangString);
      }
      if (ahcf.a(this.jdField_a_of_type_JavaLangString)) {
        amed.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.5
 * JD-Core Version:    0.7.0.1
 */