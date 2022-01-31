package com.google.android.exoplayer2.audio;

class AudioRendererEventListener$EventDispatcher$7
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$7(AudioRendererEventListener.EventDispatcher paramEventDispatcher, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onRenderAudioData(this.val$audioData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.7
 * JD-Core Version:    0.7.0.1
 */