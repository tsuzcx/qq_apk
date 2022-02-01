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
    Object localObject;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      localObject = this.this$0;
      ((TraeAudioManager)localObject).InternalSetSpeaker(((TraeAudioManager)localObject)._context, true);
    }
    updateStatus();
    boolean bool = TraeAudioManager.IsMusicScene;
    int j = 0;
    int i;
    if ((!bool) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" _run:");
        ((StringBuilder)localObject).append(getDeviceName());
        ((StringBuilder)localObject).append(" _running:");
        ((StringBuilder)localObject).append(this._running);
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    for (;;)
    {
      long l;
      if (this._running == true)
      {
        if (this.this$0._am.isSpeakerphoneOn() != true)
        {
          localObject = this.this$0;
          ((TraeAudioManager)localObject).InternalSetSpeaker(((TraeAudioManager)localObject)._context, true);
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
        label182:
        i += 1;
        continue;
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect speakerPhone: do nothing");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label182;
      }
    }
  }
  
  public String getDeviceName()
  {
    return "DEVICE_SPEAKERPHONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.speakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */