package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.WVAuthModule;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.WVUIModule;
import com.tencent.mobileqq.ark.browser.ArkWebModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class D$manifest$webview_apis
{
  private static Map<String, APIConfig> a;
  
  public static Map<String, APIConfig> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(D.manifest.common_apis.a());
        localHashMap.put("config", new APIConfig("config", 3, 0, WVAuthModule.class));
        localHashMap.put("setShareInfo", new APIConfig("setShareInfo", 25, 0, WVUIModule.class));
        localHashMap.put("closeWebview", new APIConfig("closeWebview", 2, 0, WVUIModule.class));
        localHashMap.put("refreshTitle", new APIConfig("refreshTitle", 22, 0, WVUIModule.class));
        localHashMap.put("setShareListener", new APIConfig("setShareListener", 26, 0, WVUIModule.class));
        localHashMap.put("lightappGetSDKVersion", new APIConfig("lightappGetSDKVersion", 13, 0, ArkWebModule.class));
        localHashMap.put("lightappShareCallback", new APIConfig("lightappShareCallback", 15, 0, ArkWebModule.class));
        localHashMap.put("lightappShareMessage", new APIConfig("lightappShareMessage", 16, 0, ArkWebModule.class));
        localHashMap.put("lightappOpenApp", new APIConfig("lightappOpenApp", 14, 0, ArkWebModule.class));
        localHashMap.put("lightappDisableLongPress", new APIConfig("lightappDisableLongPress", 11, 0, ArkWebModule.class));
        localHashMap.put("lightappDisableWebViewLongPress", new APIConfig("lightappDisableWebViewLongPress", 12, 0, ArkWebModule.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D.manifest.webview_apis
 * JD-Core Version:    0.7.0.1
 */