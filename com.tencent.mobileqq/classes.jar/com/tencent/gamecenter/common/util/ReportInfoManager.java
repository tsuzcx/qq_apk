package com.tencent.gamecenter.common.util;

import acet;
import aceu;
import acev;
import acew;
import ampj;
import amst;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import biip;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
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
  private ArrayList<acev> reportAdInfoList = new ArrayList();
  
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
    acev localacev = new acev();
    localacev.jdField_a_of_type_JavaLangString = paramString1;
    localacev.jdField_b_of_type_JavaLangString = paramString2;
    localacev.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localacev);
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
              acev localacev = new acev();
              localacev.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localacev.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localacev.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localacev);
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
        acev localacev = (acev)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localacev.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localacev.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localacev.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(acew paramacew)
  {
    if (paramacew == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramacew.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramacew.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramacew.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramacew.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramacew.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramacew.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramacew.d);
      localJSONObject.put("gamecenter_ver", paramacew.e);
      localJSONObject.put("device_type", paramacew.f);
      localJSONObject.put("net_type", paramacew.g);
      localJSONObject.put("resolution", paramacew.h);
      localJSONObject.put("ret_id", paramacew.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramacew)
    {
      for (;;)
      {
        paramacew.printStackTrace();
      }
    }
  }
  
  public acew genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    acew localacew = new acew();
    localacew.jdField_a_of_type_JavaLangString = paramString1;
    localacew.jdField_b_of_type_JavaLangString = paramString2;
    localacew.f = Build.MODEL;
    localacew.jdField_c_of_type_JavaLangString = "1";
    localacew.e = paramString3;
    localacew.jdField_b_of_type_Int = 108;
    localacew.g = paramString4;
    localacew.jdField_c_of_type_Int = 16001;
    localacew.jdField_a_of_type_Int = 1;
    localacew.h = paramString5;
    localacew.d = biip.a().d();
    return localacew;
  }
  
  public void postClickReportInfo(acew paramacew)
  {
    if (paramacew == null) {
      return;
    }
    paramacew = convertInfoObjectToJson(paramacew);
    long l = paramacew.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new acet(this, l)).a(str, paramacew);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, aceu paramaceu)
  {
    paramaceu = new ReportInfoManager.ReportChannlInfo();
    paramaceu.channel_id = paramString2;
    paramaceu.pos_id = paramString3;
    paramaceu.pos_name = paramString4;
    paramaceu.resource_id = paramString5;
    paramaceu.schedule_id = paramString6;
    paramaceu.appid = paramString7;
    paramaceu.oper_type = paramInt;
    paramaceu.act_id = paramString1;
    paramString1 = ampj.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((VasExtensionHandler)paramString1.getBusinessHandler(71)).a(paramaceu);
      return;
    }
    ((amst)ampj.a().getBusinessHandler(0)).a(paramaceu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */