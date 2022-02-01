package com.google.android.exoplayer2.audio;

final class MediaCodecAudioRenderer$AudioSinkListener
  implements AudioSink.Listener
{
  private MediaCodecAudioRenderer$AudioSinkListener(MediaCodecAudioRenderer paramMediaCodecAudioRenderer) {}
  
  public boolean isNeedAudioData()
  {
    return MediaCodecAudioRenderer.access$100(this.this$0).isNeedAudioData();
  }
  
  public void onAudioSessionId(int paramInt)
  {
    MediaCodecAudioRenderer.access$100(this.this$0).audioSessionId(paramInt);
    this.this$0.onAudioSessionId(paramInt);
  }
  
  public void onPositionDiscontinuity()
  {
    this.this$0.onAudioTrackPositionDiscontinuity();
    MediaCodecAudioRenderer.access$202(this.this$0, true);
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte)
  {
    MediaCodecAudioRenderer.access$100(this.this$0).onRenderAudioData(paramArrayOfByte);
  }
  
  public void onUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    MediaCodecAudioRenderer.access$100(this.this$0).audioTrackUnderrun(paramInt, paramLong1, paramLong2);
    this.this$0.onAudioTrackUnderrun(paramInt, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.AudioSinkListener
 * JD-Core Version:    0.7.0.1
 */