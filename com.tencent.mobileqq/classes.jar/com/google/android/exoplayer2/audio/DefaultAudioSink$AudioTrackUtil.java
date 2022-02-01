package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Util;

class DefaultAudioSink$AudioTrackUtil
{
  private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200L;
  protected AudioTrack audioTrack;
  private long endPlaybackHeadPosition;
  private long forceResetWorkaroundTimeMs;
  private long lastRawPlaybackHeadPosition;
  private boolean needsPassthroughWorkaround;
  private long passthroughWorkaroundPauseOffset;
  private long rawPlaybackHeadWrapCount;
  private int sampleRate;
  private long stopPlaybackHeadPosition;
  private long stopTimestampUs;
  
  public long getPlaybackHeadPosition()
  {
    if (this.stopTimestampUs != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.stopTimestampUs) * this.sampleRate / 1000000L;
      return Math.min(this.endPlaybackHeadPosition, l1 + this.stopPlaybackHeadPosition);
    }
    int i = this.audioTrack.getPlayState();
    if (i == 1) {
      return 0L;
    }
    long l2 = 0xFFFFFFFF & this.audioTrack.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.needsPassthroughWorkaround)
    {
      if ((i == 2) && (l2 == 0L)) {
        this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
      }
      l1 = l2 + this.passthroughWorkaroundPauseOffset;
    }
    if (Util.SDK_INT <= 28)
    {
      if ((l1 == 0L) && (this.lastRawPlaybackHeadPosition > 0L) && (i == 3))
      {
        if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
          this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
        }
        return this.lastRawPlaybackHeadPosition;
      }
      this.forceResetWorkaroundTimeMs = -9223372036854775807L;
    }
    if (this.lastRawPlaybackHeadPosition > l1) {
      this.rawPlaybackHeadWrapCount += 1L;
    }
    this.lastRawPlaybackHeadPosition = l1;
    return l1 + (this.rawPlaybackHeadWrapCount << 32);
  }
  
  public long getPositionUs()
  {
    return getPlaybackHeadPosition() * 1000000L / this.sampleRate;
  }
  
  public long getTimestampFramePosition()
  {
    throw new UnsupportedOperationException();
  }
  
  public long getTimestampNanoTime()
  {
    throw new UnsupportedOperationException();
  }
  
  public void handleEndOfStream(long paramLong)
  {
    this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
    this.stopTimestampUs = (SystemClock.elapsedRealtime() * 1000L);
    this.endPlaybackHeadPosition = paramLong;
    this.audioTrack.stop();
  }
  
  public boolean needsReset(long paramLong)
  {
    return (this.forceResetWorkaroundTimeMs != -9223372036854775807L) && (paramLong > 0L) && (SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200L);
  }
  
  public void pause()
  {
    if (this.stopTimestampUs != -9223372036854775807L) {
      return;
    }
    this.audioTrack.pause();
  }
  
  public void reconfigure(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    this.audioTrack = paramAudioTrack;
    this.needsPassthroughWorkaround = paramBoolean;
    this.stopTimestampUs = -9223372036854775807L;
    this.forceResetWorkaroundTimeMs = -9223372036854775807L;
    this.lastRawPlaybackHeadPosition = 0L;
    this.rawPlaybackHeadWrapCount = 0L;
    this.passthroughWorkaroundPauseOffset = 0L;
    if (paramAudioTrack != null) {
      this.sampleRate = paramAudioTrack.getSampleRate();
    }
  }
  
  public boolean updateTimestamp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
 * JD-Core Version:    0.7.0.1
 */