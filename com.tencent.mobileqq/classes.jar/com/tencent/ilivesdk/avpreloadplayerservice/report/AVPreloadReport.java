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
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Long));
    ((Map)localObject1).put("clipstarttime", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Long));
    ((Map)localObject1).put("clipfinishtime", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Long));
    ((Map)localObject1).put("playstoptime", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_e_of_type_Long);
    ((Map)localObject1).put("snapshot", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_f_of_type_Long);
    ((Map)localObject1).put("firstframe", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_g_of_type_Long);
    ((Map)localObject1).put("clipduration", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_h_of_type_Long);
    ((Map)localObject1).put("clipsize", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("x");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Int);
    ((StringBuilder)localObject2).append("@");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Int);
    ((StringBuilder)localObject2).append("@");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_i_of_type_Long);
    ((Map)localObject1).put("mediainfo", ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_JavaUtilMap.put("url", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_JavaLangString);
    Object localObject3 = this.jdField_a_of_type_JavaUtilMap;
    boolean bool = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Boolean;
    localObject2 = "0";
    if (bool) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ((Map)localObject3).put("ismiss", localObject1);
    localObject3 = this.jdField_a_of_type_JavaUtilMap;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_b_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject3).put("chaseframe", localObject1);
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Int);
    ((Map)localObject1).put("errorcode", ((StringBuilder)localObject3).toString());
    this.jdField_a_of_type_JavaUtilMap.put("eventid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_JavaLangString);
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_j_of_type_Long);
    ((Map)localObject1).put("netspeed", ((StringBuilder)localObject3).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_a_of_type_Float);
    ((Map)localObject1).put("cpurate", ((StringBuilder)localObject3).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(a());
    ((Map)localObject1).put("memorysize", ((StringBuilder)localObject3).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_k_of_type_Long);
    ((Map)localObject1).put("framegaptime", ((StringBuilder)localObject3).toString());
    localObject3 = this.jdField_a_of_type_JavaUtilMap;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_c_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject3).put("isplayconnect", localObject1);
    this.jdField_a_of_type_JavaUtilMap.put("taskid", this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_JavaLangString);
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_l_of_type_Long);
    ((Map)localObject1).put("showsnapshottime", ((StringBuilder)localObject3).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.m);
    ((Map)localObject1).put("avgnetspeed", ((StringBuilder)localObject3).toString());
    this.jdField_a_of_type_JavaUtilMap.put("osversion", Build.VERSION.RELEASE);
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.n);
    ((Map)localObject1).put("devicememorysize", ((StringBuilder)localObject3).toString());
    localObject3 = this.jdField_a_of_type_JavaUtilMap;
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData.jdField_d_of_type_Boolean) {
      localObject1 = "1";
    }
    ((Map)localObject3).put("isswitchroom", localObject1);
  }
  
  public void a(AVPreloadReport.ReportData paramReportData)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadplayerserviceReportAVPreloadReport$ReportData = paramReportData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVPreloadReport
 * JD-Core Version:    0.7.0.1
 */