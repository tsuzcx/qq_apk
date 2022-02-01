package com.tencent.falco.base.libapi.qqsdk;

import android.os.Bundle;

public class QQLocalImageShare
  extends QQBaseShareData
{
  public String appName;
  public String imageUrl;
  
  public Bundle getBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("imageLocalUrl", this.imageUrl);
    localBundle.putString("appName", this.appName);
    localBundle.putInt("req_type", 5);
    localBundle.putInt("cflag", this.extra);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQLocalImageShare
 * JD-Core Version:    0.7.0.1
 */