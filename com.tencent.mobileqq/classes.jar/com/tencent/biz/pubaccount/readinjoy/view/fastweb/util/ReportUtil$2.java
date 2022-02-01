package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import odq;
import org.json.JSONObject;
import sid;
import sie;
import tgl;

public final class ReportUtil$2
  implements Runnable
{
  public ReportUtil$2(ColorNote paramColorNote, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = tgl.b(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      if (localJSONObject != null)
      {
        if (localJSONObject.length() == 0) {
          return;
        }
        long l1 = NetConnInfoCenter.getServerTime();
        long l2 = this.jdField_a_of_type_Long;
        odq.a(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", new sie(localJSONObject.toString()).i(l1 - l2).a().a(), false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReportUtil", 1, "handleViolaRemainTimeReport: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.2
 * JD-Core Version:    0.7.0.1
 */