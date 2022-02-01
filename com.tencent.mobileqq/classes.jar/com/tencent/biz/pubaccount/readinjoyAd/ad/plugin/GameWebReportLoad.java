package com.tencent.biz.pubaccount.readinjoyAd.ad.plugin;

import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.gdtad.web.GdtWebReportInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class GameWebReportLoad
  implements GdtWebReportInterface
{
  public void a() {}
  
  public void a(CustomWebView paramCustomWebView) {}
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameWebReportLoad", 2, "handleEvent type=" + paramLong);
      }
      paramString = new Bundle();
      TroopMemberApiClient.a().a(140, paramString);
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.plugin.GameWebReportLoad
 * JD-Core Version:    0.7.0.1
 */