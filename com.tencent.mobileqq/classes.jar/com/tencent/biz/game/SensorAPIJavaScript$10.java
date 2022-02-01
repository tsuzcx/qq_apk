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
    Object localObject = new WifiParsedResult(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Boolean);
    if (new BizWifiConfigManager(this.jdField_a_of_type_AndroidNetWifiWifiManager).a((WifiParsedResult)localObject))
    {
      localObject = new Message();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = this.d;
      this.this$0.a.sendMessage((Message)localObject);
      return;
    }
    this.this$0.c = false;
    this.this$0.callJs(this.d, new String[] { Util.a(Integer.toString(1)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.10
 * JD-Core Version:    0.7.0.1
 */