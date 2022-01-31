package com.tencent.biz.pubaccount.readinjoy.common;

import bhvh;
import onk;
import ooe;
import qzd;
import qze;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = ooe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    qze localqze = new qze(null, null, null, null).a("folder_status", ooe.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", ooe.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bhvh.L(onk.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localqze.a("reddot_style", ooe.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", ooe.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = ooe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = ooe.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    ooe.a(str2, str1, "0X8009291", localqze.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */