package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.liteav.basic.log.TXCLog;

class HwAudioKit$2
  implements IBinder.DeathRecipient
{
  HwAudioKit$2(HwAudioKit paramHwAudioKit) {}
  
  public void binderDied()
  {
    HwAudioKit.access$700(this.this$0).unlinkToDeath(HwAudioKit.access$600(this.this$0), 0);
    HwAudioKit.access$200(this.this$0).onCallBack(6);
    TXCLog.e("HwAudioKit.HwAudioKit", "service binder died");
    HwAudioKit.access$702(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit.2
 * JD-Core Version:    0.7.0.1
 */