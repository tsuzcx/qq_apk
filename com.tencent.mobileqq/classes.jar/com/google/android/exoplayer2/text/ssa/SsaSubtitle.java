package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle
  implements Subtitle
{
  private final long[] cueTimesUs;
  private final Cue[] cues;
  
  public SsaSubtitle(Cue[] paramArrayOfCue, long[] paramArrayOfLong)
  {
    this.cues = paramArrayOfCue;
    this.cueTimesUs = paramArrayOfLong;
  }
  
  public List<Cue> getCues(long paramLong)
  {
    int i = Util.binarySearchFloor(this.cueTimesUs, paramLong, true, false);
    if ((i == -1) || (this.cues[i] == null)) {
      return Collections.emptyList();
    }
    return Collections.singletonList(this.cues[i]);
  }
  
  public long getEventTime(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramInt >= this.cueTimesUs.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      return this.cueTimesUs[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public int getEventTimeCount()
  {
    return this.cueTimesUs.length;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil(this.cueTimesUs, paramLong, false, false);
    if (i < this.cueTimesUs.length) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ssa.SsaSubtitle
 * JD-Core Version:    0.7.0.1
 */