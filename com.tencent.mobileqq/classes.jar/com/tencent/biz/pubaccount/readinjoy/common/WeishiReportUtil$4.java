package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import cooperation.readinjoy.ReadInJoyHelper;

final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, null).a("folder_status", WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("EnterType", WeishiReportUtil.c(this.jdField_a_of_type_Int)).a("is_jump_to_video_content", Integer.valueOf(ReadInJoyHelper.C(ReadInJoyUtils.a())));
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null)) {
      localBuilder.a("reddot_style", WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("algorithm_id", WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      str1 = WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    }
    WeishiReportUtil.a(str2, str1, "0X8009291", localBuilder.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */