package com.tencent.biz.pubaccount.readinjoy.common;

import bjxj;
import ors;
import osm;
import rom;
import ron;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = osm.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    ron localron = new ron(null, null, null, null).a("folder_status", osm.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", osm.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(bjxj.L(ors.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localron.a("reddot_style", osm.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", osm.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = osm.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = osm.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    osm.a(str2, str1, "0X8009291", localron.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */