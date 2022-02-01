package com.google.android.exoplayer2.audio;

class AudioRendererEventListener$EventDispatcher$4
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$4(AudioRendererEventListener.EventDispatcher paramEventDispatcher, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onAudioSinkUnderrun(this.val$bufferSize, this.val$bufferSizeMs, this.val$elapsedSinceLastFeedMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.4
 * JD-Core Version:    0.7.0.1
 */