package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.APIConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class D$manifest$webview_apis
{
  private static Map<String, APIConfig> a;
  
  public static Map<String, APIConfig> a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.putAll(D.manifest.common_apis.a());
          localHashMap.put("config", new APIConfig("config", 3, 0, (Class)D.a.get("config")));
          localHashMap.put("setShareInfo", new APIConfig("setShareInfo", 25, 0, (Class)D.a.get("setShareInfo")));
          localHashMap.put("closeWebview", new APIConfig("closeWebview", 2, 0, (Class)D.a.get("closeWebview")));
          localHashMap.put("refreshTitle", new APIConfig("refreshTitle", 22, 0, (Class)D.a.get("refreshTitle")));
          localHashMap.put("setShareListener", new APIConfig("setShareListener", 26, 0, (Class)D.a.get("setShareListener")));
          localHashMap.put("lightappGetSDKVersion", new APIConfig("lightappGetSDKVersion", 13, 0, (Class)D.a.get("lightappGetSDKVersion")));
          localHashMap.put("lightappShareCallback", new APIConfig("lightappShareCallback", 15, 0, (Class)D.a.get("lightappShareCallback")));
          localHashMap.put("lightappShareMessage", new APIConfig("lightappShareMessage", 16, 0, (Class)D.a.get("lightappShareMessage")));
          localHashMap.put("lightappOpenApp", new APIConfig("lightappOpenApp", 14, 0, (Class)D.a.get("lightappOpenApp")));
          localHashMap.put("lightappDisableLongPress", new APIConfig("lightappDisableLongPress", 11, 0, (Class)D.a.get("lightappDisableLongPress")));
          localHashMap.put("lightappDisableWebViewLongPress", new APIConfig("lightappDisableWebViewLongPress", 12, 0, (Class)D.a.get("lightappDisableWebViewLongPress")));
          a = Collections.unmodifiableMap(localHashMap);
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D.manifest.webview_apis
 * JD-Core Version:    0.7.0.1
 */