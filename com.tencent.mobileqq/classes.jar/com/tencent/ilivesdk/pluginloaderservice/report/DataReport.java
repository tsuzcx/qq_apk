package com.tencent.ilivesdk.pluginloaderservice.report;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;

public class DataReport
{
  private static DataReportInterface a;
  public static String a;
  public static String b = "get_version_fail";
  public static String c = "get_version_success";
  public static String d = "get_plugin_fail";
  public static String e = "get_plugin_success";
  public static String f = "install_to_install";
  public static String g = "install_start_install";
  public static String h = "install_download_fail";
  public static String i = "install_download_success";
  public static String j = "install_install_fail";
  public static String k = "install_install_success";
  public static String l = "install_loader_fail";
  public static String m = "install_loader_success";
  public static String n = "install_updater_fail";
  public static String o = "install_updater_success";
  public static String p = "loader_class_fail";
  public static String q = "loader_class_success";
  public static String r = "install_finish_install";
  public static String s = "zt_str1";
  
  static
  {
    jdField_a_of_type_JavaLangString = "event_install_fail";
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface = null;
  }
  
  public static void a(DataReportInterface paramDataReportInterface)
  {
    jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface = paramDataReportInterface;
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface == null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(jdField_a_of_type_JavaLangString).addKeyValue(s, paramString).send();
    }
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(b).addKeyValue(s, paramString).send();
    }
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(c).addKeyValue(s, paramString).send();
    }
  }
  
  public static void d(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(d).addKeyValue(s, paramString).send();
    }
  }
  
  public static void e(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(e).addKeyValue(s, paramString).send();
    }
  }
  
  public static void f(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(f).addKeyValue(s, paramString).send();
    }
  }
  
  public static void g(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(g).addKeyValue(s, paramString).send();
    }
  }
  
  public static void h(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(h).addKeyValue(s, paramString).send();
    }
  }
  
  public static void i(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(i).addKeyValue(s, paramString).send();
    }
  }
  
  public static void j(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(j).addKeyValue(s, paramString).send();
    }
  }
  
  public static void k(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(l).addKeyValue(s, paramString).send();
    }
  }
  
  public static void l(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(k).addKeyValue(s, paramString).send();
    }
  }
  
  public static void m(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(r).addKeyValue(s, paramString).send();
    }
  }
  
  public static void n(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(n).addKeyValue(s, paramString).send();
    }
  }
  
  public static void o(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(o).addKeyValue(s, paramString).send();
    }
  }
  
  public static void p(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(p).addKeyValue(s, paramString).send();
    }
  }
  
  public static void q(String paramString)
  {
    if (jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface != null) {
      jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.newQualityTask().setActType(q).addKeyValue(s, paramString).send();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.report.DataReport
 * JD-Core Version:    0.7.0.1
 */