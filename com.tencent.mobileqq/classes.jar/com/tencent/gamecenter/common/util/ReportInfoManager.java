package com.tencent.gamecenter.common.util;

import aciu;
import aciv;
import aciw;
import acix;
import anbd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anen;
import bjjo;
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
  private ArrayList<aciw> reportAdInfoList = new ArrayList();
  
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
    aciw localaciw = new aciw();
    localaciw.jdField_a_of_type_JavaLangString = paramString1;
    localaciw.jdField_b_of_type_JavaLangString = paramString2;
    localaciw.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localaciw);
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
              aciw localaciw = new aciw();
              localaciw.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localaciw.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localaciw.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localaciw);
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
        aciw localaciw = (aciw)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localaciw.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localaciw.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localaciw.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(acix paramacix)
  {
    if (paramacix == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramacix.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramacix.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramacix.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramacix.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramacix.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramacix.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramacix.d);
      localJSONObject.put("gamecenter_ver", paramacix.e);
      localJSONObject.put("device_type", paramacix.f);
      localJSONObject.put("net_type", paramacix.g);
      localJSONObject.put("resolution", paramacix.h);
      localJSONObject.put("ret_id", paramacix.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramacix)
    {
      for (;;)
      {
        paramacix.printStackTrace();
      }
    }
  }
  
  public acix genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    acix localacix = new acix();
    localacix.jdField_a_of_type_JavaLangString = paramString1;
    localacix.jdField_b_of_type_JavaLangString = paramString2;
    localacix.f = Build.MODEL;
    localacix.jdField_c_of_type_JavaLangString = "1";
    localacix.e = paramString3;
    localacix.jdField_b_of_type_Int = 108;
    localacix.g = paramString4;
    localacix.jdField_c_of_type_Int = 16001;
    localacix.jdField_a_of_type_Int = 1;
    localacix.h = paramString5;
    localacix.d = bjjo.a().d();
    return localacix;
  }
  
  public void postClickReportInfo(acix paramacix)
  {
    if (paramacix == null) {
      return;
    }
    paramacix = convertInfoObjectToJson(paramacix);
    long l = paramacix.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new aciu(this, l)).a(str, paramacix);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, aciv paramaciv)
  {
    paramaciv = new ReportInfoManager.ReportChannlInfo();
    paramaciv.channel_id = paramString2;
    paramaciv.pos_id = paramString3;
    paramaciv.pos_name = paramString4;
    paramaciv.resource_id = paramString5;
    paramaciv.schedule_id = paramString6;
    paramaciv.appid = paramString7;
    paramaciv.oper_type = paramInt;
    paramaciv.act_id = paramString1;
    paramString1 = anbd.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((VasExtensionHandler)paramString1.getBusinessHandler(71)).a(paramaciv);
      return;
    }
    ((anen)anbd.a().getBusinessHandler(0)).a(paramaciv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */