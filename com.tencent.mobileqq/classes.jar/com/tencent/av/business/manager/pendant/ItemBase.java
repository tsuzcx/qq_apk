package com.tencent.av.business.manager.pendant;

public abstract class ItemBase
{
  public int cid = -1;
  public boolean isDownloading = false;
  
  public abstract String getDesc();
  
  public abstract String getIconUrl();
  
  public abstract String getId();
  
  public abstract String getMd5();
  
  public abstract int getPlatform();
  
  public abstract String getResUrl();
  
  public abstract String getVersion();
  
  public abstract boolean isUsable();
  
  public abstract void setUsable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.ItemBase
 * JD-Core Version:    0.7.0.1
 */