package com.huawei.hms.aaid.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.opendevice.r;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportAaidToken
{
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      HMSLog.e("ReportAaidToken", "Https response is empty.");
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      i = paramString1.optInt("ret", 256);
      if (i != 0) {
        break label132;
      }
      paramString1 = r.a(paramString3 + paramString2, "SHA-256");
      boolean bool = new q(paramContext, "push_client_self_info").a("reportAaidAndToken", paramString1);
      paramString1 = new StringBuilder().append("Report success ");
      if (!bool) {
        break label126;
      }
      paramContext = "and save success.";
    }
    catch (JSONException paramContext)
    {
      int i;
      for (;;)
      {
        HMSLog.e("ReportAaidToken", "Has JSONException.");
        return;
        paramContext = "but save failure.";
      }
      HMSLog.e("ReportAaidToken", "Https response body's ret code: " + i + ", error message: " + paramString1.optInt("msg"));
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("ReportAaidToken", "Exception occur.");
    }
    HMSLog.d("ReportAaidToken", paramContext);
    return;
    label126:
  }
  
  private static boolean b(Context paramContext)
  {
    int i = new PackageManagerHelper(paramContext).getPackageVersionCode("com.huawei.android.pushagent");
    HMSLog.d("ReportAaidToken", "NC version code: " + i);
    return ((90101400 <= i) && (i < 100000000)) || (i >= 100001301);
  }
  
  private static String c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("timezone", TimeZone.getDefault().getID());
      localJSONObject2.put("country", SystemUtils.getLocalCountry());
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("agent_version", new PackageManagerHelper(paramContext).getPackageVersionName("com.huawei.android.pushagent"));
      localJSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(paramContext)));
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.put("dev_type", ReportAaidToken.a.a.a());
      localJSONObject4.put("dev_sub_type", "phone");
      localJSONObject4.put("os_type", ReportAaidToken.b.b.a());
      localJSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
      localJSONObject1.put("id", UUID.randomUUID().toString());
      localJSONObject1.put("global", localJSONObject2);
      localJSONObject1.put("push_agent", localJSONObject3);
      localJSONObject1.put("hardware", localJSONObject4);
      localJSONObject1.put("aaid", paramString1);
      localJSONObject1.put("token", paramString2);
      localJSONObject1.put("app_id", AGConnectServicesConfig.fromContext(paramContext).getString("client/app_id"));
      localJSONObject1.put("region", AGConnectServicesConfig.fromContext(paramContext).getString("region"));
      return localJSONObject1.toString();
    }
    catch (JSONException paramContext)
    {
      HMSLog.e("ReportAaidToken", "Catch JSONException.");
    }
    return null;
  }
  
  private static boolean d(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new q(paramContext, "push_client_self_info");
    if (!paramContext.d("reportAaidAndToken")) {
      HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
    }
    do
    {
      return true;
      paramContext = paramContext.b("reportAaidAndToken");
      if (TextUtils.isEmpty(paramContext))
      {
        HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
        return true;
      }
    } while (!paramContext.equals(r.a(paramString2 + paramString1, "SHA-256")));
    return false;
  }
  
  public static void report(Context paramContext, String paramString)
  {
    new ReportAaidToken.1(paramContext, paramString).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.task.ReportAaidToken
 * JD-Core Version:    0.7.0.1
 */