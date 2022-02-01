package com.tencent.av.business.manager.zimu;

import lgr;

public class ZimuLiveItem
  extends lgr
{
  private String desc;
  private String iconurl;
  private String id;
  private String md5;
  private int platform;
  private String resurl;
  private String text;
  private boolean usable;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getIconurl()
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
  
  public String getResurl()
  {
    return this.resurl;
  }
  
  public String getText()
  {
    return this.text;
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
    return "id[" + this.id + "], usable[" + this.usable + "], isDownloading[" + this.isDownloading + "], iconurl[" + this.iconurl + "], resurl[" + this.resurl + "], md5[" + this.md5 + "], platform[" + this.platform + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ZimuLiveItem
 * JD-Core Version:    0.7.0.1
 */