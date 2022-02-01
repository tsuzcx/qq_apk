package com.tencent.liteav.audio.impl.earmonitor;

import android.content.Context;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.tencent.liteav.basic.log.TXCLog;

class HuaweiAudioKit$1
  implements Runnable
{
  HuaweiAudioKit$1(HuaweiAudioKit paramHuaweiAudioKit, a parama, Context paramContext) {}
  
  public void run()
  {
    if (HuaweiAudioKit.access$000(this.c) != null)
    {
      TXCLog.e("HuaweiAudioKit", "it's already initialized.");
      return;
    }
    TXCLog.i("HuaweiAudioKit", "start initialize audio kit");
    HuaweiAudioKit.access$102(this.c, true);
    HuaweiAudioKit.access$202(this.c, this.a);
    HuaweiAudioKit.access$002(this.c, new HwAudioKit(this.b.getApplicationContext(), this.c));
    HuaweiAudioKit.access$000(this.c).initialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit.1
 * JD-Core Version:    0.7.0.1
 */