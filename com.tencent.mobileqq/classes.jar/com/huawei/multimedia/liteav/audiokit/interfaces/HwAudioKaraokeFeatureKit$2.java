package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.liteav.basic.log.TXCLog;

class HwAudioKaraokeFeatureKit$2
  implements IBinder.DeathRecipient
{
  HwAudioKaraokeFeatureKit$2(HwAudioKaraokeFeatureKit paramHwAudioKaraokeFeatureKit) {}
  
  public void binderDied()
  {
    TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
    HwAudioKaraokeFeatureKit.access$700(this.this$0).unlinkToDeath(HwAudioKaraokeFeatureKit.access$600(this.this$0), 0);
    HwAudioKaraokeFeatureKit.access$200(this.this$0).onCallBack(1003);
    HwAudioKaraokeFeatureKit.access$702(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit.2
 * JD-Core Version:    0.7.0.1
 */