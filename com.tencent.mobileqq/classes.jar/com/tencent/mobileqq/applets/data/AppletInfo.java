package com.tencent.mobileqq.applets.data;

import java.io.Serializable;

public class AppletInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public String appKey;
  public String appName;
  public int appState;
  public int appType;
  public int appid;
  public String icon_url;
  public String iphoneUrlScheme;
  public String middleUrl;
  public String packName;
  public int platform;
  public String smallUrl;
  public String sourceUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--AppletsAccountInfo--");
    localStringBuilder.append(",appid:").append(this.appid).append(",appType:").append(this.appType).append(",platform:").append(this.platform).append(",appName:").append(this.appName).append(",appKey:").append(this.appKey).append(",appState:").append(this.appState).append(",iphoneUrlScheme:").append(this.iphoneUrlScheme).append(",packName:").append(this.packName).append(",icon_url:").append(this.icon_url).append(",sourceUrl:").append(this.sourceUrl).append(",smallUrl:").append(this.smallUrl).append(",middleUrl:").append(this.middleUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletInfo
 * JD-Core Version:    0.7.0.1
 */