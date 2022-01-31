package com.tencent.mobileqq.Doraemon.manifest;

import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class D$manifest$common_apis
{
  private static Map a;
  
  public static Map a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("getLocation", new APIConfig("getLocation", 3, 1, SensorModule.class));
        localHashMap.put("getCity", new APIConfig("getCity", 2, 1, SensorModule.class));
        localHashMap.put("login", new APIConfig("login", 5, 0, UserInfoModule.class));
        localHashMap.put("getUserInfo", new APIConfig("getUserInfo", 4, 2, UserInfoModule.class));
        localHashMap.put("getAppFriends", new APIConfig("getAppFriends", 1, 2, UserInfoModule.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.manifest.D.manifest.common_apis
 * JD-Core Version:    0.7.0.1
 */