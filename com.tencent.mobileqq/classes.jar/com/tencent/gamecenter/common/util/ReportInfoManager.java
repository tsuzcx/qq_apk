package com.tencent.gamecenter.common.util;

import aaht;
import aahu;
import aahv;
import aahw;
import akwd;
import akzp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bdug;
import bfbm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private ArrayList<aahv> reportAdInfoList = new ArrayList();
  
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
    aahv localaahv = new aahv();
    localaahv.jdField_a_of_type_JavaLangString = paramString1;
    localaahv.jdField_b_of_type_JavaLangString = paramString2;
    localaahv.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localaahv);
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
              aahv localaahv = new aahv();
              localaahv.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localaahv.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localaahv.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localaahv);
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
        aahv localaahv = (aahv)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localaahv.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localaahv.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localaahv.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(aahw paramaahw)
  {
    if (paramaahw == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramaahw.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramaahw.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramaahw.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramaahw.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramaahw.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramaahw.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramaahw.d);
      localJSONObject.put("gamecenter_ver", paramaahw.e);
      localJSONObject.put("device_type", paramaahw.f);
      localJSONObject.put("net_type", paramaahw.g);
      localJSONObject.put("resolution", paramaahw.h);
      localJSONObject.put("ret_id", paramaahw.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramaahw)
    {
      for (;;)
      {
        paramaahw.printStackTrace();
      }
    }
  }
  
  public aahw genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    aahw localaahw = new aahw();
    localaahw.jdField_a_of_type_JavaLangString = paramString1;
    localaahw.jdField_b_of_type_JavaLangString = paramString2;
    localaahw.f = Build.MODEL;
    localaahw.jdField_c_of_type_JavaLangString = "1";
    localaahw.e = paramString3;
    localaahw.jdField_b_of_type_Int = 108;
    localaahw.g = paramString4;
    localaahw.jdField_c_of_type_Int = 16001;
    localaahw.jdField_a_of_type_Int = 1;
    localaahw.h = paramString5;
    localaahw.d = bfbm.a().d();
    return localaahw;
  }
  
  public void postClickReportInfo(aahw paramaahw)
  {
    if (paramaahw == null) {
      return;
    }
    paramaahw = convertInfoObjectToJson(paramaahw);
    long l = paramaahw.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new aaht(this, l)).a(str, paramaahw);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, aahu paramaahu)
  {
    paramaahu = new ReportInfoManager.ReportChannlInfo();
    paramaahu.channel_id = paramString2;
    paramaahu.pos_id = paramString3;
    paramaahu.pos_name = paramString4;
    paramaahu.resource_id = paramString5;
    paramaahu.schedule_id = paramString6;
    paramaahu.appid = paramString7;
    paramaahu.oper_type = paramInt;
    paramaahu.act_id = paramString1;
    paramString1 = akwd.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((bdug)paramString1.getBusinessHandler(71)).a(paramaahu);
      return;
    }
    ((akzp)akwd.a().getBusinessHandler(0)).a(paramaahu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */