package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.QualityReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.common.app.BaseApplicationImpl;

class VideoFeedsPlayManager$8
  implements Runnable
{
  VideoFeedsPlayManager$8(VideoFeedsPlayManager paramVideoFeedsPlayManager, ReadinjoyVideoReportData paramReadinjoyVideoReportData) {}
  
  public void run()
  {
    RIJStatisticCollectorReport.a(BaseApplicationImpl.getContext(), ReadInJoyUtils.a(), true, this.a.a());
    QualityReporter.a(this.a);
    RIJStatisticCollectorReport.a(this.a.jdField_a_of_type_Boolean, this.a.jdField_d_of_type_Boolean, this.a.h, this.a.jdField_a_of_type_Int, this.a.jdField_d_of_type_Long, 409409, this.a.c, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.8
 * JD-Core Version:    0.7.0.1
 */