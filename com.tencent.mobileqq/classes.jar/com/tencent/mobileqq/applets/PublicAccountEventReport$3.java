package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import anxs;
import bcef;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$3
  implements Runnable
{
  public PublicAccountEventReport$3(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface, String paramString4) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      anxs.a(str1, 101, str2, bool, this.c, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.mPosition + "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.d, "");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc05007", "", this.jdField_a_of_type_JavaLangString, "0X8009EB3", "0X8009EB3", 1, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", this.d, this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.3
 * JD-Core Version:    0.7.0.1
 */