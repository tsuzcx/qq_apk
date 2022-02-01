package com.tencent.biz.pubaccount.readinjoy.common;

import bmqa;
import pha;
import phq;
import skb;
import skc;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = phq.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    skc localskc = new skc(null, null, null, null).a("folder_status", phq.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", phq.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bmqa.K(pha.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localskc.a("reddot_style", phq.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", phq.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = phq.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = phq.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    phq.a(str2, str1, "0X8009291", localskc.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */