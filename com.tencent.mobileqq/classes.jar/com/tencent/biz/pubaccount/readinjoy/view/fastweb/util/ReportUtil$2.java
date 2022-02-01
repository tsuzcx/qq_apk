package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReportUtil$2
  implements Runnable
{
  ReportUtil$2(ColorNote paramColorNote, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = ViolaColorNote.b(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      if (localObject != null)
      {
        if (((JSONObject)localObject).length() == 0) {
          return;
        }
        long l1 = NetConnInfoCenter.getServerTime();
        long l2 = this.jdField_a_of_type_Long;
        localObject = new VideoR5.Builder(((JSONObject)localObject).toString()).i(l1 - l2).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", (String)localObject, false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReportUtil", 1, "handleViolaRemainTimeReport: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.2
 * JD-Core Version:    0.7.0.1
 */