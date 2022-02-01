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
    localStringBuilder.append(",appid:");
    localStringBuilder.append(this.appid);
    localStringBuilder.append(",appType:");
    localStringBuilder.append(this.appType);
    localStringBuilder.append(",platform:");
    localStringBuilder.append(this.platform);
    localStringBuilder.append(",appName:");
    localStringBuilder.append(this.appName);
    localStringBuilder.append(",appKey:");
    localStringBuilder.append(this.appKey);
    localStringBuilder.append(",appState:");
    localStringBuilder.append(this.appState);
    localStringBuilder.append(",iphoneUrlScheme:");
    localStringBuilder.append(this.iphoneUrlScheme);
    localStringBuilder.append(",packName:");
    localStringBuilder.append(this.packName);
    localStringBuilder.append(",icon_url:");
    localStringBuilder.append(this.icon_url);
    localStringBuilder.append(",sourceUrl:");
    localStringBuilder.append(this.sourceUrl);
    localStringBuilder.append(",smallUrl:");
    localStringBuilder.append(this.smallUrl);
    localStringBuilder.append(",middleUrl:");
    localStringBuilder.append(this.middleUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletInfo
 * JD-Core Version:    0.7.0.1
 */