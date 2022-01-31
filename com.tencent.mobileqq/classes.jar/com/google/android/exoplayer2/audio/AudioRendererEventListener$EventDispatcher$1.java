package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.DecoderCounters;

class AudioRendererEventListener$EventDispatcher$1
  implements Runnable
{
  AudioRendererEventListener$EventDispatcher$1(AudioRendererEventListener.EventDispatcher paramEventDispatcher, DecoderCounters paramDecoderCounters) {}
  
  public void run()
  {
    AudioRendererEventListener.EventDispatcher.access$000(this.this$0).onAudioEnabled(this.val$decoderCounters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.1
 * JD-Core Version:    0.7.0.1
 */