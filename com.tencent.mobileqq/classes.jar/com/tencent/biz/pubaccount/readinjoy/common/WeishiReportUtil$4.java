package com.tencent.biz.pubaccount.readinjoy.common;

import bkwm;
import pay;
import pbo;
import sid;
import sie;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = pbo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    sie localsie = new sie(null, null, null, null).a("folder_status", pbo.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", pbo.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bkwm.F(pay.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localsie.a("reddot_style", pbo.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", pbo.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = pbo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = pbo.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    pbo.a(str2, str1, "0X8009291", localsie.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */