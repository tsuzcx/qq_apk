package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.util.List;

public abstract class SubtitleOutputBuffer
  extends OutputBuffer
  implements Subtitle
{
  private long subsampleOffsetUs;
  private Subtitle subtitle;
  
  public void clear()
  {
    super.clear();
    this.subtitle = null;
  }
  
  public List<Cue> getCues(long paramLong)
  {
    return this.subtitle.getCues(paramLong - this.subsampleOffsetUs);
  }
  
  public long getEventTime(int paramInt)
  {
    return this.subtitle.getEventTime(paramInt) + this.subsampleOffsetUs;
  }
  
  public int getEventTimeCount()
  {
    return this.subtitle.getEventTimeCount();
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    return this.subtitle.getNextEventTimeIndex(paramLong - this.subsampleOffsetUs);
  }
  
  public abstract void release();
  
  public void setContent(long paramLong1, Subtitle paramSubtitle, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.subtitle = paramSubtitle;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.subsampleOffsetUs = paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleOutputBuffer
 * JD-Core Version:    0.7.0.1
 */