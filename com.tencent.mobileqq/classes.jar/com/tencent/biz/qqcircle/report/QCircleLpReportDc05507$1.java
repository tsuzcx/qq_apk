package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tzw;
import tzy;
import uab;

public final class QCircleLpReportDc05507$1
  implements Runnable
{
  public QCircleLpReportDc05507$1(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, boolean paramBoolean, String paramString, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    FeedCloudCommon.Entry localEntry1 = tzy.a("actiontype", String.valueOf(this.jdField_a_of_type_Int));
    FeedCloudCommon.Entry localEntry2 = tzy.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int));
    FeedCloudCommon.Entry localEntry3 = tzy.a("play_scene", String.valueOf(this.c));
    FeedCloudCommon.Entry localEntry4 = tzy.a("page_id", String.valueOf(this.d));
    FeedCloudCommon.Entry localEntry5 = tzy.a("fpage_id", String.valueOf(this.e));
    FeedCloudCommon.Entry localEntry6 = tzy.a("position_id", String.valueOf(this.f + 1));
    FeedCloudCommon.Entry localEntry7 = tzy.a("video_play_time", String.valueOf(this.jdField_a_of_type_Long));
    FeedCloudCommon.Entry localEntry8 = tzy.a("video_solo_time", String.valueOf(this.jdField_b_of_type_Long));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localArrayList.addAll(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, tzy.a("is_auto_play", (String)localObject), tzy.a("errorcode", this.jdField_a_of_type_JavaLangString) }));
      localArrayList.addAll(tzy.a().a());
      localObject = tzy.a(tzw.a(), localArrayList, null, tzy.a().a(this.d, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      uab.a().a((QQCircleReport.SingleDcData)localObject, tzw.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.1
 * JD-Core Version:    0.7.0.1
 */