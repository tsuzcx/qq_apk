package com.tencent.biz.qqcircle.report;

import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import vrg;
import vri;
import vrl;

public final class QCircleLpReportDc05507$1
  implements Runnable
{
  public QCircleLpReportDc05507$1(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, boolean paramBoolean, String paramString, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    FeedCloudCommon.Entry localEntry1 = vri.a("actiontype", String.valueOf(this.jdField_a_of_type_Int));
    FeedCloudCommon.Entry localEntry2 = vri.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int));
    FeedCloudCommon.Entry localEntry3 = vri.a("play_scene", String.valueOf(this.c));
    FeedCloudCommon.Entry localEntry4 = vri.a("page_id", String.valueOf(this.d));
    FeedCloudCommon.Entry localEntry5 = vri.a("position_id", String.valueOf(this.e + 1));
    FeedCloudCommon.Entry localEntry6 = vri.a("video_play_time", String.valueOf(this.jdField_a_of_type_Long));
    FeedCloudCommon.Entry localEntry7 = vri.a("video_solo_time", String.valueOf(this.jdField_b_of_type_Long));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localArrayList.addAll(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, vri.a("is_auto_play", (String)localObject), vri.a("errorcode", this.jdField_a_of_type_JavaLangString) }));
      localArrayList.addAll(vri.a().a());
      localObject = vri.a(vrg.a(), localArrayList, null, vri.a().a(this.d, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      vrl.a().a((QQCircleReport.SingleDcData)localObject, vrg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.1
 * JD-Core Version:    0.7.0.1
 */