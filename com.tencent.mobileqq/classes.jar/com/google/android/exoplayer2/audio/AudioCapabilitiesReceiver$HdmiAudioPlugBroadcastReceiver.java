package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver
  extends BroadcastReceiver
{
  private AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver(AudioCapabilitiesReceiver paramAudioCapabilitiesReceiver) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!isInitialStickyBroadcast())
    {
      paramContext = AudioCapabilities.getCapabilities(paramIntent);
      if (!paramContext.equals(this.this$0.audioCapabilities))
      {
        paramIntent = this.this$0;
        paramIntent.audioCapabilities = paramContext;
        AudioCapabilitiesReceiver.access$100(paramIntent).onAudioCapabilitiesChanged(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.HdmiAudioPlugBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */