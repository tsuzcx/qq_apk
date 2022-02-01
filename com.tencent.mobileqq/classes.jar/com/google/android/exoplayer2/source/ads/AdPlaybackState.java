package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.support.annotation.CheckResult;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class AdPlaybackState
{
  public static final int AD_STATE_AVAILABLE = 1;
  public static final int AD_STATE_ERROR = 4;
  public static final int AD_STATE_PLAYED = 3;
  public static final int AD_STATE_SKIPPED = 2;
  public static final int AD_STATE_UNAVAILABLE = 0;
  public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
  public final int adGroupCount;
  public final long[] adGroupTimesUs;
  public final AdPlaybackState.AdGroup[] adGroups;
  public final long adResumePositionUs;
  public final long contentDurationUs;
  
  public AdPlaybackState(long... paramVarArgs)
  {
    int j = paramVarArgs.length;
    this.adGroupCount = j;
    this.adGroupTimesUs = Arrays.copyOf(paramVarArgs, j);
    this.adGroups = new AdPlaybackState.AdGroup[j];
    int i = 0;
    while (i < j)
    {
      this.adGroups[i] = new AdPlaybackState.AdGroup();
      i += 1;
    }
    this.adResumePositionUs = 0L;
    this.contentDurationUs = -9223372036854775807L;
  }
  
  private AdPlaybackState(long[] paramArrayOfLong, AdPlaybackState.AdGroup[] paramArrayOfAdGroup, long paramLong1, long paramLong2)
  {
    this.adGroupCount = paramArrayOfAdGroup.length;
    this.adGroupTimesUs = paramArrayOfLong;
    this.adGroups = paramArrayOfAdGroup;
    this.adResumePositionUs = paramLong1;
    this.contentDurationUs = paramLong2;
  }
  
  public int getAdGroupIndexAfterPositionUs(long paramLong)
  {
    int i = 0;
    while ((i < this.adGroupTimesUs.length) && (this.adGroupTimesUs[i] != -9223372036854775808L) && ((paramLong >= this.adGroupTimesUs[i]) || (!this.adGroups[i].hasUnplayedAds()))) {
      i += 1;
    }
    if (i < this.adGroupTimesUs.length) {
      return i;
    }
    return -1;
  }
  
  public int getAdGroupIndexForPositionUs(long paramLong)
  {
    int i = this.adGroupTimesUs.length - 1;
    while ((i >= 0) && ((this.adGroupTimesUs[i] == -9223372036854775808L) || (this.adGroupTimesUs[i] > paramLong))) {
      i -= 1;
    }
    if ((i >= 0) && (this.adGroups[i].hasUnplayedAds())) {
      return i;
    }
    return -1;
  }
  
  @CheckResult
  public AdPlaybackState withAdCount(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      if (this.adGroups[paramInt1].count != paramInt2) {
        break;
      }
      return this;
    }
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    arrayOfAdGroup[paramInt1] = this.adGroups[paramInt1].withAdCount(paramInt2);
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withAdDurationsUs(long[][] paramArrayOfLong)
  {
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    int i = 0;
    while (i < this.adGroupCount)
    {
      arrayOfAdGroup[i] = arrayOfAdGroup[i].withAdDurationsUs(paramArrayOfLong[i]);
      i += 1;
    }
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withAdLoadError(int paramInt1, int paramInt2)
  {
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    arrayOfAdGroup[paramInt1] = arrayOfAdGroup[paramInt1].withAdState(4, paramInt2);
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withAdResumePositionUs(long paramLong)
  {
    if (this.adResumePositionUs == paramLong) {
      return this;
    }
    return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, paramLong, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withAdUri(int paramInt1, int paramInt2, Uri paramUri)
  {
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    arrayOfAdGroup[paramInt1] = arrayOfAdGroup[paramInt1].withAdUri(paramUri, paramInt2);
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withContentDurationUs(long paramLong)
  {
    if (this.contentDurationUs == paramLong) {
      return this;
    }
    return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, paramLong);
  }
  
  @CheckResult
  public AdPlaybackState withPlayedAd(int paramInt1, int paramInt2)
  {
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    arrayOfAdGroup[paramInt1] = arrayOfAdGroup[paramInt1].withAdState(3, paramInt2);
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
  
  @CheckResult
  public AdPlaybackState withSkippedAdGroup(int paramInt)
  {
    AdPlaybackState.AdGroup[] arrayOfAdGroup = (AdPlaybackState.AdGroup[])Arrays.copyOf(this.adGroups, this.adGroups.length);
    arrayOfAdGroup[paramInt] = arrayOfAdGroup[paramInt].withAllAdsSkipped();
    return new AdPlaybackState(this.adGroupTimesUs, arrayOfAdGroup, this.adResumePositionUs, this.contentDurationUs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdPlaybackState
 * JD-Core Version:    0.7.0.1
 */