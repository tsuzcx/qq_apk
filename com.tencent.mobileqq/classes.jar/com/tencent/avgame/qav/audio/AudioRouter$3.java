package com.tencent.avgame.qav.audio;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AudioRouter$3
  implements Runnable
{
  AudioRouter$3(AudioRouter paramAudioRouter, Intent paramIntent, String paramString) {}
  
  public void run()
  {
    boolean bool = "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(this.a.getAction());
    int i = -1;
    if (bool)
    {
      int j = this.a.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_AUDIO_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(j) }));
      if (j == 12)
      {
        if (!AudioRouter.a(this.this$0)) {
          i = 0;
        }
        AudioRouter.a(this.this$0, false);
        AudioRouter.a(this.this$0, 2, i);
        return;
      }
      if (j == 10) {
        AudioRouter.a(this.this$0, 2);
      }
    }
    else if ("android.intent.action.HEADSET_PLUG".equals(this.b))
    {
      i = this.a.getIntExtra("state", -1);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 0)
      {
        AudioRouter.a(this.this$0, 0);
        return;
      }
      if (i == 1) {
        AudioRouter.a(this.this$0, 0, 3);
      }
    }
    else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(this.b))
    {
      i = this.a.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if (i == 2)
      {
        AudioRouter.a(this.this$0, 2, 0);
        return;
      }
      if (i == 0) {
        AudioRouter.a(this.this$0, 2);
      }
    }
    else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(this.b))
    {
      i = this.a.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
      if ((i == 10) || (i == 13)) {
        AudioRouter.a(this.this$0, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AudioRouter.3
 * JD-Core Version:    0.7.0.1
 */