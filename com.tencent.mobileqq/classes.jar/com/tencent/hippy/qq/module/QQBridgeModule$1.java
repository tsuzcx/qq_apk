package com.tencent.hippy.qq.module;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

class QQBridgeModule$1
  implements INetInfoHandler
{
  QQBridgeModule$1(QQBridgeModule paramQQBridgeModule, Promise paramPromise) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.this$0.getNetType(this.val$promise, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$promise, false);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$promise, false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$promise, false);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + paramString);
    }
    this.this$0.getNetType(this.val$promise, false);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.this$0.getNetType(this.val$promise, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBridgeModule.1
 * JD-Core Version:    0.7.0.1
 */