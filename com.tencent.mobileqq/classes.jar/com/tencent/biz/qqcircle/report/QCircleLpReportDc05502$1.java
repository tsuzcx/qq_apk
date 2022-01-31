package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;
import qqcircle.QQCircleReport.SingleDcData;
import tyh;
import tym;
import typ;

public final class QCircleLpReportDc05502$1
  implements Runnable
{
  public QCircleLpReportDc05502$1(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, List paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("touin", this.jdField_a_of_type_JavaLangString), tym.a("index", String.valueOf(this.jdField_a_of_type_Int + 1)), tym.a("feedid", this.jdField_b_of_type_JavaLangString), tym.a("feed_tag", this.jdField_c_of_type_JavaLangString), tym.a("isreaded", "1"), tym.a("page_id", String.valueOf(this.jdField_b_of_type_Int)), tym.a("fpage_id", String.valueOf(this.jdField_c_of_type_Int)), tym.a("begin_time", this.jdField_d_of_type_JavaLangString), tym.a("end_time", this.jdField_e_of_type_JavaLangString), tym.a("stay_time", this.f), tym.a("author_uin", this.g) }));
    if (this.jdField_a_of_type_JavaUtilList != null) {
      ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_c_of_type_Int > -1) {
      ((List)localObject).add(tym.a("fpage_id", String.valueOf(this.jdField_c_of_type_Int)));
    }
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.has()) {
        localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      try
      {
        localStReportInfoForClient.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("feedtype1", String.valueOf(localStReportInfoForClient.feedtype1.get())), tym.a("feedtype2", String.valueOf(localStReportInfoForClient.feedtype2.get())), tym.a("feedtype3", String.valueOf(localStReportInfoForClient.feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("feedtype1", String.valueOf(this.jdField_d_of_type_Int)), tym.a("feedtype2", String.valueOf(this.jdField_e_of_type_Int)) }));
      }
      ((List)localObject).addAll(tym.a().a());
      localObject = tym.a(tyh.a(), (List)localObject, null, tym.a().a(this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      typ.a().a((QQCircleReport.SingleDcData)localObject, true);
      return;
      int i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05502.1
 * JD-Core Version:    0.7.0.1
 */