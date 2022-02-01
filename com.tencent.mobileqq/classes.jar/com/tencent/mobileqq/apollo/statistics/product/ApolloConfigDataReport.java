package com.tencent.mobileqq.apollo.statistics.product;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.listener.Download403Callback;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloConfigDataReport
{
  private static JSONObject a;
  private static HashSet<String> b;
  private static HashSet<String> c;
  private static HashSet<String> d;
  
  private static String a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dwtuin=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&sop_type=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&sop_name=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("&dwop_via=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&dwop_cnt=");
    localStringBuilder.append(1);
    localStringBuilder.append("&dwop_result=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("&dwflag2=");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("&dwflag3=");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("&dwflag4=");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("&dwflag5=");
    localStringBuilder.append(paramString7);
    return localStringBuilder.toString();
  }
  
  public static HashSet<String> a()
  {
    if (c == null) {
      ThreadManager.excute(new ApolloConfigDataReport.2(), 64, null, true);
    }
    return c;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    f();
    b(paramAppRuntime);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (((paramAppRuntime == null) || (!(paramAppRuntime instanceof QQAppInterface))) && (b == null)) {
      ThreadManager.excute(new ApolloConfigDataReport.4(), 64, null, true);
    }
    paramAppRuntime = b;
    if ((paramAppRuntime != null) && (paramAppRuntime.contains(paramString3))) {
      try
      {
        paramAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
        if (paramAppRuntime == null)
        {
          QLog.e("[cmshow]ApolloConfigDataReport", 1, "interceptReport appRuntime is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
        paramString1 = new WebSSOAgent.UniSsoServerReq();
        paramString1.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_dc_report.forward_data");
        ((JSONObject)localObject).put("from", "android");
        ((JSONObject)localObject).put("dcId", "644");
        paramString2 = a(paramString4, paramString2, paramString3, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
        ((JSONObject)localObject).put("fields_data", paramString2);
        paramString1.reqdata.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigDataReport", 2, new Object[] { "interceptReport sop_name:", paramString3, ",fields_data:", paramString2 });
        }
        paramString2 = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), WebSSOAgentServlet.class);
        paramString2.putExtra("extra_cmd", "apollo_dc_report.forward_data");
        paramString2.putExtra("extra_data", paramString1.toByteArray());
        paramString2.putExtra("extra_timeout", 15000);
        paramString2.setObserver(new ApolloConfigDataReport.5());
        paramAppRuntime.startServlet(paramString2);
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigDataReport", 1, "interceptReport Exception:", paramAppRuntime);
        paramAppRuntime.printStackTrace();
      }
    }
  }
  
  public static HashSet<String> b()
  {
    if (d == null) {
      ThreadManager.excute(new ApolloConfigDataReport.3(), 64, null, true);
    }
    return d;
  }
  
  private static HashSet<String> b(int paramInt, JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONObject == null)
    {
      QLog.e("[cmshow]ApolloConfigDataReport", 1, "storeStabilityWatchCMDList mBaseJSONObj is null");
      return localHashSet;
    }
    JSONArray localJSONArray = null;
    if (paramInt == 1) {}
    try
    {
      localJSONArray = paramJSONObject.optJSONArray("store_stable_watch_cmd_list");
      break label54;
      if (paramInt == 2) {
        localJSONArray = paramJSONObject.optJSONArray("store_stable_watch_url_list");
      }
      label54:
      if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
        break label111;
      }
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.optString(paramInt);
        if (!TextUtils.isEmpty(paramJSONObject)) {
          localHashSet.add(paramJSONObject);
        }
        paramInt += 1;
      }
    }
    catch (Exception paramJSONObject)
    {
      label101:
      break label101;
    }
    QLog.e("[cmshow]ApolloConfigDataReport", 1, "storeStabilityWatchCMDList Exception e:", paramJSONObject);
    label111:
    return localHashSet;
  }
  
  private static HashSet<String> b(JSONObject paramJSONObject)
  {
    localHashSet = new HashSet();
    if (paramJSONObject == null)
    {
      QLog.e("[cmshow]ApolloConfigDataReport", 1, "parseReportConfigJson mBaseJSONObj is null");
      return localHashSet;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("644_opname");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          String str = paramJSONObject.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localHashSet.add(str);
          }
          i += 1;
        }
      }
      return localHashSet;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("[cmshow]ApolloConfigDataReport", 1, "parseReportConfigJson Exception e:", paramJSONObject);
    }
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!NetworkUtil.isNetworkAvailable(null)) {
      return;
    }
    ThreadManager.excute(new ApolloConfigDataReport.1(paramAppRuntime), 128, null, true);
  }
  
  private static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, Download403Callback paramDownload403Callback)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      DownloaderInterface localDownloaderInterface = ApolloResDownloaderUtil.a(paramAppRuntime);
      if (localDownloaderInterface == null) {
        return;
      }
      if (localDownloaderInterface.getTask(paramString1) != null) {
        return;
      }
      File localFile = new File(paramString2);
      paramString2 = new DownloadTask(paramString1, localFile);
      if (localFile.exists())
      {
        SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("apollo_sp", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_lastModifiedTime");
        paramString2.I = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        long l = localSharedPreferences.getLong(paramString1, 0L);
        if (localFile.lastModified() != l) {
          paramString2.G = true;
        }
      }
      paramString2.N = true;
      paramString2.D = true;
      paramString2.J = true;
      paramString2.T = false;
      paramString2.L = "apollo_res";
      paramString2.Q = true;
      paramString2.P = true;
      paramString1 = new Bundle();
      localDownloaderInterface.startDownload(paramString2, new ApolloConfigDataReport.Download403Listener(paramAppRuntime, paramDownload403Callback), paramString1);
    }
  }
  
  public static void c()
  {
    HashSet localHashSet = b;
    if (localHashSet != null) {
      localHashSet.clear();
    }
    localHashSet = c;
    if (localHashSet != null) {
      localHashSet.clear();
    }
    localHashSet = d;
    if (localHashSet != null) {
      localHashSet.clear();
    }
  }
  
  private static void f()
  {
    a = g();
    b = b(a);
    c = b(1, a);
    d = b(2, a);
  }
  
  private static JSONObject g()
  {
    Object localObject = FileUtils.readFile("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json");
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloConfigDataReport", 1, "parseBasicJson file is null");
      return null;
    }
    localObject = new String((byte[])localObject);
    try
    {
      localObject = new JSONObject((String)localObject).optJSONArray("terminalForword");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localObject = ((JSONArray)localObject).optJSONObject(0);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloConfigDataReport", 1, "parseBasicJson Exception e:", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport
 * JD-Core Version:    0.7.0.1
 */