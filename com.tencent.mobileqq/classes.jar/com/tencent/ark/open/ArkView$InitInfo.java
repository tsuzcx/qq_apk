package com.tencent.ark.open;

import android.text.TextUtils;

public class ArkView$InitInfo
{
  public String appID;
  public String appPath;
  public String config = "";
  public String meta = "";
  public String minVersion = "0.0.0.1";
  public String resPath;
  public String view;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.appID)) && (!TextUtils.isEmpty(this.view));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkView.InitInfo
 * JD-Core Version:    0.7.0.1
 */