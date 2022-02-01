package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class ReadInJoyAdPingUrlUtil
{
  private static ExecutorService a;
  
  private static ExecutorService a()
  {
    if (a == null) {
      a = Executors.newFixedThreadPool(3);
    }
    return a;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramJSONObject.toString())) {
      a().execute(new ReadInJoyAdPingUrlUtil.URLConnectionPingRunner(paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdPingUrlUtil
 * JD-Core Version:    0.7.0.1
 */