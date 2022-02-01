package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;

class TRTCCloudImpl$3
  implements TXDeviceManagerImpl.TXDeviceManagerListener
{
  TRTCCloudImpl$3(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void onSwitchAutoFocus(boolean paramBoolean)
  {
    this.this$0.mConfig.L = (paramBoolean ^ true);
  }
  
  public void onSwitchCamera(boolean paramBoolean)
  {
    this.this$0.mConfig.n = paramBoolean;
    TRTCCloudImpl.access$100(this.this$0);
  }
  
  public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType)
  {
    int i = TRTCCloudImpl.199.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[paramTXSystemVolumeType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.this$0.mConfig.y = 1;
        return;
      }
      this.this$0.mConfig.y = 2;
      return;
    }
    this.this$0.mConfig.y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.3
 * JD-Core Version:    0.7.0.1
 */