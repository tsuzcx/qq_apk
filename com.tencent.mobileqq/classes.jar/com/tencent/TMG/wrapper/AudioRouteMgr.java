package com.tencent.TMG.wrapper;

import android.content.Context;
import com.tencent.TMG.audio.TraeAudioSession;
import com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback;
import com.tencent.TMG.utils.QLog;

public class AudioRouteMgr
{
  private static AudioRouteMgr s_instance = null;
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
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.w("AudioRoute", 0, " onOutputChanage:" + paramString);
    }
    if (paramString.equals("DEVICE_EARPHONE")) {}
    for (;;)
    {
      onAudioRouteChange(i);
      return;
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
  }
  
  public int setContext(Context paramContext)
  {
    this.mContext = paramContext;
    return 0;
  }
  
  public int start()
  {
    if (this.mAudioSession == null) {
      this.mAudioSession = new TraeAudioSession(this.mContext, new TraeAudioSession.ITraeAudioCallback()
      {
        public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
        
        public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AudioRouteMgr.this.onOutputChanage(paramAnonymousString1);
        }
        
        public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
        
        public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onServiceStateUpdate(boolean paramAnonymousBoolean) {}
        
        public void onStreamTypeUpdate(int paramAnonymousInt) {}
        
        public void onVoicecallPreprocessRes(int paramAnonymousInt) {}
      });
    }
    return 0;
  }
  
  public int stop()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.wrapper.AudioRouteMgr
 * JD-Core Version:    0.7.0.1
 */