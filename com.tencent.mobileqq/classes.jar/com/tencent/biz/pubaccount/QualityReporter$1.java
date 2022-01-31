package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import now;
import qbu;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.BasicInfo;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.PlayInfo;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.VideoInfo;

public final class QualityReporter$1
  implements Runnable
{
  public QualityReporter$1(qbu paramqbu) {}
  
  public void run()
  {
    cc_sso_report_svr.ReportInfoReq localReportInfoReq = new cc_sso_report_svr.ReportInfoReq();
    localReportInfoReq.basic_info.channel.set(0);
    localReportInfoReq.basic_info.platform.set(1);
    localReportInfoReq.basic_info.version.set("8.3.0.4480");
    localReportInfoReq.basic_info.setHasFlag(true);
    localReportInfoReq.video_info.busitype.set(this.a.jdField_a_of_type_Int);
    localReportInfoReq.video_info.file_size.set(this.a.p);
    localReportInfoReq.video_info.video_duration.set(this.a.s);
    PBUInt32Field localPBUInt32Field = localReportInfoReq.video_info.encode_type;
    if (this.a.jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localPBUInt32Field.set(i);
      localReportInfoReq.video_info.weight.set(this.a.jdField_i_of_type_Int);
      localReportInfoReq.video_info.height.set(this.a.j);
      localReportInfoReq.video_info.rate.set(String.valueOf(this.a.jdField_o_of_type_Long));
      localReportInfoReq.video_info.setHasFlag(true);
      localReportInfoReq.play_info.genurl_duration.set(this.a.jdField_i_of_type_Long);
      localReportInfoReq.play_info.genurl_errcode.set(this.a.jdField_d_of_type_Int);
      localReportInfoReq.play_info.prepare_duration.set(this.a.jdField_c_of_type_Long);
      localReportInfoReq.play_info.play_duration.set(this.a.jdField_a_of_type_Long);
      localReportInfoReq.play_info.play_errcode.set(this.a.jdField_c_of_type_JavaLangString);
      localReportInfoReq.play_info.skipframe_cnt.set(this.a.jdField_o_of_type_Int);
      localReportInfoReq.play_info.setHasFlag(true);
      if (QLog.isColorLevel()) {
        QLog.d("QualityReporter", 2, "reportVideoQulity: vid=" + this.a.b);
      }
      now.a(localReportInfoReq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.QualityReporter.1
 * JD-Core Version:    0.7.0.1
 */