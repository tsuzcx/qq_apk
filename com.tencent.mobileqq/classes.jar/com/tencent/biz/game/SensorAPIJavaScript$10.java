package com.tencent.biz.game;

import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.google.zxing.client.android.wifi.WifiParsedResult;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;

class SensorAPIJavaScript$10
  extends Thread
{
  SensorAPIJavaScript$10(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString1, String paramString2, String paramString3, boolean paramBoolean, WifiManager paramWifiManager, String paramString4) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SensorApi", 4, "start connectToWiFi");
    }
    Object localObject = new WifiParsedResult(this.a, this.b, this.c, this.d);
    if (new BizWifiConfigManager(this.e).a((WifiParsedResult)localObject))
    {
      localObject = new Message();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = this.f;
      this.this$0.F.sendMessage((Message)localObject);
      return;
    }
    localObject = this.this$0;
    ((SensorAPIJavaScript)localObject).t = false;
    ((SensorAPIJavaScript)localObject).callJs(this.f, new String[] { Util.c(Integer.toString(1)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.10
 * JD-Core Version:    0.7.0.1
 */