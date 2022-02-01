package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import org.json.JSONObject;

final class PublicAccountReportUtilsImpl$2
  implements Runnable
{
  PublicAccountReportUtilsImpl$2(String paramString) {}
  
  public void run()
  {
    try
    {
      int j = new JSONObject(this.a).getInt("channel_id");
      int i = 2;
      if (DailyModeConfigHandler.c(j)) {
        i = 0;
      }
      ReadinjoySPEventReport.e(i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */