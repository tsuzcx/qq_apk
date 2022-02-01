package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  public static void a(Context paramContext, String paramString)
  {
    new m(paramContext, paramString).start();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      HMSLog.e("ReportAaidToken", "Https response is empty.");
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      int i = paramString1.optInt("ret", 256);
      if (i == 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString3);
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
        paramString1 = r.a(paramString1, "SHA-256");
        paramContext = i.a(paramContext);
        boolean bool = paramContext.saveString("reportAaidAndToken", paramString1);
        paramString1 = new StringBuilder();
        paramString1.append("Report success ");
        if (bool) {
          paramContext = "and save success.";
        } else {
          paramContext = "but save failure.";
        }
        paramString1.append(paramContext);
        HMSLog.d("ReportAaidToken", paramString1.toString());
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("Https response body's ret code: ");
      paramContext.append(i);
      paramContext.append(", error message: ");
      paramContext.append(paramString1.optString("msg"));
      HMSLog.e("ReportAaidToken", paramContext.toString());
      return;
    }
    catch (JSONException paramContext)
    {
      break label189;
    }
    catch (Exception paramContext)
    {
      label181:
      break label181;
    }
    HMSLog.e("ReportAaidToken", "Exception occur.");
    return;
    label189:
    HMSLog.e("ReportAaidToken", "Has JSONException.");
  }
  
  public static boolean b(Context paramContext)
  {
    int i = new PackageManagerHelper(paramContext).getPackageVersionCode("com.huawei.android.pushagent");
    paramContext = new StringBuilder();
    paramContext.append("NC version code: ");
    paramContext.append(i);
    HMSLog.d("ReportAaidToken", paramContext.toString());
    return ((90101400 <= i) && (i < 100000000)) || (i >= 100001301);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("timezone", TimeZone.getDefault().getID());
      localJSONObject2.put("country", SystemUtils.getLocalCountry());
      JSONObject localJSONObject3 = new JSONObject();
      Object localObject = new PackageManagerHelper(paramContext);
      localObject = ((PackageManagerHelper)localObject).getPackageVersionName("com.huawei.android.pushagent");
      localJSONObject3.put("agent_version", localObject);
      localJSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(paramContext)));
      localObject = new JSONObject();
      ((JSONObject)localObject).put("dev_type", n.a.a.a());
      ((JSONObject)localObject).put("dev_sub_type", "phone");
      ((JSONObject)localObject).put("os_type", n.b.b.a());
      ((JSONObject)localObject).put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
      localJSONObject1.put("id", UUID.randomUUID().toString());
      localJSONObject1.put("global", localJSONObject2);
      localJSONObject1.put("push_agent", localJSONObject3);
      localJSONObject1.put("hardware", localObject);
      localJSONObject1.put("aaid", paramString1);
      localJSONObject1.put("token", paramString2);
      paramString1 = AGConnectServicesConfig.fromContext(paramContext);
      localJSONObject1.put("app_id", paramString1.getString("client/app_id"));
      localJSONObject1.put("region", AGConnectServicesConfig.fromContext(paramContext).getString("region"));
      return localJSONObject1.toString();
    }
    catch (JSONException paramContext)
    {
      label251:
      break label251;
    }
    HMSLog.e("ReportAaidToken", "Catch JSONException.");
    return null;
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = i.a(paramContext);
    if (!paramContext.containsKey("reportAaidAndToken"))
    {
      HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
      return true;
    }
    paramContext = paramContext.getString("reportAaidAndToken");
    if (TextUtils.isEmpty(paramContext))
    {
      HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    return paramContext.equals(r.a(localStringBuilder.toString(), "SHA-256")) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.n
 * JD-Core Version:    0.7.0.1
 */