package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.multimedia.liteav.audioengine.IHwAudioEngine.Stub;
import com.tencent.liteav.basic.log.TXCLog;

class HwAudioKit$1
  implements ServiceConnection
{
  HwAudioKit$1(HwAudioKit paramHwAudioKit) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HwAudioKit.access$002(this.this$0, IHwAudioEngine.Stub.asInterface(paramIBinder));
    TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected");
    if (HwAudioKit.access$000(this.this$0) != null)
    {
      HwAudioKit.access$102(this.this$0, true);
      TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected, mIHwAudioEngine is not null");
      HwAudioKit.access$200(this.this$0).onCallBack(0);
      paramComponentName = this.this$0;
      HwAudioKit.access$400(paramComponentName, HwAudioKit.access$300(paramComponentName).getPackageName(), "1.0.1");
      HwAudioKit.access$500(this.this$0, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "onServiceDisconnected");
    HwAudioKit.access$002(this.this$0, null);
    HwAudioKit.access$102(this.this$0, false);
    HwAudioKit.access$200(this.this$0).onCallBack(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit.1
 * JD-Core Version:    0.7.0.1
 */