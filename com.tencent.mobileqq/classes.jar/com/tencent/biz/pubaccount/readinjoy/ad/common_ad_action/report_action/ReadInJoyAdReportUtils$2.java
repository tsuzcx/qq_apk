package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_action.report_action;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import nlw;

public final class ReadInJoyAdReportUtils$2
  implements Runnable
{
  public ReadInJoyAdReportUtils$2(String paramString) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    nlw.a(localBundle);
    if (!TextUtils.isEmpty(this.a)) {}
    try
    {
      nlw.a(BaseApplicationImpl.getContext(), this.a, "GET", null, localBundle);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.2
 * JD-Core Version:    0.7.0.1
 */