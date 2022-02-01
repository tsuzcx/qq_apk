package com.tencent.av.business.manager.zimu;

import com.tencent.av.business.manager.pendant.ItemBase;

public class ZimuItem
  extends ItemBase
{
  private String desc;
  private String iconurl;
  private String id;
  private String md5;
  private int platform;
  private String resurl;
  private boolean usable;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getIconUrl()
  {
    return this.iconurl;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public String getResUrl()
  {
    return this.resurl;
  }
  
  public String getVersion()
  {
    return "";
  }
  
  public boolean isUsable()
  {
    return this.usable;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.usable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.id);
    localStringBuilder.append("], iconurl[");
    localStringBuilder.append(this.iconurl);
    localStringBuilder.append("], usable[");
    localStringBuilder.append(this.usable);
    localStringBuilder.append("], resurl[");
    localStringBuilder.append(this.resurl);
    localStringBuilder.append("], md5[");
    localStringBuilder.append(this.md5);
    localStringBuilder.append("], platform[");
    localStringBuilder.append(this.platform);
    localStringBuilder.append("], desc[");
    localStringBuilder.append(this.desc);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(this.isDownloading);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ZimuItem
 * JD-Core Version:    0.7.0.1
 */