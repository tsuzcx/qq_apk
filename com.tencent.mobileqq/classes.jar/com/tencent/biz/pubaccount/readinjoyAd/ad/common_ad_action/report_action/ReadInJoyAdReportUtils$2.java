package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;

final class ReadInJoyAdReportUtils$2
  implements Runnable
{
  ReadInJoyAdReportUtils$2(String paramString) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    HttpUtil.addCookie(localBundle);
    if (!TextUtils.isEmpty(this.a)) {
      try
      {
        HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), this.a, "GET", null, localBundle);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.2
 * JD-Core Version:    0.7.0.1
 */