package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTrackSelection
  implements TrackSelection
{
  private final long[] blacklistUntilTimes;
  private final Format[] formats;
  protected final TrackGroup group;
  private int hashCode;
  protected final int length;
  protected final int[] tracks;
  
  public BaseTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.group = ((TrackGroup)Assertions.checkNotNull(paramTrackGroup));
    this.length = paramVarArgs.length;
    this.formats = new Format[this.length];
    i = 0;
    while (i < paramVarArgs.length)
    {
      this.formats[i] = paramTrackGroup.getFormat(paramVarArgs[i]);
      i += 1;
    }
    Arrays.sort(this.formats, new BaseTrackSelection.DecreasingBandwidthComparator(null));
    this.tracks = new int[this.length];
    i = j;
    for (;;)
    {
      j = this.length;
      if (i >= j) {
        break;
      }
      this.tracks[i] = paramTrackGroup.indexOf(this.formats[i]);
      i += 1;
    }
    this.blacklistUntilTimes = new long[j];
  }
  
  public final boolean blacklist(int paramInt, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = isBlacklisted(paramInt, l);
    int i = 0;
    while ((i < this.length) && (!bool))
    {
      if ((i != paramInt) && (!isBlacklisted(i, l))) {
        bool = true;
      } else {
        bool = false;
      }
      i += 1;
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.blacklistUntilTimes;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], l + paramLong);
    return true;
  }
  
  public void disable() {}
  
  public void enable() {}
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BaseTrackSelection)paramObject;
      return (this.group == paramObject.group) && (Arrays.equals(this.tracks, paramObject.tracks));
    }
    return false;
  }
  
  public int evaluateQueueSize(long paramLong, List<? extends MediaChunk> paramList)
  {
    return paramList.size();
  }
  
  public final Format getFormat(int paramInt)
  {
    return this.formats[paramInt];
  }
  
  public final int getIndexInTrackGroup(int paramInt)
  {
    return this.tracks[paramInt];
  }
  
  public final Format getSelectedFormat()
  {
    return this.formats[getSelectedIndex()];
  }
  
  public final int getSelectedIndexInTrackGroup()
  {
    return this.tracks[getSelectedIndex()];
  }
  
  public final TrackGroup getTrackGroup()
  {
    return this.group;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = (System.identityHashCode(this.group) * 31 + Arrays.hashCode(this.tracks));
    }
    return this.hashCode;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.tracks[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int indexOf(Format paramFormat)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.formats[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final boolean isBlacklisted(int paramInt, long paramLong)
  {
    return this.blacklistUntilTimes[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.tracks.length;
  }
  
  public void onPlaybackSpeed(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.BaseTrackSelection
 * JD-Core Version:    0.7.0.1
 */