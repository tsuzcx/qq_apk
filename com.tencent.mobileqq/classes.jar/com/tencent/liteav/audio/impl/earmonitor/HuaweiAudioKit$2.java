package com.tencent.liteav.audio.impl.earmonitor;

import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.tencent.liteav.basic.log.TXCLog;

class HuaweiAudioKit$2
  implements Runnable
{
  HuaweiAudioKit$2(HuaweiAudioKit paramHuaweiAudioKit) {}
  
  public void run()
  {
    TXCLog.i("HuaweiAudioKit", "uninitialize");
    if (HuaweiAudioKit.access$300(this.a) != null)
    {
      HuaweiAudioKit.access$300(this.a).destroy();
      HuaweiAudioKit.access$302(this.a, null);
    }
    if (HuaweiAudioKit.access$000(this.a) != null)
    {
      HuaweiAudioKit.access$000(this.a).destroy();
      HuaweiAudioKit.access$002(this.a, null);
    }
    HuaweiAudioKit.access$102(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit.2
 * JD-Core Version:    0.7.0.1
 */