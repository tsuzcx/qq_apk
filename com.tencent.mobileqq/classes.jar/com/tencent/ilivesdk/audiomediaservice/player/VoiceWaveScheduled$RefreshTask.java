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
      VoiceWaveScheduled.b(this.this$0, VoiceWaveScheduled.a(this.this$0));
      return;
    }
    VoiceWaveScheduled.a(this.this$0, VoiceWaveScheduled.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.VoiceWaveScheduled.RefreshTask
 * JD-Core Version:    0.7.0.1
 */