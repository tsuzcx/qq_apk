package com.tencent.biz.qqcircle.report;

import com.tencent.TMG.utils.QLog;
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
import tyk;
import tym;
import typ;

public final class QCircleLpReportDc05507$2
  implements Runnable
{
  public QCircleLpReportDc05507$2(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("touin", this.jdField_a_of_type_JavaLangString), tym.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), tym.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), tym.a("feedid", this.jdField_b_of_type_JavaLangString), tym.a("author_uin", this.jdField_c_of_type_JavaLangString), tym.a("play_scene", String.valueOf(this.jdField_c_of_type_Int)), tym.a("page_id", String.valueOf(this.jdField_d_of_type_Int)), tym.a("fpage_id", String.valueOf(this.jdField_e_of_type_Int)), tym.a("position_id", String.valueOf(this.jdField_f_of_type_Int)), tym.a("feed_tag", this.jdField_d_of_type_JavaLangString), tym.a("video_tag", this.jdField_e_of_type_JavaLangString), tym.a("pic_info", this.jdField_f_of_type_JavaLangString), tym.a("item_detail", this.jdField_g_of_type_JavaLangString), tym.a("acttime", String.valueOf(System.currentTimeMillis())) }));
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
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
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("feedtype1", String.valueOf(this.jdField_g_of_type_Int)), tym.a("feedtype2", String.valueOf(this.h)) }));
      }
      ((List)localObject).addAll(tym.a().a());
      localObject = tym.a(tyk.a(), (List)localObject, null, tym.a().a(this.jdField_d_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      if (tym.a().a())
      {
        typ.a().a((QQCircleReport.SingleDcData)localObject, tyk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        return;
        i = 0;
      }
      else
      {
        QLog.w("QCircleReporter", 1, "QCircleLpReportDc05507 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_b_of_type_Int + ",add Miss Session report cache list");
        typ.a().b((QQCircleReport.SingleDcData)localObject);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.2
 * JD-Core Version:    0.7.0.1
 */