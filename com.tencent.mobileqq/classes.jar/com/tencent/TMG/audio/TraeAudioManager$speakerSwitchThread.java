package com.tencent.TMG.audio;

import android.media.AudioManager;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$speakerSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$speakerSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void _quit() {}
  
  public void _run()
  {
    int j = 0;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
      this.this$0.InternalSetSpeaker(this.this$0._context, true);
    }
    updateStatus();
    if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "connect speakerPhone: do nothing");
      }
      return;
    }
    int i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 0, " _run:" + getDeviceName() + " _running:" + this._running);
      i = j;
    }
    while (this._running == true)
    {
      if (this.this$0._am.isSpeakerphoneOn() != true) {
        this.this$0.InternalSetSpeaker(this.this$0._context, true);
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
          label162:
          i += 1;
          break;
          l = 4000L;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label162;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_SPEAKERPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.speakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */