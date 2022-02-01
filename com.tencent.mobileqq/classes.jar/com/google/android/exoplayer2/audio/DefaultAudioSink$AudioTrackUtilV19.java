package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
class DefaultAudioSink$AudioTrackUtilV19
  extends DefaultAudioSink.AudioTrackUtil
{
  private final AudioTimestamp audioTimestamp = new AudioTimestamp();
  private long lastRawTimestampFramePosition;
  private long lastTimestampFramePosition;
  private long rawTimestampFramePositionWrapCount;
  
  public DefaultAudioSink$AudioTrackUtilV19()
  {
    super(null);
  }
  
  public long getTimestampFramePosition()
  {
    return this.lastTimestampFramePosition;
  }
  
  public long getTimestampNanoTime()
  {
    return this.audioTimestamp.nanoTime;
  }
  
  public void reconfigure(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    super.reconfigure(paramAudioTrack, paramBoolean);
    this.rawTimestampFramePositionWrapCount = 0L;
    this.lastRawTimestampFramePosition = 0L;
    this.lastTimestampFramePosition = 0L;
  }
  
  public boolean updateTimestamp()
  {
    boolean bool = this.audioTrack.getTimestamp(this.audioTimestamp);
    if (bool)
    {
      long l = this.audioTimestamp.framePosition;
      if (this.lastRawTimestampFramePosition > l) {
        this.rawTimestampFramePositionWrapCount += 1L;
      }
      this.lastRawTimestampFramePosition = l;
      this.lastTimestampFramePosition = (l + (this.rawTimestampFramePositionWrapCount << 32));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtilV19
 * JD-Core Version:    0.7.0.1
 */