package com.tencent.mobileqq.auto.engine.lib;

import java.util.HashMap;
import java.util.Map;

public class ASEngineConstants$Splash
{
  public static final Map<String, String> sSplashActivity = new HashMap();
  public static final Map<String, String> sSplashService = new HashMap();
  
  static
  {
    sSplashActivity.put("flash-show-app", "com.tencent.mobileqq.flashshow.activity.FSSplashActivity");
    sSplashService.put("flash-show-app", "com.tencent.mobileqq.flashshow.activity.FSSplashService");
    sSplashActivity.put("qcircle-app", "com.tencent.qcircle.activity.QCircleSplashActivity");
    sSplashService.put("qcircle-app", "com.tencent.qcircle.activity.QCirclePreloadService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.ASEngineConstants.Splash
 * JD-Core Version:    0.7.0.1
 */