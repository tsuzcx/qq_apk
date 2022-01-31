package com.tencent.ark.open;

import android.text.TextUtils;

public class ArkAppCGIMgr$AIWordDictInfo
{
  public String URL;
  public String identifier;
  public long lastModifiedTime;
  public String md5;
  public String name;
  public int type;
  
  public boolean isValid()
  {
    return (this.type >= 0) && (!TextUtils.isEmpty(this.name)) && (!TextUtils.isEmpty(this.URL)) && (!TextUtils.isEmpty(this.identifier));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.AIWordDictInfo
 * JD-Core Version:    0.7.0.1
 */