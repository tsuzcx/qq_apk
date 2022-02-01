package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.multimedia.liteav.audioengine.IHwAudioKaraokeFeature.Stub;
import com.tencent.liteav.basic.log.TXCLog;

class HwAudioKaraokeFeatureKit$1
  implements ServiceConnection
{
  HwAudioKaraokeFeatureKit$1(HwAudioKaraokeFeatureKit paramHwAudioKaraokeFeatureKit) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
    HwAudioKaraokeFeatureKit.access$002(this.this$0, IHwAudioKaraokeFeature.Stub.asInterface(paramIBinder));
    if (HwAudioKaraokeFeatureKit.access$000(this.this$0) != null)
    {
      HwAudioKaraokeFeatureKit.access$102(this.this$0, true);
      HwAudioKaraokeFeatureKit.access$200(this.this$0).onCallBack(1000);
      paramComponentName = this.this$0;
      HwAudioKaraokeFeatureKit.access$400(paramComponentName, HwAudioKaraokeFeatureKit.access$300(paramComponentName).getPackageName());
      HwAudioKaraokeFeatureKit.access$500(this.this$0, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
    HwAudioKaraokeFeatureKit.access$102(this.this$0, false);
    if (HwAudioKaraokeFeatureKit.access$200(this.this$0) != null) {
      HwAudioKaraokeFeatureKit.access$200(this.this$0).onCallBack(1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit.1
 * JD-Core Version:    0.7.0.1
 */