package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;
import qqcircle.QQCircleReport.SingleDcData;
import tzs;
import tzy;
import uab;

public final class QCircleLpReportDc05501$1
  implements Runnable
{
  public QCircleLpReportDc05501$1(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4, int paramInt5, String paramString4, int paramInt6, List paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("touin", this.jdField_a_of_type_JavaLangString), tzy.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), tzy.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), tzy.a("index", String.valueOf(this.jdField_c_of_type_Int + 1)), tzy.a("feedid", this.jdField_b_of_type_JavaLangString), tzy.a("feed_tag", this.jdField_c_of_type_JavaLangString), tzy.a("isreaded", "1"), tzy.a("page_id", String.valueOf(this.jdField_d_of_type_Int)), tzy.a("fpage_id", String.valueOf(this.e)), tzy.a("author_uin", this.jdField_d_of_type_JavaLangString), tzy.a("acttime", String.valueOf(System.currentTimeMillis())) }));
    if (this.f > -1) {
      ((List)localObject).add(tzy.a("containerseq", String.valueOf(this.f + 1)));
    }
    if (this.e > -1) {
      ((List)localObject).add(tzy.a("fpage_id", String.valueOf(this.e)));
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
    }
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      ((List)localObject).add(tzy.a("ext1", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.fileId.get()));
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.has()) {
        localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localStReportInfoForClient.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("feedtype1", String.valueOf(localStReportInfoForClient.feedtype1.get())), tzy.a("feedtype2", String.valueOf(localStReportInfoForClient.feedtype2.get())), tzy.a("feedtype3", String.valueOf(localStReportInfoForClient.feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("feedtype1", String.valueOf(this.g)), tzy.a("feedtype2", String.valueOf(this.h)) }));
      }
      ((List)localObject).addAll(tzy.a().a());
      localObject = tzy.a(tzs.a(), (List)localObject, null, tzy.a().a(this.jdField_d_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      if (tzy.a().a())
      {
        uab.a().a((QQCircleReport.SingleDcData)localObject, tzs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        return;
        i = 0;
      }
      else
      {
        QLog.w("QCircleReporter", 1, "QCircleLpReportDc05501 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_b_of_type_Int + ",add Miss Session report cache list");
        uab.a().b((QQCircleReport.SingleDcData)localObject);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05501.1
 * JD-Core Version:    0.7.0.1
 */