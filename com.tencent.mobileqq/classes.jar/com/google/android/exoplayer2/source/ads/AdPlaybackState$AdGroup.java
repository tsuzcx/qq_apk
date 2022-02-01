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
    boolean bool;
    if (paramArrayOfInt.length == paramArrayOfUri.length) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.count = paramInt;
    this.states = paramArrayOfInt;
    this.uris = paramArrayOfUri;
    this.durationsUs = paramArrayOfLong;
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
      int[] arrayOfInt = this.states;
      if ((paramInt >= arrayOfInt.length) || (arrayOfInt[paramInt] == 0)) {
        break;
      }
      if (arrayOfInt[paramInt] == 1) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public boolean hasUnplayedAds()
  {
    return (this.count == -1) || (getFirstAdIndexToPlay() < this.count);
  }
  
  @CheckResult
  public AdGroup withAdCount(int paramInt)
  {
    boolean bool;
    if ((this.count == -1) && (this.states.length <= paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    int[] arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt);
    long[] arrayOfLong = copyDurationsUsWithSpaceForAdCount(this.durationsUs, paramInt);
    return new AdGroup(paramInt, arrayOfInt, (Uri[])Arrays.copyOf(this.uris, paramInt), arrayOfLong);
  }
  
  @CheckResult
  public AdGroup withAdDurationsUs(long[] paramArrayOfLong)
  {
    boolean bool;
    if ((this.count != -1) && (paramArrayOfLong.length > this.uris.length)) {
      bool = false;
    } else {
      bool = true;
    }
    Assertions.checkArgument(bool);
    int i = paramArrayOfLong.length;
    Uri[] arrayOfUri = this.uris;
    long[] arrayOfLong = paramArrayOfLong;
    if (i < arrayOfUri.length) {
      arrayOfLong = copyDurationsUsWithSpaceForAdCount(paramArrayOfLong, arrayOfUri.length);
    }
    return new AdGroup(this.count, this.states, this.uris, arrayOfLong);
  }
  
  @CheckResult
  public AdGroup withAdState(int paramInt1, int paramInt2)
  {
    int i = this.count;
    boolean bool2 = false;
    boolean bool1;
    if ((i != -1) && (paramInt2 >= i)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Assertions.checkArgument(bool1);
    int[] arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt2 + 1);
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
    long[] arrayOfLong = this.durationsUs;
    if (arrayOfLong.length != arrayOfInt.length) {
      arrayOfLong = copyDurationsUsWithSpaceForAdCount(arrayOfLong, arrayOfInt.length);
    }
    Uri[] arrayOfUri = this.uris;
    if (arrayOfUri.length != arrayOfInt.length) {
      arrayOfUri = (Uri[])Arrays.copyOf(arrayOfUri, arrayOfInt.length);
    }
    arrayOfInt[paramInt2] = paramInt1;
    return new AdGroup(this.count, arrayOfInt, arrayOfUri, arrayOfLong);
  }
  
  @CheckResult
  public AdGroup withAdUri(Uri paramUri, int paramInt)
  {
    int i = this.count;
    boolean bool2 = false;
    if ((i != -1) && (paramInt >= i)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Assertions.checkArgument(bool1);
    int[] arrayOfInt = copyStatesWithSpaceForAdCount(this.states, paramInt + 1);
    boolean bool1 = bool2;
    if (arrayOfInt[paramInt] == 0) {
      bool1 = true;
    }
    Assertions.checkArgument(bool1);
    long[] arrayOfLong = this.durationsUs;
    if (arrayOfLong.length != arrayOfInt.length) {
      arrayOfLong = copyDurationsUsWithSpaceForAdCount(arrayOfLong, arrayOfInt.length);
    }
    Uri[] arrayOfUri = (Uri[])Arrays.copyOf(this.uris, arrayOfInt.length);
    arrayOfUri[paramInt] = paramUri;
    arrayOfInt[paramInt] = 1;
    return new AdGroup(this.count, arrayOfInt, arrayOfUri, arrayOfLong);
  }
  
  @CheckResult
  public AdGroup withAllAdsSkipped()
  {
    int j = this.count;
    int i = 0;
    if (j == -1) {
      return new AdGroup(0, new int[0], new Uri[0], new long[0]);
    }
    int[] arrayOfInt = this.states;
    j = arrayOfInt.length;
    arrayOfInt = Arrays.copyOf(arrayOfInt, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup
 * JD-Core Version:    0.7.0.1
 */