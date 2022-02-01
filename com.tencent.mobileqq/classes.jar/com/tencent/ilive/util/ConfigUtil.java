package com.tencent.ilive.util;

import com.tencent.ilive.LiveConfig;
import com.tencent.livesdk.liveengine.LiveEngineConfig;

public class ConfigUtil
{
  public static LiveEngineConfig getEnginConfig(LiveConfig paramLiveConfig)
  {
    LiveEngineConfig localLiveEngineConfig = new LiveEngineConfig();
    localLiveEngineConfig.appid = paramLiveConfig.appid;
    localLiveEngineConfig.wns_appid = paramLiveConfig.wns_appid;
    localLiveEngineConfig.opensdk_appid = paramLiveConfig.opensdk_appid;
    localLiveEngineConfig.tpplayer_platform = paramLiveConfig.tpplayer_platform;
    localLiveEngineConfig.isNeedInitTPPlatform = paramLiveConfig.initTpplatform;
    localLiveEngineConfig.channelID = paramLiveConfig.channelID;
    localLiveEngineConfig.clientType = paramLiveConfig.clientType;
    localLiveEngineConfig.isDebug = paramLiveConfig.isDebug;
    localLiveEngineConfig.isRelease = paramLiveConfig.isRelease;
    localLiveEngineConfig.versionCode = paramLiveConfig.versionCode;
    localLiveEngineConfig.versionName = paramLiveConfig.versionName;
    localLiveEngineConfig.serviceConfig = paramLiveConfig.serviceConfig;
    localLiveEngineConfig.guid = paramLiveConfig.guid;
    localLiveEngineConfig.liteSdk = paramLiveConfig.liteSdk;
    localLiveEngineConfig.tCloudId = paramLiveConfig.tCloudId;
    localLiveEngineConfig.tCloudLice = paramLiveConfig.tCloudLice;
    localLiveEngineConfig.isHoldPlayerLog = paramLiveConfig.isHoldPlayerLog;
    return localLiveEngineConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.util.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */