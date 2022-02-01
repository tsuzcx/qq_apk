package com.tencent.av.business.manager.zimu;

import lgx;

public class ZimuItem
  extends lgx
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
    return "id[" + this.id + "], iconurl[" + this.iconurl + "], usable[" + this.usable + "], resurl[" + this.resurl + "], md5[" + this.md5 + "], platform[" + this.platform + "], desc[" + this.desc + "], isDownloading[" + this.isDownloading + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ZimuItem
 * JD-Core Version:    0.7.0.1
 */