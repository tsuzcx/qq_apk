package com.tencent.live2.a;

import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;
import com.tencent.rtmp.TXLivePushConfig;

class b$2
  implements TXDeviceManagerImpl.TXDeviceManagerListener
{
  b$2(b paramb) {}
  
  public void onSwitchAutoFocus(boolean paramBoolean)
  {
    b.a(this.a).setTouchFocus(paramBoolean ^ true);
  }
  
  public void onSwitchCamera(boolean paramBoolean)
  {
    b.a(this.a).setFrontCamera(paramBoolean);
  }
  
  public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType)
  {
    b localb = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateConfig: volumeType-");
    localStringBuilder.append(paramTXSystemVolumeType);
    b.a(localb, localStringBuilder.toString());
    int k = b.4.a[paramTXSystemVolumeType.ordinal()];
    int j = 0;
    int i = j;
    if (k != 1) {
      if (k != 2)
      {
        if (k != 3) {
          i = j;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    b.a(this.a).setVolumeType(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.b.2
 * JD-Core Version:    0.7.0.1
 */