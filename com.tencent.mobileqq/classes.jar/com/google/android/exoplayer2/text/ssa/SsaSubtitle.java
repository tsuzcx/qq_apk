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
    if (i != -1)
    {
      Cue[] arrayOfCue = this.cues;
      if (arrayOfCue[i] != null) {
        return Collections.singletonList(arrayOfCue[i]);
      }
    }
    return Collections.emptyList();
  }
  
  public long getEventTime(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if (paramInt < this.cueTimesUs.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    return this.cueTimesUs[paramInt];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ssa.SsaSubtitle
 * JD-Core Version:    0.7.0.1
 */