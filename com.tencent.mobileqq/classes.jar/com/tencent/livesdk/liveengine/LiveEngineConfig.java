package com.tencent.livesdk.liveengine;

import com.tencent.livesdk.servicefactory.ServiceConfig;

public class LiveEngineConfig
{
  public String appid;
  public String channelID;
  public int clientType;
  public String guid;
  public boolean isDebug;
  public boolean isHoldPlayerLog;
  public boolean isNeedInitTPPlatform;
  public boolean isRelease;
  public boolean isSvrTestEnv;
  public boolean liteSdk;
  public int opensdk_appid;
  public ServiceConfig serviceConfig = new ServiceConfig();
  public String tCloudId;
  public String tCloudLice;
  public int tpplayer_platform;
  public int versionCode;
  public String versionName;
  public int wns_appid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveEngineConfig{appid='");
    localStringBuilder.append(this.appid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", versionName='");
    localStringBuilder.append(this.versionName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", clientType=");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append(", channelID='");
    localStringBuilder.append(this.channelID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isDebug=");
    localStringBuilder.append(this.isDebug);
    localStringBuilder.append(", isRelease=");
    localStringBuilder.append(this.isRelease);
    localStringBuilder.append(", isSvrTestEnv=");
    localStringBuilder.append(this.isSvrTestEnv);
    localStringBuilder.append(", guid='");
    localStringBuilder.append(this.guid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", liteSdk=");
    localStringBuilder.append(this.liteSdk);
    localStringBuilder.append(", serviceConfig=");
    localStringBuilder.append(this.serviceConfig);
    localStringBuilder.append(", isHoldPlayerLog=");
    localStringBuilder.append(this.isHoldPlayerLog);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.LiveEngineConfig
 * JD-Core Version:    0.7.0.1
 */