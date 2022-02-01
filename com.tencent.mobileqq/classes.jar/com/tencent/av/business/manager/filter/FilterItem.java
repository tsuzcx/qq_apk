package com.tencent.av.business.manager.filter;

import com.tencent.av.business.manager.pendant.ItemBase;

public class FilterItem
  extends ItemBase
{
  private String desc;
  private String displayName;
  private String filterid;
  private int filtertype;
  private String iconmd5;
  private String iconurl;
  private String md5;
  private String name = "";
  private String newIcon;
  private int predownload;
  private String resurl;
  private boolean usable;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
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
  
  public String getIconUrl()
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
  
  public String getNewIcon()
  {
    return this.newIcon;
  }
  
  public int getPlatform()
  {
    return 660;
  }
  
  public int getPredownload()
  {
    return this.predownload;
  }
  
  public String getResUrl()
  {
    return this.resurl;
  }
  
  public String getVersion()
  {
    return "";
  }
  
  public boolean isEmptyFilter()
  {
    try
    {
      int i = Integer.valueOf(getFilterId()).intValue();
      if ((i == -1) || (i == 0)) {
        return true;
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filterid[");
    localStringBuilder.append(this.filterid);
    localStringBuilder.append("], desc[");
    localStringBuilder.append(this.desc);
    localStringBuilder.append("], name[");
    localStringBuilder.append(this.name);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(this.isDownloading);
    localStringBuilder.append("], filtertype[");
    localStringBuilder.append(this.filtertype);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.FilterItem
 * JD-Core Version:    0.7.0.1
 */