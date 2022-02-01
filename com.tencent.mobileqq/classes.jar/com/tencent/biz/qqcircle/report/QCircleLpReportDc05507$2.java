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
import vrg;
import vri;
import vrl;

public final class QCircleLpReportDc05507$2
  implements Runnable
{
  public QCircleLpReportDc05507$2(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt5, int paramInt6, List paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    Object localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("touin", this.jdField_a_of_type_JavaLangString), vri.a("actiontype", String.valueOf(this.jdField_a_of_type_Int)), vri.a("subactiontype", String.valueOf(this.jdField_b_of_type_Int)), vri.a("feedid", this.jdField_b_of_type_JavaLangString), vri.a("author_uin", this.jdField_c_of_type_JavaLangString), vri.a("play_scene", String.valueOf(this.jdField_c_of_type_Int)), vri.a("position_id", String.valueOf(this.jdField_d_of_type_Int + 1)), vri.a("feed_tag", this.jdField_d_of_type_JavaLangString), vri.a("video_tag", this.jdField_e_of_type_JavaLangString), vri.a("pic_info", this.jdField_f_of_type_JavaLangString), vri.a("item_detail", this.jdField_g_of_type_JavaLangString), vri.a("acttime", String.valueOf(System.currentTimeMillis())), vri.a("lloc", this.jdField_h_of_type_JavaLangString) }));
    label249:
    QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient;
    if (this.jdField_e_of_type_Int > -1)
    {
      ((List)localObject).add(vri.a("page_id", String.valueOf(this.jdField_e_of_type_Int)));
      if (this.jdField_f_of_type_Int <= -1) {
        break label512;
      }
      ((List)localObject).add(vri.a("fpage_id", String.valueOf(this.jdField_f_of_type_Int)));
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {
        break label597;
      }
      if (!this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.has()) {
        break label539;
      }
      localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
    }
    for (;;)
    {
      try
      {
        localStReportInfoForClient.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("feedtype1", String.valueOf(localStReportInfoForClient.feedtype1.get())), vri.a("feedtype2", String.valueOf(localStReportInfoForClient.feedtype2.get())), vri.a("feedtype3", String.valueOf(localStReportInfoForClient.feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label512:
        localInvalidProtocolBufferMicroException.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((List)localObject).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("feedtype1", String.valueOf(this.jdField_g_of_type_Int)), vri.a("feedtype2", String.valueOf(this.jdField_h_of_type_Int)) }));
      }
      ((List)localObject).addAll(vri.a().a());
      localObject = vri.a(vrg.a(), (List)localObject, null, vri.a().a(this.jdField_e_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed));
      if (vri.a().a())
      {
        vrl.a().a((QQCircleReport.SingleDcData)localObject, vrg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        return;
        ((List)localObject).add(vri.a("page_id", "0"));
        break;
        ((List)localObject).add(vri.a("fpage_id", "0"));
        break label249;
        label539:
        i = 0;
        continue;
      }
      QLog.w("QCircleReporter", 1, "QCircleLpReportDc05507 report miss Session: actiontype:" + this.jdField_a_of_type_Int + ",subActionType:" + this.jdField_b_of_type_Int + ",add Miss Session report cache list");
      vrl.a().b((QQCircleReport.SingleDcData)localObject);
      return;
      label597:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.2
 * JD-Core Version:    0.7.0.1
 */