package com.tencent.ilivesdk.avpreloadplayerservice.report;

import android.os.Build;
import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AVPreloadReport
  extends AVBaseReport
{
  private AVPreloadReport.ReportData a;
  
  private float a()
  {
    return (float)(Runtime.getRuntime().totalMemory() / 1048576L);
  }
  
  private String a(long paramLong)
  {
    if (paramLong == 0L) {
      return " ";
    }
    Date localDate = new Date();
    localDate.setTime(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS").format(localDate);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("attaid", "01000048340");
    this.jdField_a_of_type_JavaUtilMap.put("token", "9298697425");
    this.jdField_a_of_type_JavaUtilMap.put("terminal", "android");
    this.jdField_a_of_type_JavaUtilMap.put("mode", Build.MODEL);
    this.jdField_a_of_type_JavaUtilMap.put("clienttype", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("network", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("vistorsrc", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("bundle", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("roomid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("name", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("userid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("guid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("anchorid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap.put("playtime", a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Long));
    this.jdField_a_of_type_JavaUtilMap.put("clipstarttime", "" + a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilMap.put("clipfinishtime", "" + a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Long));
    this.jdField_a_of_type_JavaUtilMap.put("playstoptime", "" + a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long));
    this.jdField_a_of_type_JavaUtilMap.put("snapshot", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_e_of_type_Long);
    this.jdField_a_of_type_JavaUtilMap.put("firstframe", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_Long);
    this.jdField_a_of_type_JavaUtilMap.put("clipduration", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long);
    this.jdField_a_of_type_JavaUtilMap.put("clipsize", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long);
    this.jdField_a_of_type_JavaUtilMap.put("mediainfo", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Int + "x" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Int + "@" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Int + "@" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_Long);
    this.jdField_a_of_type_JavaUtilMap.put("url", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString);
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Boolean)
    {
      str = "0";
      localMap.put("ismiss", str);
      localMap = this.jdField_a_of_type_JavaUtilMap;
      if (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Boolean) {
        break label1094;
      }
      str = "1";
      label672:
      localMap.put("chaseframe", str);
      this.jdField_a_of_type_JavaUtilMap.put("errorcode", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Int);
      this.jdField_a_of_type_JavaUtilMap.put("eventid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilMap.put("netspeed", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_Long);
      this.jdField_a_of_type_JavaUtilMap.put("cpurate", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaUtilMap.put("memorysize", "" + a());
      this.jdField_a_of_type_JavaUtilMap.put("framegaptime", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_Long);
      localMap = this.jdField_a_of_type_JavaUtilMap;
      if (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Boolean) {
        break label1100;
      }
      str = "1";
      label901:
      localMap.put("isplayconnect", str);
      this.jdField_a_of_type_JavaUtilMap.put("taskid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilMap.put("showsnapshottime", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_Long);
      this.jdField_a_of_type_JavaUtilMap.put("avgnetspeed", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.m);
      this.jdField_a_of_type_JavaUtilMap.put("osversion", Build.VERSION.RELEASE);
      this.jdField_a_of_type_JavaUtilMap.put("devicememorysize", "" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.n);
      localMap = this.jdField_a_of_type_JavaUtilMap;
      if (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Boolean) {
        break label1106;
      }
    }
    label1094:
    label1100:
    label1106:
    for (String str = "1";; str = "0")
    {
      localMap.put("isswitchroom", str);
      return;
      str = "1";
      break;
      str = "0";
      break label672;
      str = "0";
      break label901;
    }
  }
  
  public void a(AVPreloadReport.ReportData paramReportData)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData = paramReportData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport
 * JD-Core Version:    0.7.0.1
 */