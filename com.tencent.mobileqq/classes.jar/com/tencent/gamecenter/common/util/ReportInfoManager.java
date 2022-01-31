package com.tencent.gamecenter.common.util;

import ajac;
import ajdo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bbrd;
import bcyb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yok;
import yol;
import yom;
import yon;

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
  private ArrayList<yom> reportAdInfoList = new ArrayList();
  
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
    yom localyom = new yom();
    localyom.jdField_a_of_type_JavaLangString = paramString1;
    localyom.jdField_b_of_type_JavaLangString = paramString2;
    localyom.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localyom);
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
              yom localyom = new yom();
              localyom.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localyom.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localyom.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localyom);
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
        yom localyom = (yom)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localyom.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localyom.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localyom.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(yon paramyon)
  {
    if (paramyon == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramyon.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramyon.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramyon.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramyon.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramyon.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramyon.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramyon.d);
      localJSONObject.put("gamecenter_ver", paramyon.e);
      localJSONObject.put("device_type", paramyon.f);
      localJSONObject.put("net_type", paramyon.g);
      localJSONObject.put("resolution", paramyon.h);
      localJSONObject.put("ret_id", paramyon.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramyon)
    {
      for (;;)
      {
        paramyon.printStackTrace();
      }
    }
  }
  
  public yon genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    yon localyon = new yon();
    localyon.jdField_a_of_type_JavaLangString = paramString1;
    localyon.jdField_b_of_type_JavaLangString = paramString2;
    localyon.f = Build.MODEL;
    localyon.jdField_c_of_type_JavaLangString = "1";
    localyon.e = paramString3;
    localyon.jdField_b_of_type_Int = 108;
    localyon.g = paramString4;
    localyon.jdField_c_of_type_Int = 16001;
    localyon.jdField_a_of_type_Int = 1;
    localyon.h = paramString5;
    localyon.d = bcyb.a().d();
    return localyon;
  }
  
  public void postClickReportInfo(yon paramyon)
  {
    if (paramyon == null) {
      return;
    }
    paramyon = convertInfoObjectToJson(paramyon);
    long l = paramyon.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new yok(this, l)).a(str, paramyon);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, yol paramyol)
  {
    paramyol = new ReportInfoManager.ReportChannlInfo();
    paramyol.channel_id = paramString2;
    paramyol.pos_id = paramString3;
    paramyol.pos_name = paramString4;
    paramyol.resource_id = paramString5;
    paramyol.schedule_id = paramString6;
    paramyol.appid = paramString7;
    paramyol.oper_type = paramInt;
    paramyol.act_id = paramString1;
    paramString1 = ajac.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((bbrd)paramString1.getBusinessHandler(71)).a(paramyol);
      return;
    }
    ((ajdo)ajac.a().getBusinessHandler(0)).a(paramyol);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */