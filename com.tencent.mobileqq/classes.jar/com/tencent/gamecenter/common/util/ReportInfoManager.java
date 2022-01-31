package com.tencent.gamecenter.common.util;

import aade;
import aadf;
import aadg;
import aadh;
import akro;
import akva;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bdpx;
import bexd;
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
  private ArrayList<aadg> reportAdInfoList = new ArrayList();
  
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
    aadg localaadg = new aadg();
    localaadg.jdField_a_of_type_JavaLangString = paramString1;
    localaadg.jdField_b_of_type_JavaLangString = paramString2;
    localaadg.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localaadg);
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
              aadg localaadg = new aadg();
              localaadg.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localaadg.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localaadg.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localaadg);
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
        aadg localaadg = (aadg)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localaadg.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localaadg.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localaadg.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(aadh paramaadh)
  {
    if (paramaadh == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramaadh.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramaadh.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramaadh.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramaadh.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramaadh.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramaadh.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramaadh.d);
      localJSONObject.put("gamecenter_ver", paramaadh.e);
      localJSONObject.put("device_type", paramaadh.f);
      localJSONObject.put("net_type", paramaadh.g);
      localJSONObject.put("resolution", paramaadh.h);
      localJSONObject.put("ret_id", paramaadh.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramaadh)
    {
      for (;;)
      {
        paramaadh.printStackTrace();
      }
    }
  }
  
  public aadh genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    aadh localaadh = new aadh();
    localaadh.jdField_a_of_type_JavaLangString = paramString1;
    localaadh.jdField_b_of_type_JavaLangString = paramString2;
    localaadh.f = Build.MODEL;
    localaadh.jdField_c_of_type_JavaLangString = "1";
    localaadh.e = paramString3;
    localaadh.jdField_b_of_type_Int = 108;
    localaadh.g = paramString4;
    localaadh.jdField_c_of_type_Int = 16001;
    localaadh.jdField_a_of_type_Int = 1;
    localaadh.h = paramString5;
    localaadh.d = bexd.a().d();
    return localaadh;
  }
  
  public void postClickReportInfo(aadh paramaadh)
  {
    if (paramaadh == null) {
      return;
    }
    paramaadh = convertInfoObjectToJson(paramaadh);
    long l = paramaadh.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new aade(this, l)).a(str, paramaadh);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, aadf paramaadf)
  {
    paramaadf = new ReportInfoManager.ReportChannlInfo();
    paramaadf.channel_id = paramString2;
    paramaadf.pos_id = paramString3;
    paramaadf.pos_name = paramString4;
    paramaadf.resource_id = paramString5;
    paramaadf.schedule_id = paramString6;
    paramaadf.appid = paramString7;
    paramaadf.oper_type = paramInt;
    paramaadf.act_id = paramString1;
    paramString1 = akro.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((bdpx)paramString1.getBusinessHandler(71)).a(paramaadf);
      return;
    }
    ((akva)akro.a().getBusinessHandler(0)).a(paramaadf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */