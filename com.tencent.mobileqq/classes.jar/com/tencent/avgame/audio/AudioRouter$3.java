package com.tencent.avgame.audio;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AudioRouter$3
  implements Runnable
{
  AudioRouter$3(AudioRouter paramAudioRouter, Intent paramIntent, String paramString) {}
  
  public void run()
  {
    int i = -1;
    int j;
    if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(this.jdField_a_of_type_AndroidContentIntent.getAction()))
    {
      j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_AUDIO_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(j) }));
      if (j == 12) {
        if (AudioRouter.a(this.this$0))
        {
          AudioRouter.a(this.this$0, false);
          AudioRouter.a(this.this$0, 2, i);
        }
      }
    }
    label179:
    label252:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = 0;
              break;
            } while (j != 10);
            AudioRouter.a(this.this$0, 2);
            return;
            if (!"android.intent.action.HEADSET_PLUG".equals(this.jdField_a_of_type_JavaLangString)) {
              break label179;
            }
            i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("state", -1);
            QLog.d("AudioRouter", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0)
            {
              AudioRouter.a(this.this$0, 0);
              return;
            }
          } while (i != 1);
          AudioRouter.a(this.this$0, 0, 3);
          return;
          if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(this.jdField_a_of_type_JavaLangString)) {
            break label252;
          }
          i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
          QLog.d("AudioRouter", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
          if (i == 2)
          {
            AudioRouter.a(this.this$0, 2, 0);
            return;
          }
        } while (i != 0);
        AudioRouter.a(this.this$0, 2);
        return;
      } while (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(this.jdField_a_of_type_JavaLangString));
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      QLog.d("AudioRouter", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", new Object[] { Integer.valueOf(i) }));
    } while ((i != 10) && (i != 13));
    AudioRouter.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.AudioRouter.3
 * JD-Core Version:    0.7.0.1
 */