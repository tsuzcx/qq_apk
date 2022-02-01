package com.tencent.TMG.audio;

import android.media.AudioManager;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$headsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$headsetSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    TraeAudioManager localTraeAudioManager;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      localTraeAudioManager = this.this$0;
      localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
      this.this$0._am.setWiredHeadsetOn(true);
    }
    updateStatus();
    int i;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
      i = 0;
    }
    for (;;)
    {
      long l;
      if (this._running == true)
      {
        if (this.this$0._am.isSpeakerphoneOn())
        {
          localTraeAudioManager = this.this$0;
          localTraeAudioManager.InternalSetSpeaker(localTraeAudioManager._context, false);
        }
        if (i < 5) {
          l = 1000L;
        } else {
          l = 4000L;
        }
      }
      try
      {
        Thread.sleep(l);
        label121:
        i += 1;
        continue;
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect headset: do nothing");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label121;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_WIREDHEADSET";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.headsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */