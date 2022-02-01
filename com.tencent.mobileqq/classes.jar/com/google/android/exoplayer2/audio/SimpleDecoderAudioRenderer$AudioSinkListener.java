package com.google.android.exoplayer2.audio;

final class SimpleDecoderAudioRenderer$AudioSinkListener
  implements AudioSink.Listener
{
  private SimpleDecoderAudioRenderer$AudioSinkListener(SimpleDecoderAudioRenderer paramSimpleDecoderAudioRenderer) {}
  
  public boolean isNeedAudioData()
  {
    return false;
  }
  
  public void onAudioSessionId(int paramInt)
  {
    SimpleDecoderAudioRenderer.access$100(this.this$0).audioSessionId(paramInt);
    this.this$0.onAudioSessionId(paramInt);
  }
  
  public void onPositionDiscontinuity()
  {
    this.this$0.onAudioTrackPositionDiscontinuity();
    SimpleDecoderAudioRenderer.access$202(this.this$0, true);
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte) {}
  
  public void onUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    SimpleDecoderAudioRenderer.access$100(this.this$0).audioTrackUnderrun(paramInt, paramLong1, paramLong2);
    this.this$0.onAudioTrackUnderrun(paramInt, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.AudioSinkListener
 * JD-Core Version:    0.7.0.1
 */