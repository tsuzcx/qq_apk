package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

final class DvbSubtitle
  implements Subtitle
{
  private final List<Cue> cues;
  
  public DvbSubtitle(List<Cue> paramList)
  {
    this.cues = paramList;
  }
  
  public List<Cue> getCues(long paramLong)
  {
    return this.cues;
  }
  
  public long getEventTime(int paramInt)
  {
    return 0L;
  }
  
  public int getEventTimeCount()
  {
    return 1;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbSubtitle
 * JD-Core Version:    0.7.0.1
 */