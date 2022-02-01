package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.support.annotation.CheckResult;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class AdPlaybackState$AdGroup
{
  public final int count;
  public final long[] durationsUs;
  public final int[] states;
  public final Uri[] uris;
  
  public AdPlaybackState$AdGroup()
  {
    this(-1, new int[0], new Uri[0], new long[0]);
  }
  
  private AdPlaybackState$AdGroup(int paramInt, int[] paramArrayOfInt, Uri[] paramArrayOfUri, long[] paramArrayOfLong)
  {
    if (paramArrayOfInt.length == paramArrayOfUri.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.count = paramInt;
      this.states = paramArrayOfInt;
      this.uris = paramArrayOfUri;
      this.durationsUs = paramArrayOfLong;
      return;
    }
  }
  
  @CheckResult
  private static long[] copyDurationsUsWithSpaceForAdCount(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramArrayOfLong.length;
    paramInt = Math.max(paramInt, i);
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramInt);
    Arrays.fill(paramArrayOfLong, i, paramInt, -9223372036854775807L);
    return paramArrayOfLong;
  }
  
  @CheckResult
  private static int[] copyStatesWithSpaceForAdCount(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    paramInt = Math.max(paramInt, i);
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    Arrays.fill(paramArrayOfInt, i, paramInt, 0);
    return paramArrayOfInt;
  }
  
  public int getFirstAdIndexToPlay()
  {
    return getNextAdIndexToPlay(-1);
  }
  
  public int getNextAdIndexToPlay(int paramInt)
  {
    paramInt += 1;
    for (;;)
    {
      if ((paramInt >= this.states.length) || (this.states[paramInt] == 0) || (this.states[paramInt] == 1)) {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public boolean hasUnplayedAds()
  {
    return (this.count == -1) || (getFirstAdIndexToPlay() < this.count);
  }
  
  @CheckResult
  public AdGroup withAdCount(int paramInt)
  {
    if ((this.count == -1) && (this.states.length <= paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      int[] arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt);
      long[] arrayOfLong = copyDurationsUsWithSpaceForAdCount(this.durationsUs, paramInt);
      return new AdGroup(paramInt, arrayOfInt, (Uri[])Arrays.copyOf(this.uris, paramInt), arrayOfLong);
    }
  }
  
  @CheckResult
  public AdGroup withAdDurationsUs(long[] paramArrayOfLong)
  {
    if ((this.count == -1) || (paramArrayOfLong.length <= this.uris.length)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      long[] arrayOfLong = paramArrayOfLong;
      if (paramArrayOfLong.length < this.uris.length) {
        arrayOfLong = copyDurationsUsWithSpaceForAdCount(paramArrayOfLong, this.uris.length);
      }
      return new AdGroup(this.count, this.states, this.uris, arrayOfLong);
    }
  }
  
  @CheckResult
  public AdGroup withAdState(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    int[] arrayOfInt;
    long[] arrayOfLong;
    if ((this.count == -1) || (paramInt2 < this.count))
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt2 + 1);
      if ((arrayOfInt[paramInt2] != 0) && (arrayOfInt[paramInt2] != 1))
      {
        bool1 = bool2;
        if (arrayOfInt[paramInt2] != paramInt1) {}
      }
      else
      {
        bool1 = true;
      }
      Assertions.checkArgument(bool1);
      if (this.durationsUs.length != arrayOfInt.length) {
        break label131;
      }
      arrayOfLong = this.durationsUs;
      label86:
      if (this.uris.length != arrayOfInt.length) {
        break label146;
      }
    }
    label131:
    label146:
    for (Uri[] arrayOfUri = this.uris;; arrayOfUri = (Uri[])Arrays.copyOf(this.uris, arrayOfInt.length))
    {
      arrayOfInt[paramInt2] = paramInt1;
      return new AdGroup(this.count, arrayOfInt, arrayOfUri, arrayOfLong);
      bool1 = false;
      break;
      arrayOfLong = copyDurationsUsWithSpaceForAdCount(this.durationsUs, arrayOfInt.length);
      break label86;
    }
  }
  
  @CheckResult
  public AdGroup withAdUri(Uri paramUri, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    int[] arrayOfInt;
    if ((this.count == -1) || (paramInt < this.count))
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt + 1);
      bool1 = bool2;
      if (arrayOfInt[paramInt] == 0) {
        bool1 = true;
      }
      Assertions.checkArgument(bool1);
      if (this.durationsUs.length != arrayOfInt.length) {
        break label118;
      }
    }
    label118:
    for (long[] arrayOfLong = this.durationsUs;; arrayOfLong = copyDurationsUsWithSpaceForAdCount(this.durationsUs, arrayOfInt.length))
    {
      Uri[] arrayOfUri = (Uri[])Arrays.copyOf(this.uris, arrayOfInt.length);
      arrayOfUri[paramInt] = paramUri;
      arrayOfInt[paramInt] = 1;
      return new AdGroup(this.count, arrayOfInt, arrayOfUri, arrayOfLong);
      bool1 = false;
      break;
    }
  }
  
  @CheckResult
  public AdGroup withAllAdsSkipped()
  {
    if (this.count == -1) {
      return new AdGroup(0, new int[0], new Uri[0], new long[0]);
    }
    int j = this.states.length;
    int[] arrayOfInt = Arrays.copyOf(this.states, j);
    int i = 0;
    while (i < j)
    {
      if ((arrayOfInt[i] == 1) || (arrayOfInt[i] == 0)) {
        arrayOfInt[i] = 2;
      }
      i += 1;
    }
    return new AdGroup(j, arrayOfInt, this.uris, this.durationsUs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup
 * JD-Core Version:    0.7.0.1
 */