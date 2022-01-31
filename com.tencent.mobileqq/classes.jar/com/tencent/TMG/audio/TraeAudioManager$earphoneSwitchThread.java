package com.tencent.TMG.audio;

import android.media.AudioManager;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$earphoneSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$earphoneSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    if (TraeAudioManager.IsUpdateSceneFlag) {
      this.this$0.InternalSetSpeaker(this.this$0._context, false);
    }
    updateStatus();
    if (!TraeAudioManager.IsUpdateSceneFlag) {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "connect earphone: do nothing");
      }
    }
    for (;;)
    {
      return;
      while (this._running == true)
      {
        if (this.this$0._am.isSpeakerphoneOn()) {
          this.this$0.InternalSetSpeaker(this.this$0._context, false);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label97:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label97;
        }
        int i = 0;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_EARPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.earphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */