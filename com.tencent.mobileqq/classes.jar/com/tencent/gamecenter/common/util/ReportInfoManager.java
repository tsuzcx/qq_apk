package com.tencent.gamecenter.common.util;

import ajae;
import ajdq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bbqp;
import bcxm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yon;
import yoo;
import yop;
import yoq;

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
  private ArrayList<yop> reportAdInfoList = new ArrayList();
  
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
    yop localyop = new yop();
    localyop.jdField_a_of_type_JavaLangString = paramString1;
    localyop.jdField_b_of_type_JavaLangString = paramString2;
    localyop.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localyop);
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
              yop localyop = new yop();
              localyop.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localyop.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localyop.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localyop);
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
        yop localyop = (yop)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localyop.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localyop.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localyop.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(yoq paramyoq)
  {
    if (paramyoq == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramyoq.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramyoq.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramyoq.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramyoq.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramyoq.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramyoq.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramyoq.d);
      localJSONObject.put("gamecenter_ver", paramyoq.e);
      localJSONObject.put("device_type", paramyoq.f);
      localJSONObject.put("net_type", paramyoq.g);
      localJSONObject.put("resolution", paramyoq.h);
      localJSONObject.put("ret_id", paramyoq.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramyoq)
    {
      for (;;)
      {
        paramyoq.printStackTrace();
      }
    }
  }
  
  public yoq genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    yoq localyoq = new yoq();
    localyoq.jdField_a_of_type_JavaLangString = paramString1;
    localyoq.jdField_b_of_type_JavaLangString = paramString2;
    localyoq.f = Build.MODEL;
    localyoq.jdField_c_of_type_JavaLangString = "1";
    localyoq.e = paramString3;
    localyoq.jdField_b_of_type_Int = 108;
    localyoq.g = paramString4;
    localyoq.jdField_c_of_type_Int = 16001;
    localyoq.jdField_a_of_type_Int = 1;
    localyoq.h = paramString5;
    localyoq.d = bcxm.a().d();
    return localyoq;
  }
  
  public void postClickReportInfo(yoq paramyoq)
  {
    if (paramyoq == null) {
      return;
    }
    paramyoq = convertInfoObjectToJson(paramyoq);
    long l = paramyoq.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new yon(this, l)).a(str, paramyoq);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, yoo paramyoo)
  {
    paramyoo = new ReportInfoManager.ReportChannlInfo();
    paramyoo.channel_id = paramString2;
    paramyoo.pos_id = paramString3;
    paramyoo.pos_name = paramString4;
    paramyoo.resource_id = paramString5;
    paramyoo.schedule_id = paramString6;
    paramyoo.appid = paramString7;
    paramyoo.oper_type = paramInt;
    paramyoo.act_id = paramString1;
    paramString1 = ajae.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((bbqp)paramString1.getBusinessHandler(71)).a(paramyoo);
      return;
    }
    ((ajdq)ajae.a().getBusinessHandler(0)).a(paramyoo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */