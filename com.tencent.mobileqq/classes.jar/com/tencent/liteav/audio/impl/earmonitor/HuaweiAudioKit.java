package com.tencent.liteav.audio.impl.earmonitor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit.ParameName;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit.FeatureType;
import com.huawei.multimedia.liteav.audiokit.interfaces.IAudioKitCallback;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.j;
import com.tencent.liteav.basic.util.j.a;
import java.util.concurrent.TimeUnit;

public class HuaweiAudioKit
  implements IAudioKitCallback, TXSystemAudioKit, j.a
{
  private static final int BACKGROUND_CHECK_INTERVAL = (int)TimeUnit.SECONDS.toMillis(1L);
  private static final String TAG = "HuaweiAudioKit";
  private a mAudioKitCallback;
  private j mBackgroundCheckTimer;
  private HwAudioKit mHwAudioKit;
  private boolean mIsAudioKitIniting = false;
  private boolean mIsBackgroundWhenLastCheck = false;
  private boolean mIsEarMonitoringEnabled = false;
  private HwAudioKaraokeFeatureKit mKaraokeKit;
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  private void dealWithAudioKitResultInternal(int paramInt)
  {
    TXCLog.i("HuaweiAudioKit", "on audio kit callback: %d", new Object[] { Integer.valueOf(paramInt) });
    a locala;
    if (paramInt == 0)
    {
      this.mIsAudioKitIniting = false;
      locala = this.mAudioKitCallback;
      if (locala != null) {
        locala.onAudioKitInitFinished(this, true);
      }
      if (this.mHwAudioKit.isFeatureSupported(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE))
      {
        this.mKaraokeKit = ((HwAudioKaraokeFeatureKit)this.mHwAudioKit.createFeature(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE));
        return;
      }
      locala = this.mAudioKitCallback;
      if (locala != null) {
        locala.onEarMonitoringInitialized(this, false);
      }
    }
    else if (paramInt == 1000)
    {
      locala = this.mAudioKitCallback;
      if (locala != null) {
        locala.onEarMonitoringInitialized(this, true);
      }
    }
    else if (paramInt != 1805)
    {
      locala = this.mAudioKitCallback;
      if (locala != null)
      {
        if (this.mIsAudioKitIniting)
        {
          locala.onAudioKitInitFinished(this, false);
          this.mIsAudioKitIniting = false;
          return;
        }
        locala.onAudioKitError(this);
      }
    }
  }
  
  private boolean isAppInBackground()
  {
    boolean bool = false;
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      int i = localRunningAppProcessInfo.importance;
      if (i != 100) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void setSystemEarMonitoringVolumeInternal(int paramInt)
  {
    TXCLog.i("HuaweiAudioKit", "setSystemEarMonitoringVolumeInternal: %d, kit: %s", new Object[] { Integer.valueOf(paramInt), this.mKaraokeKit });
    HwAudioKaraokeFeatureKit localHwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (localHwAudioKaraokeFeatureKit != null)
    {
      paramInt = localHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_VOLUME_BASE, paramInt);
      if ((paramInt == 1806) || (paramInt == -2)) {
        dealWithAudioKitResultInternal(-2);
      }
    }
  }
  
  private void startSystemEarMonitoringInternal()
  {
    TXCLog.i("HuaweiAudioKit", "startSystemEarMonitoring kit: %s", new Object[] { this.mKaraokeKit });
    HwAudioKaraokeFeatureKit localHwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (localHwAudioKaraokeFeatureKit == null) {
      return;
    }
    int i = localHwAudioKaraokeFeatureKit.enableKaraokeFeature(true);
    if ((i != 0) && (i != 1805))
    {
      dealWithAudioKitResultInternal(1003);
      return;
    }
    this.mIsEarMonitoringEnabled = true;
  }
  
  private void startTimer()
  {
    if (this.mBackgroundCheckTimer != null) {
      return;
    }
    TXCLog.i("HuaweiAudioKit", "start background checking timer");
    this.mBackgroundCheckTimer = new j(Looper.getMainLooper(), this);
    this.mBackgroundCheckTimer.a(0, BACKGROUND_CHECK_INTERVAL);
  }
  
  private void stopSystemEarMonitoringInternal()
  {
    TXCLog.i("HuaweiAudioKit", "stopSystemEarMonitoring");
    HwAudioKaraokeFeatureKit localHwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (localHwAudioKaraokeFeatureKit != null)
    {
      localHwAudioKaraokeFeatureKit.enableKaraokeFeature(false);
      this.mIsEarMonitoringEnabled = false;
    }
  }
  
  private void stopTimer()
  {
    if (this.mBackgroundCheckTimer != null)
    {
      TXCLog.i("HuaweiAudioKit", "stop background checking timer");
      this.mBackgroundCheckTimer.a();
      this.mBackgroundCheckTimer = null;
    }
  }
  
  public void initialize(Context paramContext, a parama)
  {
    this.mUiHandler.post(new HuaweiAudioKit.1(this, parama, paramContext));
  }
  
  public void onResult(int paramInt)
  {
    this.mUiHandler.post(new HuaweiAudioKit.6(this, paramInt));
  }
  
  public void onTimeout()
  {
    boolean bool = isAppInBackground();
    if ((this.mIsEarMonitoringEnabled) && (this.mIsBackgroundWhenLastCheck) && (!bool))
    {
      stopSystemEarMonitoringInternal();
      startSystemEarMonitoringInternal();
    }
    else if ((bool) && (!this.mIsBackgroundWhenLastCheck))
    {
      TXCLog.i("HuaweiAudioKit", "app has gone to background.");
    }
    this.mIsBackgroundWhenLastCheck = bool;
  }
  
  public void setSystemEarMonitoringVolume(int paramInt)
  {
    this.mUiHandler.post(new HuaweiAudioKit.5(this, paramInt));
  }
  
  public void startSystemEarMonitoring()
  {
    this.mUiHandler.post(new HuaweiAudioKit.3(this));
  }
  
  public void stopSystemEarMonitoring()
  {
    this.mUiHandler.post(new HuaweiAudioKit.4(this));
  }
  
  public void uninitialize()
  {
    this.mUiHandler.post(new HuaweiAudioKit.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit
 * JD-Core Version:    0.7.0.1
 */