package com.tencent.biz.pubaccount.readinjoy.common;

import bnrf;
import ozs;
import pai;
import sbf;
import sbg;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = pai.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    sbg localsbg = new sbg(null, null, null, null).a("folder_status", pai.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", pai.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bnrf.I(ozs.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localsbg.a("reddot_style", pai.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", pai.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = pai.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = pai.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    pai.a(str2, str1, "0X8009291", localsbg.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */