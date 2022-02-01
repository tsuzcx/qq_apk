package com.tencent.falco.base.libapi.qqsdk;

import android.os.Bundle;

public class QQAppShare
  extends QQBaseShareData
{
  public String appName;
  public String audioUrl;
  public String imageUrl;
  public String summary;
  public String title;
  
  public Bundle getBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("req_type", 6);
    localBundle.putString("title", this.title);
    localBundle.putString("summary", this.summary);
    localBundle.putString("imageUrl", this.imageUrl);
    localBundle.putString("audio_url", this.audioUrl);
    localBundle.putString("appName", this.appName);
    localBundle.putInt("cflag", this.extra);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQAppShare
 * JD-Core Version:    0.7.0.1
 */