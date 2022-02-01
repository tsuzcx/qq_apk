package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.open.adapter.CommonDataAdapter;
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
  private ArrayList<ReportInfoManager.ReportInfo> reportAdInfoList = new ArrayList();
  
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
    ReportInfoManager.ReportInfo localReportInfo = new ReportInfoManager.ReportInfo();
    localReportInfo.a = paramString1;
    localReportInfo.b = paramString2;
    localReportInfo.c = paramString3;
    this.reportAdInfoList.add(localReportInfo);
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
        while (i < j)
        {
          try
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            ReportInfoManager.ReportInfo localReportInfo = new ReportInfoManager.ReportInfo();
            localReportInfo.a = localJSONObject.getString("appid");
            localReportInfo.b = localJSONObject.getString("actionname");
            localReportInfo.c = localJSONObject.getString("timestamp");
            this.reportAdInfoList.add(localReportInfo);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          i += 1;
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
        ReportInfoManager.ReportInfo localReportInfo = (ReportInfoManager.ReportInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localReportInfo.a);
        localJSONObject2.put("actionname", localReportInfo.b);
        localJSONObject2.put("timestamp", localReportInfo.c);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("items", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1.toString();
  }
  
  public void clearReportInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", "");
    paramContext.commit();
    this.reportAdInfoList.clear();
  }
  
  public String convertInfoObjectToJson(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramReportPGActInfo.a);
      localJSONObject.put("entrance_status", paramReportPGActInfo.b);
      localJSONObject.put("gamecenter_src", paramReportPGActInfo.c);
      localJSONObject.put("oper_moudle", paramReportPGActInfo.d);
      localJSONObject.put("module_type", paramReportPGActInfo.e);
      localJSONObject.put("oper_id", paramReportPGActInfo.f);
      localJSONObject.put("sq_ver", paramReportPGActInfo.g);
      localJSONObject.put("gamecenter_ver", paramReportPGActInfo.h);
      localJSONObject.put("device_type", paramReportPGActInfo.i);
      localJSONObject.put("net_type", paramReportPGActInfo.j);
      localJSONObject.put("resolution", paramReportPGActInfo.k);
      localJSONObject.put("ret_id", paramReportPGActInfo.l);
    }
    catch (JSONException paramReportPGActInfo)
    {
      paramReportPGActInfo.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public ReportInfoManager.ReportPGActInfo genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportInfoManager.ReportPGActInfo localReportPGActInfo = new ReportInfoManager.ReportPGActInfo();
    localReportPGActInfo.a = paramString1;
    localReportPGActInfo.b = paramString2;
    localReportPGActInfo.i = Build.MODEL;
    localReportPGActInfo.c = "1";
    localReportPGActInfo.h = paramString3;
    localReportPGActInfo.e = 108;
    localReportPGActInfo.j = paramString4;
    localReportPGActInfo.f = 16001;
    localReportPGActInfo.d = 1;
    localReportPGActInfo.k = paramString5;
    localReportPGActInfo.g = CommonDataAdapter.a().j();
    return localReportPGActInfo;
  }
  
  public void postClickReportInfo(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return;
    }
    paramReportPGActInfo = convertInfoObjectToJson(paramReportPGActInfo);
    long l = paramReportPGActInfo.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.d()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new ReportInfoManager.1(this, l)).a(str, paramReportPGActInfo);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */