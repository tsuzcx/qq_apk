package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventCallback;
import com.tencent.ilive.opensdk.params.IAVMediaInfo.IVideoInfo;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;

class AudioRecordPlayer$5
  extends RtcCoreEventCallback
{
  AudioRecordPlayer$5(AudioRecordPlayer paramAudioRecordPlayer) {}
  
  public void onAVActionEvent(int paramInt1, int paramInt2, String paramString)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVActionEvent  eventId[%d] value[%d] msg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public void onAVEvent(int paramInt1, int paramInt2)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVEvent eventId[%d] subEventId[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onAVMediaInfoChange(IAVMediaInfo.IVideoInfo paramIVideoInfo)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVTerminated w[%d] h[%d] r[%d] id[%s]", new Object[] { Integer.valueOf(paramIVideoInfo.mWidth), Integer.valueOf(paramIVideoInfo.mHeight), Integer.valueOf(paramIVideoInfo.mRotate), paramIVideoInfo.identifier });
  }
  
  public void onAVStart()
  {
    AudioRecordPlayer.a(this.a).d("AudioRecordPlayer", "iavCoreEventCallback: onAVStart", new Object[0]);
    AudioRecordPlayer.a(this.a, true);
    if (AudioRecordPlayer.a(this.a)) {
      this.a.a(true);
    }
    if (AudioRecordPlayer.a(this.a) != null) {
      AudioRecordPlayer.a(this.a).a();
    }
  }
  
  public void onAVStop()
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVStop", new Object[0]);
    AudioRecordPlayer.a(this.a, false);
    if (AudioRecordPlayer.a(this.a) != null) {
      AudioRecordPlayer.a(this.a).b();
    }
  }
  
  public boolean onAVStreamEvent(int paramInt, String paramString)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVStreamEvent eventId[%d] aUin[%s]", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 5) {
      AudioRecordPlayer.a(this.a).a(Long.valueOf(paramString).longValue());
    }
    while (paramInt != 4) {
      return false;
    }
    AudioRecordPlayer.a(this.a).b(Long.valueOf(paramString).longValue());
    return false;
  }
  
  public void onAVTerminated(int paramInt)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVTerminated errorCode %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void onAVTimeEvent(int paramInt1, int paramInt2, String paramString)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "audioCoreEventCallback: onAVTimeEvent eventId[%d] value[%d] msg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.5
 * JD-Core Version:    0.7.0.1
 */