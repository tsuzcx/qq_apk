package com.tencent.biz.pubaccount.readinjoyAd.ad.plugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class RIJAdWebViewPlugin
  extends WebViewPlugin
{
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleEvent type=");
        paramString.append(paramLong);
        QLog.d("RIJAdWebViewPlugin", 2, paramString.toString());
      }
      paramString = new Bundle();
      TroopMemberApiClient.a().a(140, paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.plugin.RIJAdWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */