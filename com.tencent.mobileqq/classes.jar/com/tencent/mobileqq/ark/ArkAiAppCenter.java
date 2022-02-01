package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.ark.config.ApiFrequencyConfig;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.ark.config.config.DialogConfig;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class ArkAiAppCenter
{
  public static boolean a = false;
  public static boolean b = false;
  public static String c;
  public static Map<String, List<ApiFrequencyConfig>> d = new HashMap();
  private static final List<String> e = new ArrayList();
  
  public ArkAiAppCenter()
  {
    Object localObject = (IArkDictManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkDictManager.class, "");
    ((IArkDictManager)localObject).initWordData();
    ((IArkDictManager)localObject).updateLocalDict();
    localObject = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
    if ((localObject != null) && (((ArkAIKeyWordConfBean)localObject).c() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkAiAppCenter updateDialogConfig content =");
      localStringBuilder.append(((ArkAIKeyWordConfBean)localObject).d());
      QLog.i("ArkApp.AI", 1, localStringBuilder.toString());
      a(((ArkAIKeyWordConfBean)localObject).c());
    }
  }
  
  public static void a(DialogConfig paramDialogConfig)
  {
    if (paramDialogConfig == null)
    {
      QLog.i("ArkApp.AI", 1, String.format("updateDialogConfig,dialogConfig is null", new Object[0]));
      return;
    }
    if (((INativeLibLoader)QRoute.api(INativeLibLoader.class)).isArkLibraryLoaded())
    {
      ark.SetUseAndroidHTTP(paramDialogConfig.b);
      ark.arkSetAndroid9EmojiFeatureSupport(paramDialogConfig.c);
    }
    a = paramDialogConfig.d;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject;
    if (a) {
      localObject = "true";
    } else {
      localObject = "false";
    }
    SharePreferenceUtils.a(localBaseApplication, "ark_engine_multi_thread", (String)localObject);
    c = paramDialogConfig.e;
    if (((INativeLibLoader)QRoute.api(INativeLibLoader.class)).isArkLibraryLoaded())
    {
      ArkEnvironmentManager.getInstance().setSingleThreadMode(a ^ true);
      ArkEnvironmentManager.getInstance().setThreadMode();
      try
      {
        localObject = new JSONObject(c);
        ArkEnvironmentManager.getInstance().setHardwareDisableList((JSONObject)localObject);
      }
      catch (JSONException localJSONException)
      {
        QLog.i("ArkApp.AI", 1, String.format("updateDialogConfig, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
      }
    }
    b = paramDialogConfig.f;
  }
  
  public static boolean a(String paramString)
  {
    return e.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppCenter
 * JD-Core Version:    0.7.0.1
 */