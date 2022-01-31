package com.tencent.av.business.manager.filter;

import lhq;

public class FilterItem
  extends lhq
{
  private String desc;
  private String filterid;
  private int filtertype;
  private String iconmd5;
  private String iconurl;
  private String md5;
  private String name = "";
  private int predownload;
  private String resurl;
  private boolean usable;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getFilterId()
  {
    return this.filterid;
  }
  
  public int getFiltertype()
  {
    return this.filtertype;
  }
  
  public String getIconMd5()
  {
    return this.iconmd5;
  }
  
  public String getIconurl()
  {
    return this.iconurl;
  }
  
  public String getId()
  {
    return this.name;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public int getPlatform()
  {
    return 660;
  }
  
  public int getPredownload()
  {
    return this.predownload;
  }
  
  public String getResurl()
  {
    return this.resurl;
  }
  
  public boolean isEmptyFilter()
  {
    boolean bool = false;
    try
    {
      int i = Integer.valueOf(getFilterId()).intValue();
      if ((i == -1) || (i == 0)) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
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
    return "filterid[" + this.filterid + "], desc[" + this.desc + "], name[" + this.name + "], isDownloading[" + this.isDownloading + "], filtertype[" + this.filtertype + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.FilterItem
 * JD-Core Version:    0.7.0.1
 */