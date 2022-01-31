package com.tencent.biz.pubaccount.readinjoy.common;

import bhvy;
import onh;
import oob;
import qza;
import qzb;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = oob.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    qzb localqzb = new qzb(null, null, null, null).a("folder_status", oob.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", oob.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bhvy.L(onh.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localqzb.a("reddot_style", oob.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", oob.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = oob.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = oob.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    oob.a(str2, str1, "0X8009291", localqzb.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */