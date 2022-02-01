package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.qphone.base.util.QLog;

class AudioBluetoothSCOHelper$AudioBluetoothSCOReceiver
  extends BroadcastReceiver
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long b = 0L;
  
  private AudioBluetoothSCOHelper$AudioBluetoothSCOReceiver(AudioBluetoothSCOHelper paramAudioBluetoothSCOHelper, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = SystemClock.uptimeMillis();
    int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SCOHelper", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + i + " " + this.jdField_a_of_type_JavaLangString + ", time=" + l);
    }
    paramContext = AudioBluetoothSCOHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper);
    if (1 == i) {
      if (this.b == 0L)
      {
        this.b = l;
        if (paramContext != null)
        {
          paramIntent = paramContext.a();
          if (paramIntent != null)
          {
            paramIntent.setBluetoothScoOn(true);
            AudioPlayerBase.d = true;
          }
          paramContext.f();
          if (!paramContext.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("AudioPlayer_SCOHelper", 2, "onReceive SCO_AUDIO_STATE_CONNECTED need replay time=" + l);
            }
            paramContext.d(true);
            paramContext.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (2 == i)
          {
            this.jdField_a_of_type_Boolean = true;
            return;
          }
        } while (i != 0);
        if (this.jdField_a_of_type_Long == 0L)
        {
          this.jdField_a_of_type_Long = l;
          return;
        }
        if ((this.jdField_a_of_type_Boolean) && (paramContext != null)) {
          paramContext.l();
        }
        if (paramContext != null) {
          paramContext.g();
        }
        if (((this.b == 0L) || (l - this.b > 2000L)) && (l - this.jdField_a_of_type_Long > 1000L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_SCOHelper", 2, "sco disconnected quickly.");
        }
        AudioPlayerBase.c = true;
      } while (paramContext == null);
      paramContext.e();
      if (paramContext.a())
      {
        paramContext.d(false);
        paramContext.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        return;
      }
      paramContext.a(0);
      return;
    } while ((paramContext == null) || (!paramContext.a()));
    paramContext.a(paramContext.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver
 * JD-Core Version:    0.7.0.1
 */