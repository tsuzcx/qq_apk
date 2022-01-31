package com.tencent.biz.pubaccount.readinjoy.common;

import bgmq;
import obz;
import oct;
import qmu;
import qmv;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = oct.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    qmv localqmv = new qmv(null, null, null, null).a("folder_status", oct.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", oct.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bgmq.L(obz.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localqmv.a("reddot_style", oct.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", oct.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = oct.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = oct.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    oct.a(str2, str1, "0X8009291", localqmv.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */