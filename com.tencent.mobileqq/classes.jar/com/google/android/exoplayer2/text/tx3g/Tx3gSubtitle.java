package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle
  implements Subtitle
{
  public static final Tx3gSubtitle EMPTY = new Tx3gSubtitle();
  private final List<Cue> cues;
  
  private Tx3gSubtitle()
  {
    this.cues = Collections.emptyList();
  }
  
  public Tx3gSubtitle(Cue paramCue)
  {
    this.cues = Collections.singletonList(paramCue);
  }
  
  public List<Cue> getCues(long paramLong)
  {
    if (paramLong >= 0L) {
      return this.cues;
    }
    return Collections.emptyList();
  }
  
  public long getEventTime(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      return 0L;
    }
  }
  
  public int getEventTimeCount()
  {
    return 1;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle
 * JD-Core Version:    0.7.0.1
 */