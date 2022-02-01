package com.tencent.falco.base.libapi.qqsdk;

import android.os.Bundle;

public class QQDefaultShare
  extends QQBaseShareData
{
  public String appName;
  public String imageUrl;
  public String jumpUrl;
  public String summary;
  public String title;
  
  public Bundle getBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("req_type", 1);
    localBundle.putString("title", this.title);
    localBundle.putString("summary", this.summary);
    localBundle.putString("targetUrl", this.jumpUrl);
    localBundle.putString("imageUrl", this.imageUrl);
    localBundle.putString("appName", this.appName);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQDefaultShare
 * JD-Core Version:    0.7.0.1
 */