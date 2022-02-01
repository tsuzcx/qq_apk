package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class ReadInJoyAdReportUtil
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
      a().execute(new ReadInJoyAdReportUtil.ReportJob(paramJSONObject));
    }
  }
  
  private static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyAdPingUrlUtil", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdReportUtil
 * JD-Core Version:    0.7.0.1
 */