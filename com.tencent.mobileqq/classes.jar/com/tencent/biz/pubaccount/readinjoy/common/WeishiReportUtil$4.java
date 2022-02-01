package com.tencent.biz.pubaccount.readinjoy.common;

import bmhv;
import pkh;
import pkp;
import sut;
import suu;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = pkp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    suu localsuu = new suu(null, null, null, null).a("folder_status", pkp.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", pkp.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bmhv.F(pkh.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localsuu.a("reddot_style", pkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", pkp.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = pkp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = pkp.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    pkp.a(str2, str1, "0X8009291", localsuu.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */