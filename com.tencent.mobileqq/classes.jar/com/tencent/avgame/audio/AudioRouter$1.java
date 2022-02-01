package com.tencent.avgame.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AudioRouter$1
  extends BroadcastReceiver
{
  AudioRouter$1(AudioRouter paramAudioRouter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AudioRouter.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.AudioRouter.1
 * JD-Core Version:    0.7.0.1
 */