package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.APIConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class D$manifest$common_apis
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
          localHashMap.put("getLocation", new APIConfig("getLocation", 7, 1, (Class)D.a.get("getLocation")));
          localHashMap.put("getCity", new APIConfig("getCity", 6, 1, (Class)D.a.get("getCity")));
          localHashMap.put("login", new APIConfig("login", 17, 0, (Class)D.a.get("login")));
          localHashMap.put("loginSilent", new APIConfig("loginSilent", 18, 0, (Class)D.a.get("loginSilent")));
          localHashMap.put("getUserInfo", new APIConfig("getUserInfo", 10, 2, (Class)D.a.get("getUserInfo")));
          localHashMap.put("getAppFriends", new APIConfig("getAppFriends", 5, 2, (Class)D.a.get("getAppFriends")));
          localHashMap.put("getRankingList", new APIConfig("getRankingList", 8, 2, (Class)D.a.get("getRankingList")));
          localHashMap.put("reportScore", new APIConfig("reportScore", 24, 2, (Class)D.a.get("reportScore")));
          localHashMap.put("showShareMenu", new APIConfig("showShareMenu", 30, 0, (Class)D.a.get("showShareMenu")));
          localHashMap.put("shareMessage", new APIConfig("shareMessage", 27, 0, (Class)D.a.get("shareMessage")));
          localHashMap.put("showActionSheet", new APIConfig("showActionSheet", 28, 0, (Class)D.a.get("showActionSheet")));
          localHashMap.put("showDialog", new APIConfig("showDialog", 29, 0, (Class)D.a.get("showDialog")));
          localHashMap.put("getSkey", new APIConfig("getSkey", 9, 0, (Class)D.a.get("getSkey")));
          localHashMap.put("openWebView", new APIConfig("openWebView", 21, 0, (Class)D.a.get("openWebView")));
          localHashMap.put("openPlatoView", new APIConfig("openPlatoView", 20, 0, (Class)D.a.get("openPlatoView")));
          localHashMap.put("openNativeView", new APIConfig("openNativeView", 19, 0, (Class)D.a.get("openNativeView")));
          localHashMap.put("addEventListener", new APIConfig("addEventListener", 1, 0, (Class)D.a.get("addEventListener")));
          localHashMap.put("removeEventListener", new APIConfig("removeEventListener", 23, 0, (Class)D.a.get("removeEventListener")));
          localHashMap.put("dispatchEvent", new APIConfig("dispatchEvent", 4, 0, (Class)D.a.get("dispatchEvent")));
          localHashMap.put("sdk_dynamic_avatar_edit", new APIConfig("sdk_dynamic_avatar_edit", 31, 0, (Class)D.a.get("sdk_dynamic_avatar_edit")));
          localHashMap.put("sdk_face_collection", new APIConfig("sdk_face_collection", 32, 0, (Class)D.a.get("sdk_face_collection")));
          localHashMap.put("sdk_avatar_edit", new APIConfig("sdk_avatar_edit", 33, 0, (Class)D.a.get("sdk_avatar_edit")));
          a = Collections.unmodifiableMap(localHashMap);
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis
 * JD-Core Version:    0.7.0.1
 */