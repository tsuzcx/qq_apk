package com.tencent.gamecenter.common.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.open.adapter.CommonDataAdapter;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import qho;

public class ReportInfoManager
{
  private static ReportInfoManager jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static ReportInfoManager a()
  {
    if (jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager == null) {
      jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager = new ReportInfoManager();
    }
    return jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager;
  }
  
  public ReportInfoManager.ReportPGActInfo a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportInfoManager.ReportPGActInfo localReportPGActInfo = new ReportInfoManager.ReportPGActInfo();
    localReportPGActInfo.jdField_a_of_type_JavaLangString = paramString1;
    localReportPGActInfo.jdField_b_of_type_JavaLangString = paramString2;
    localReportPGActInfo.f = Build.MODEL;
    localReportPGActInfo.jdField_c_of_type_JavaLangString = "1";
    localReportPGActInfo.e = paramString3;
    localReportPGActInfo.jdField_b_of_type_Int = 108;
    localReportPGActInfo.g = paramString4;
    localReportPGActInfo.jdField_c_of_type_Int = 16001;
    localReportPGActInfo.jdField_a_of_type_Int = 1;
    localReportPGActInfo.h = paramString5;
    localReportPGActInfo.d = CommonDataAdapter.a().d();
    return localReportPGActInfo;
  }
  
  public String a(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramReportPGActInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramReportPGActInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramReportPGActInfo.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramReportPGActInfo.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramReportPGActInfo.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramReportPGActInfo.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramReportPGActInfo.d);
      localJSONObject.put("gamecenter_ver", paramReportPGActInfo.e);
      localJSONObject.put("device_type", paramReportPGActInfo.f);
      localJSONObject.put("net_type", paramReportPGActInfo.g);
      localJSONObject.put("resolution", paramReportPGActInfo.h);
      localJSONObject.put("ret_id", paramReportPGActInfo.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramReportPGActInfo)
    {
      for (;;)
      {
        paramReportPGActInfo.printStackTrace();
      }
    }
  }
  
  public void a(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return;
    }
    paramReportPGActInfo = a(paramReportPGActInfo);
    long l = paramReportPGActInfo.getBytes().length;
    String str = String.format("http://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.jdField_a_of_type_Int), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new qho(this, l)).a(str, paramReportPGActInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */