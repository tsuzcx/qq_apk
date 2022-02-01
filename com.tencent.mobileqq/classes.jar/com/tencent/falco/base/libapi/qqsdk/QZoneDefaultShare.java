package com.tencent.falco.base.libapi.qqsdk;

import android.os.Bundle;
import java.util.ArrayList;

public class QZoneDefaultShare
  extends QZoneBaseShareData
{
  public String appName;
  public final ArrayList<String> imageUrls = new ArrayList();
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
    localBundle.putStringArrayList("imageUrl", this.imageUrls);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QZoneDefaultShare
 * JD-Core Version:    0.7.0.1
 */