package com.tencent.gamecenter.common.util;

import abur;
import abus;
import abut;
import abuu;
import amwn;
import amzx;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bizw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportInfoManager
{
  public static final String ACTION_CANCEL = "cancel";
  public static final String ACTION_DOWNLOAD = "download";
  public static final String ACTION_FINISH = "finish";
  public static final String ACTION_PROFILE = "profile";
  public static final String ACTION_START = "start";
  private static final String REPORT_INFO = "report_info";
  private static final String SHAREDPREFERENCES_NAME = "gamecenter_preferences";
  private static ReportInfoManager instance;
  private ArrayList<abut> reportAdInfoList = new ArrayList();
  
  public static ReportInfoManager getInstance()
  {
    if (instance == null) {
      instance = new ReportInfoManager();
    }
    return instance;
  }
  
  private void saveReportInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", changeList2JSONStr());
    paramContext.commit();
  }
  
  public void addReportInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    abut localabut = new abut();
    localabut.jdField_a_of_type_JavaLangString = paramString1;
    localabut.jdField_b_of_type_JavaLangString = paramString2;
    localabut.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localabut);
    saveReportInfo(paramContext);
  }
  
  public void changeJSONStr2List(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.reportAdInfoList.clear();
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              abut localabut = new abut();
              localabut.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localabut.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localabut.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localabut);
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public String changeList2JSONStr()
  {
    if (this.reportAdInfoList.size() <= 0) {
      return "";
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.reportAdInfoList.iterator();
      while (localIterator.hasNext())
      {
        abut localabut = (abut)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localabut.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localabut.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localabut.jdField_c_of_type_JavaLangString);
        localJSONArray.put(localJSONObject2);
        continue;
        return localJSONObject1.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject1.put("items", localJSONException);
    }
  }
  
  public void clearReportInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", "");
    paramContext.commit();
    this.reportAdInfoList.clear();
  }
  
  public String convertInfoObjectToJson(abuu paramabuu)
  {
    if (paramabuu == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramabuu.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramabuu.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramabuu.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramabuu.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramabuu.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramabuu.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramabuu.d);
      localJSONObject.put("gamecenter_ver", paramabuu.e);
      localJSONObject.put("device_type", paramabuu.f);
      localJSONObject.put("net_type", paramabuu.g);
      localJSONObject.put("resolution", paramabuu.h);
      localJSONObject.put("ret_id", paramabuu.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramabuu)
    {
      for (;;)
      {
        paramabuu.printStackTrace();
      }
    }
  }
  
  public abuu genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    abuu localabuu = new abuu();
    localabuu.jdField_a_of_type_JavaLangString = paramString1;
    localabuu.jdField_b_of_type_JavaLangString = paramString2;
    localabuu.f = Build.MODEL;
    localabuu.jdField_c_of_type_JavaLangString = "1";
    localabuu.e = paramString3;
    localabuu.jdField_b_of_type_Int = 108;
    localabuu.g = paramString4;
    localabuu.jdField_c_of_type_Int = 16001;
    localabuu.jdField_a_of_type_Int = 1;
    localabuu.h = paramString5;
    localabuu.d = bizw.a().d();
    return localabuu;
  }
  
  public void postClickReportInfo(abuu paramabuu)
  {
    if (paramabuu == null) {
      return;
    }
    paramabuu = convertInfoObjectToJson(paramabuu);
    long l = paramabuu.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new abur(this, l)).a(str, paramabuu);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, abus paramabus)
  {
    paramabus = new ReportInfoManager.ReportChannlInfo();
    paramabus.channel_id = paramString2;
    paramabus.pos_id = paramString3;
    paramabus.pos_name = paramString4;
    paramabus.resource_id = paramString5;
    paramabus.schedule_id = paramString6;
    paramabus.appid = paramString7;
    paramabus.oper_type = paramInt;
    paramabus.act_id = paramString1;
    paramString1 = amwn.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((VasExtensionHandler)paramString1.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(paramabus);
      return;
    }
    ((amzx)amwn.a().getBusinessHandler(0)).a(paramabus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */