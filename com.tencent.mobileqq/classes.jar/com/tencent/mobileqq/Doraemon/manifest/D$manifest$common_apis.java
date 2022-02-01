package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.EventAPIModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.InternalAPIModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.NavigateModule;
import com.tencent.mobileqq.Doraemon.impl.internalModule.SdkApiModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class D$manifest$common_apis
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
        localHashMap.put("getLocation", new APIConfig("getLocation", 7, 1, SensorModule.class));
        localHashMap.put("getCity", new APIConfig("getCity", 6, 1, SensorModule.class));
        localHashMap.put("login", new APIConfig("login", 17, 0, UserInfoModule.class));
        localHashMap.put("loginSilent", new APIConfig("loginSilent", 18, 0, UserInfoModule.class));
        localHashMap.put("getUserInfo", new APIConfig("getUserInfo", 10, 2, UserInfoModule.class));
        localHashMap.put("getAppFriends", new APIConfig("getAppFriends", 5, 2, UserInfoModule.class));
        localHashMap.put("getRankingList", new APIConfig("getRankingList", 8, 2, RankingModule.class));
        localHashMap.put("reportScore", new APIConfig("reportScore", 24, 2, RankingModule.class));
        localHashMap.put("showShareMenu", new APIConfig("showShareMenu", 30, 0, ShareModule.class));
        localHashMap.put("shareMessage", new APIConfig("shareMessage", 27, 0, ShareModule.class));
        localHashMap.put("showActionSheet", new APIConfig("showActionSheet", 28, 0, WidgetModule.class));
        localHashMap.put("showDialog", new APIConfig("showDialog", 29, 0, WidgetModule.class));
        localHashMap.put("getSkey", new APIConfig("getSkey", 9, 0, InternalAPIModule.class));
        localHashMap.put("openWebView", new APIConfig("openWebView", 21, 0, NavigateModule.class));
        localHashMap.put("openPlatoView", new APIConfig("openPlatoView", 20, 0, NavigateModule.class));
        localHashMap.put("openNativeView", new APIConfig("openNativeView", 19, 0, NavigateModule.class));
        localHashMap.put("addEventListener", new APIConfig("addEventListener", 1, 0, EventAPIModule.class));
        localHashMap.put("removeEventListener", new APIConfig("removeEventListener", 23, 0, EventAPIModule.class));
        localHashMap.put("dispatchEvent", new APIConfig("dispatchEvent", 4, 0, EventAPIModule.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new APIConfig("sdk_dynamic_avatar_edit", 31, 0, SdkApiModule.class));
        localHashMap.put("sdk_face_collection", new APIConfig("sdk_face_collection", 32, 0, SdkApiModule.class));
        localHashMap.put("sdk_avatar_edit", new APIConfig("sdk_avatar_edit", 33, 0, SdkApiModule.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis
 * JD-Core Version:    0.7.0.1
 */