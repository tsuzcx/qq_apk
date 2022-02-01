package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
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
    localReportInfo.jdField_a_of_type_JavaLangString = paramString1;
    localReportInfo.jdField_b_of_type_JavaLangString = paramString2;
    localReportInfo.jdField_c_of_type_JavaLangString = paramString3;
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
        for (;;)
        {
          if (i < j) {
            try
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              ReportInfoManager.ReportInfo localReportInfo = new ReportInfoManager.ReportInfo();
              localReportInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("appid");
              localReportInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("actionname");
              localReportInfo.jdField_c_of_type_JavaLangString = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localReportInfo);
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
        ReportInfoManager.ReportInfo localReportInfo = (ReportInfoManager.ReportInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localReportInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("actionname", localReportInfo.jdField_b_of_type_JavaLangString);
        localJSONObject2.put("timestamp", localReportInfo.jdField_c_of_type_JavaLangString);
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
  
  public String convertInfoObjectToJson(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramReportPGActInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entrance_status", paramReportPGActInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("gamecenter_src", paramReportPGActInfo.jdField_c_of_type_JavaLangString);
      localJSONObject.put("oper_moudle", paramReportPGActInfo.jdField_a_of_type_Int);
      localJSONObject.put("module_type", paramReportPGActInfo.jdField_b_of_type_Int);
      localJSONObject.put("oper_id", paramReportPGActInfo.jdField_c_of_type_Int);
      localJSONObject.put("sq_ver", paramReportPGActInfo.d);
      localJSONObject.put("gamecenter_ver", paramReportPGActInfo.e);
      localJSONObject.put("device_type", paramReportPGActInfo.f);
      localJSONObject.put("net_type", paramReportPGActInfo.g);
      localJSONObject.put("resolution", paramReportPGActInfo.h);
      localJSONObject.put("ret_id", paramReportPGActInfo.i);
      return localJSONObject.toString();
    }
    catch (JSONException paramReportPGActInfo)
    {
      for (;;)
      {
        paramReportPGActInfo.printStackTrace();
      }
    }
  }
  
  public ReportInfoManager.ReportPGActInfo genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportInfoManager.ReportPGActInfo localReportPGActInfo = new ReportInfoManager.ReportPGActInfo();
    localReportPGActInfo.jdField_a_of_type_JavaLangString = paramString1;
    localReportPGActInfo.jdField_b_of_type_JavaLangString = paramString2;
    localReportPGActInfo.f = Build.MODEL;
    localReportPGActInfo.jdField_c_of_type_JavaLangString = "1";
    localReportPGActInfo.e = paramString3;
    localReportPGActInfo.jdField_b_of_type_Int = 108;
    localReportPGActInfo.g = paramString4;
    localReportPGActInfo.jdField_c_of_type_Int = 16001;
    localReportPGActInfo.jdField_a_of_type_Int = 1;
    localReportPGActInfo.h = paramString5;
    localReportPGActInfo.d = CommonDataAdapter.a().d();
    return localReportPGActInfo;
  }
  
  public void postClickReportInfo(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return;
    }
    paramReportPGActInfo = convertInfoObjectToJson(paramReportPGActInfo);
    long l = paramReportPGActInfo.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.a()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new ReportInfoManager.1(this, l)).a(str, paramReportPGActInfo);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, ReportInfoManager.ReportCallBack paramReportCallBack)
  {
    paramReportCallBack = new ReportInfoManager.ReportChannlInfo();
    paramReportCallBack.channel_id = paramString2;
    paramReportCallBack.pos_id = paramString3;
    paramReportCallBack.pos_name = paramString4;
    paramReportCallBack.resource_id = paramString5;
    paramReportCallBack.schedule_id = paramString6;
    paramReportCallBack.appid = paramString7;
    paramReportCallBack.oper_type = paramInt;
    paramReportCallBack.act_id = paramString1;
    paramString1 = CmGameUtil.a();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((IApolloExtensionHandler)paramString1.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramReportCallBack);
      return;
    }
    ((CmGameSSoHandler)CmGameUtil.a().getBusinessHandler(CmGameAppInterface.jdField_a_of_type_JavaLangString)).a(paramReportCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */