package com.tencent.liteav.device;

import com.tencent.liteav.audio.TXCAudioEngine;

class TXDeviceManagerImpl$6
  implements Runnable
{
  TXDeviceManagerImpl$6(TXDeviceManagerImpl paramTXDeviceManagerImpl, TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType) {}
  
  public void run()
  {
    this.this$0.apiOnlineLog("setSystemVolumeType type:%s,  auto(0),media(1),VOIP(2)", new Object[] { this.val$type.name() });
    int i = TXDeviceManagerImpl.7.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[this.val$type.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          TXCAudioEngine.setSystemVolumeType(1);
        }
      }
      else {
        TXCAudioEngine.setSystemVolumeType(2);
      }
    }
    else {
      TXCAudioEngine.setSystemVolumeType(0);
    }
    if (TXDeviceManagerImpl.access$000(this.this$0) != null) {
      TXDeviceManagerImpl.access$000(this.this$0).onSwitchSystemVolumeType(this.val$type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */