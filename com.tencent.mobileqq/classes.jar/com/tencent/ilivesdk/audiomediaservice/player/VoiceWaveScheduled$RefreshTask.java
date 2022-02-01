package com.tencent.ilivesdk.audiomediaservice.player;

class VoiceWaveScheduled$RefreshTask
  implements Runnable
{
  private VoiceWaveScheduled$RefreshTask(VoiceWaveScheduled paramVoiceWaveScheduled) {}
  
  public void run()
  {
    if (VoiceWaveScheduled.a(this.this$0) == null) {
      return;
    }
    if (VoiceWaveScheduled.a(this.this$0))
    {
      localVoiceWaveScheduled = this.this$0;
      VoiceWaveScheduled.b(localVoiceWaveScheduled, VoiceWaveScheduled.a(localVoiceWaveScheduled));
      return;
    }
    VoiceWaveScheduled localVoiceWaveScheduled = this.this$0;
    VoiceWaveScheduled.a(localVoiceWaveScheduled, VoiceWaveScheduled.a(localVoiceWaveScheduled));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.VoiceWaveScheduled.RefreshTask
 * JD-Core Version:    0.7.0.1
 */