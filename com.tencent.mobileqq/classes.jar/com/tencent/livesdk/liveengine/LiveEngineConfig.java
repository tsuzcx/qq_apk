package com.tencent.livesdk.liveengine;

import com.tencent.livesdk.servicefactory.ServiceConfig;

public class LiveEngineConfig
{
  public String appid;
  public String channelID;
  public int clientType;
  public String guid;
  public boolean isDebug;
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
    return "LiveEngineConfig{appid='" + this.appid + '\'' + ", versionName='" + this.versionName + '\'' + ", versionCode=" + this.versionCode + ", clientType=" + this.clientType + ", channelID='" + this.channelID + '\'' + ", isDebug=" + this.isDebug + ", isRelease=" + this.isRelease + ", isSvrTestEnv=" + this.isSvrTestEnv + ", guid='" + this.guid + '\'' + ", liteSdk=" + this.liteSdk + ", serviceConfig=" + this.serviceConfig + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.LiveEngineConfig
 * JD-Core Version:    0.7.0.1
 */