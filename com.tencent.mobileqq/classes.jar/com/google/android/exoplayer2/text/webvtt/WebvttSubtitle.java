package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle
  implements Subtitle
{
  private final long[] cueTimesUs;
  private final List<WebvttCue> cues;
  private final int numCues;
  private final long[] sortedCueTimesUs;
  
  public WebvttSubtitle(List<WebvttCue> paramList)
  {
    this.cues = paramList;
    this.numCues = paramList.size();
    this.cueTimesUs = new long[this.numCues * 2];
    int i = 0;
    while (i < this.numCues)
    {
      WebvttCue localWebvttCue = (WebvttCue)paramList.get(i);
      int j = i * 2;
      this.cueTimesUs[j] = localWebvttCue.startTime;
      this.cueTimesUs[(j + 1)] = localWebvttCue.endTime;
      i += 1;
    }
    paramList = this.cueTimesUs;
    this.sortedCueTimesUs = Arrays.copyOf(paramList, paramList.length);
    Arrays.sort(this.sortedCueTimesUs);
  }
  
  public List<Cue> getCues(long paramLong)
  {
    Object localObject4 = null;
    int i = 0;
    Object localObject3 = null;
    Object localObject2;
    for (Object localObject1 = localObject3; i < this.numCues; localObject1 = localObject2)
    {
      long[] arrayOfLong = this.cueTimesUs;
      int j = i * 2;
      Object localObject5 = localObject4;
      Object localObject6 = localObject3;
      localObject2 = localObject1;
      if (arrayOfLong[j] <= paramLong)
      {
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject2 = localObject1;
        if (paramLong < arrayOfLong[(j + 1)])
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          localObject6 = (WebvttCue)this.cues.get(i);
          if (((WebvttCue)localObject6).isNormalCue())
          {
            if (localObject3 == null)
            {
              localObject5 = localObject4;
            }
            else if (localObject4 == null)
            {
              localObject5 = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject5).append(localObject3.text).append("\n").append(((WebvttCue)localObject6).text);
              localObject6 = localObject3;
            }
            else
            {
              localObject4.append("\n").append(((WebvttCue)localObject6).text);
              localObject5 = localObject4;
              localObject6 = localObject3;
            }
          }
          else
          {
            ((ArrayList)localObject2).add(localObject6);
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
        }
      }
      i += 1;
      localObject4 = localObject5;
      localObject3 = localObject6;
    }
    if (localObject4 != null) {
      localObject1.add(new WebvttCue(localObject4));
    } else if (localObject3 != null) {
      localObject1.add(localObject3);
    }
    if (localObject1 != null) {
      return localObject1;
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
    if (paramInt < this.sortedCueTimesUs.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    return this.sortedCueTimesUs[paramInt];
  }
  
  public int getEventTimeCount()
  {
    return this.sortedCueTimesUs.length;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil(this.sortedCueTimesUs, paramLong, false, false);
    if (i < this.sortedCueTimesUs.length) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttSubtitle
 * JD-Core Version:    0.7.0.1
 */