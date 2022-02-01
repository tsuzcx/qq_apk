package com.tencent.liteav.device;

import com.tencent.liteav.audio.TXCAudioEngine;

class TXDeviceManagerImpl$5
  implements Runnable
{
  TXDeviceManagerImpl$5(TXDeviceManagerImpl paramTXDeviceManagerImpl, TXDeviceManager.TXAudioRoute paramTXAudioRoute) {}
  
  public void run()
  {
    TXDeviceManagerImpl localTXDeviceManagerImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioRoute route:");
    String str;
    if (this.val$route == TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece) {
      str = "earpiece";
    } else {
      str = "speakerphone";
    }
    localStringBuilder.append(str);
    localTXDeviceManagerImpl.apiOnlineLog(localStringBuilder.toString(), new Object[0]);
    int i = TXDeviceManagerImpl.7.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute[this.val$route.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      TXCAudioEngine.setAudioRoute(1);
      return;
    }
    TXCAudioEngine.setAudioRoute(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */