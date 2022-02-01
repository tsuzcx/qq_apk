package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;

class DefaultAudioSink$2
  extends Thread
{
  DefaultAudioSink$2(DefaultAudioSink paramDefaultAudioSink, AudioTrack paramAudioTrack) {}
  
  public void run()
  {
    this.val$toRelease.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink.2
 * JD-Core Version:    0.7.0.1
 */