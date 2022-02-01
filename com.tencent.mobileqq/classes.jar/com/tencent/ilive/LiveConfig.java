package com.tencent.ilive;

import com.tencent.ilive.config.UIConfig;
import com.tencent.ilivesdk.domain.factory.LiveCaseConfig;
import com.tencent.livesdk.servicefactory.ServiceConfig;

public class LiveConfig
{
  public String appid;
  public String channelID;
  public int clientType;
  public String guid;
  public boolean initTpplatform;
  public boolean isDebug;
  public boolean isHoldPlayerLog;
  public boolean isRelease;
  public boolean liteSdk;
  public LiveCaseConfig liveCaseConfig = new LiveCaseConfig();
  public int opensdk_appid;
  public LiveConfig.SDKType sdkType = LiveConfig.SDKType.FULL;
  public ServiceConfig serviceConfig = new ServiceConfig();
  public String tCloudId;
  public String tCloudLice;
  public int tpplayer_platform;
  public UIConfig uiConfig = new UIConfig();
  public int versionCode;
  public String versionName;
  public int wns_appid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.LiveConfig
 * JD-Core Version:    0.7.0.1
 */