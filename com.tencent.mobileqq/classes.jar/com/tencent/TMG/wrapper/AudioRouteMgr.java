package com.tencent.TMG.wrapper;

import android.content.Context;
import com.tencent.TMG.audio.TraeAudioSession;
import com.tencent.TMG.utils.QLog;

public class AudioRouteMgr
{
  private static AudioRouteMgr s_instance;
  private TraeAudioSession mAudioSession = null;
  private Context mContext = null;
  
  public static AudioRouteMgr getInstance()
  {
    if (s_instance == null) {
      s_instance = new AudioRouteMgr();
    }
    return s_instance;
  }
  
  private native void onAudioRouteChange(int paramInt);
  
  private void onOutputChanage(String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onOutputChanage:");
      localStringBuilder.append(paramString);
      QLog.w("AudioRoute", 0, localStringBuilder.toString());
    }
    if (!paramString.equals("DEVICE_EARPHONE")) {
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        i = 1;
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        i = 2;
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        i = 3;
      } else {
        i = -1;
      }
    }
    onAudioRouteChange(i);
  }
  
  public int setContext(Context paramContext)
  {
    this.mContext = paramContext;
    return 0;
  }
  
  public int start()
  {
    if (this.mAudioSession == null) {
      this.mAudioSession = new TraeAudioSession(this.mContext, new AudioRouteMgr.1(this));
    }
    return 0;
  }
  
  public int stop()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.wrapper.AudioRouteMgr
 * JD-Core Version:    0.7.0.1
 */