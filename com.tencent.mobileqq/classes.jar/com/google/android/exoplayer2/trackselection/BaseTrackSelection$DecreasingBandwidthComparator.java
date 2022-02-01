package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import java.util.Comparator;

final class BaseTrackSelection$DecreasingBandwidthComparator
  implements Comparator<Format>
{
  public int compare(Format paramFormat1, Format paramFormat2)
  {
    return paramFormat2.bitrate - paramFormat1.bitrate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.BaseTrackSelection.DecreasingBandwidthComparator
 * JD-Core Version:    0.7.0.1
 */