package com.tencent.gamecenter.common.util;

import aing;
import aiqs;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import baot;
import bbtm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yfj;
import yfk;
import yfl;
import yfm;

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
  private ArrayList<yfl> reportAdInfoList = new ArrayList();
  
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
    yfl localyfl = new yfl();
    localyfl.jdField_a_of_type_JavaLangString = paramString1;
    localyfl.jdField_b_of_type_JavaLangString = paramString2;
    localyfl.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localyfl);
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
              yfl localyfl = new yfl();
              localyfl.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localyfl.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localyfl.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localyfl);
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
        yfl localyfl = (yfl)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localyfl.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localyfl.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localyfl.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(yfm paramyfm)
  {
    if (paramyfm == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramyfm.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramyfm.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramyfm.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramyfm.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramyfm.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramyfm.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramyfm.d);
      localJSONObject.put("gamecenter_ver", paramyfm.e);
      localJSONObject.put("device_type", paramyfm.f);
      localJSONObject.put("net_type", paramyfm.g);
      localJSONObject.put("resolution", paramyfm.h);
      localJSONObject.put("ret_id", paramyfm.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramyfm)
    {
      for (;;)
      {
        paramyfm.printStackTrace();
      }
    }
  }
  
  public yfm genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    yfm localyfm = new yfm();
    localyfm.jdField_a_of_type_JavaLangString = paramString1;
    localyfm.jdField_b_of_type_JavaLangString = paramString2;
    localyfm.f = Build.MODEL;
    localyfm.jdField_c_of_type_JavaLangString = "1";
    localyfm.e = paramString3;
    localyfm.jdField_b_of_type_Int = 108;
    localyfm.g = paramString4;
    localyfm.jdField_c_of_type_Int = 16001;
    localyfm.jdField_a_of_type_Int = 1;
    localyfm.h = paramString5;
    localyfm.d = bbtm.a().d();
    return localyfm;
  }
  
  public void postClickReportInfo(yfm paramyfm)
  {
    if (paramyfm == null) {
      return;
    }
    paramyfm = convertInfoObjectToJson(paramyfm);
    long l = paramyfm.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new yfj(this, l)).a(str, paramyfm);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, yfk paramyfk)
  {
    paramyfk = new ReportInfoManager.ReportChannlInfo();
    paramyfk.channel_id = paramString2;
    paramyfk.pos_id = paramString3;
    paramyfk.pos_name = paramString4;
    paramyfk.resource_id = paramString5;
    paramyfk.schedule_id = paramString6;
    paramyfk.appid = paramString7;
    paramyfk.oper_type = paramInt;
    paramyfk.act_id = paramString1;
    paramString1 = aing.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((baot)paramString1.getBusinessHandler(71)).a(paramyfk);
      return;
    }
    ((aiqs)aing.a().getBusinessHandler(0)).a(paramyfk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */