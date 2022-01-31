package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;

final class DefaultAudioSink$PlaybackParametersCheckpoint
{
  private final long mediaTimeUs;
  private final PlaybackParameters playbackParameters;
  private final long positionUs;
  
  private DefaultAudioSink$PlaybackParametersCheckpoint(PlaybackParameters paramPlaybackParameters, long paramLong1, long paramLong2)
  {
    this.playbackParameters = paramPlaybackParameters;
    this.mediaTimeUs = paramLong1;
    this.positionUs = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink.PlaybackParametersCheckpoint
 * JD-Core Version:    0.7.0.1
 */