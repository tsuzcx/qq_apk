package com.tencent.gamecenter.common.util;

import abfc;
import abfd;
import abfe;
import abff;
import alvx;
import alzh;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bhpc;
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
  private ArrayList<abfe> reportAdInfoList = new ArrayList();
  
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
    abfe localabfe = new abfe();
    localabfe.jdField_a_of_type_JavaLangString = paramString1;
    localabfe.jdField_b_of_type_JavaLangString = paramString2;
    localabfe.jdField_c_of_type_JavaLangString = paramString3;
    this.reportAdInfoList.add(localabfe);
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
              abfe localabfe = new abfe();
              localabfe.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localabfe.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localabfe.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localabfe);
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
        abfe localabfe = (abfe)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localabfe.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localabfe.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localabfe.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(abff paramabff)
  {
    if (paramabff == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramabff.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramabff.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramabff.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramabff.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramabff.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramabff.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramabff.d);
      localJSONObject.put("gamecenter_ver", paramabff.e);
      localJSONObject.put("device_type", paramabff.f);
      localJSONObject.put("net_type", paramabff.g);
      localJSONObject.put("resolution", paramabff.h);
      localJSONObject.put("ret_id", paramabff.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramabff)
    {
      for (;;)
      {
        paramabff.printStackTrace();
      }
    }
  }
  
  public abff genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    abff localabff = new abff();
    localabff.jdField_a_of_type_JavaLangString = paramString1;
    localabff.jdField_b_of_type_JavaLangString = paramString2;
    localabff.f = Build.MODEL;
    localabff.jdField_c_of_type_JavaLangString = "1";
    localabff.e = paramString3;
    localabff.jdField_b_of_type_Int = 108;
    localabff.g = paramString4;
    localabff.jdField_c_of_type_Int = 16001;
    localabff.jdField_a_of_type_Int = 1;
    localabff.h = paramString5;
    localabff.d = bhpc.a().d();
    return localabff;
  }
  
  public void postClickReportInfo(abff paramabff)
  {
    if (paramabff == null) {
      return;
    }
    paramabff = convertInfoObjectToJson(paramabff);
    long l = paramabff.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new abfc(this, l)).a(str, paramabff);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, abfd paramabfd)
  {
    paramabfd = new ReportInfoManager.ReportChannlInfo();
    paramabfd.channel_id = paramString2;
    paramabfd.pos_id = paramString3;
    paramabfd.pos_name = paramString4;
    paramabfd.resource_id = paramString5;
    paramabfd.schedule_id = paramString6;
    paramabfd.appid = paramString7;
    paramabfd.oper_type = paramInt;
    paramabfd.act_id = paramString1;
    paramString1 = alvx.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((VasExtensionHandler)paramString1.getBusinessHandler(71)).a(paramabfd);
      return;
    }
    ((alzh)alvx.a().getBusinessHandler(0)).a(paramabfd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */