package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup;

public final class Timeline$Period
{
  private AdPlaybackState adPlaybackState;
  public long durationUs;
  public Object id;
  private long positionInWindowUs;
  public Object uid;
  public int windowIndex;
  
  public int getAdCountInAdGroup(int paramInt)
  {
    return this.adPlaybackState.adGroups[paramInt].count;
  }
  
  public long getAdDurationUs(int paramInt1, int paramInt2)
  {
    AdPlaybackState.AdGroup localAdGroup = this.adPlaybackState.adGroups[paramInt1];
    if (localAdGroup.count != -1) {
      return localAdGroup.durationsUs[paramInt2];
    }
    return -9223372036854775807L;
  }
  
  public int getAdGroupCount()
  {
    return this.adPlaybackState.adGroupCount;
  }
  
  public int getAdGroupIndexAfterPositionUs(long paramLong)
  {
    return this.adPlaybackState.getAdGroupIndexAfterPositionUs(paramLong);
  }
  
  public int getAdGroupIndexForPositionUs(long paramLong)
  {
    return this.adPlaybackState.getAdGroupIndexForPositionUs(paramLong);
  }
  
  public long getAdGroupTimeUs(int paramInt)
  {
    return this.adPlaybackState.adGroupTimesUs[paramInt];
  }
  
  public long getAdResumePositionUs()
  {
    return this.adPlaybackState.adResumePositionUs;
  }
  
  public long getDurationMs()
  {
    return C.usToMs(this.durationUs);
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public int getFirstAdIndexToPlay(int paramInt)
  {
    return this.adPlaybackState.adGroups[paramInt].getFirstAdIndexToPlay();
  }
  
  public int getNextAdIndexToPlay(int paramInt1, int paramInt2)
  {
    return this.adPlaybackState.adGroups[paramInt1].getNextAdIndexToPlay(paramInt2);
  }
  
  public long getPositionInWindowMs()
  {
    return C.usToMs(this.positionInWindowUs);
  }
  
  public long getPositionInWindowUs()
  {
    return this.positionInWindowUs;
  }
  
  public boolean hasPlayedAdGroup(int paramInt)
  {
    return !this.adPlaybackState.adGroups[paramInt].hasUnplayedAds();
  }
  
  public boolean isAdAvailable(int paramInt1, int paramInt2)
  {
    AdPlaybackState.AdGroup localAdGroup = this.adPlaybackState.adGroups[paramInt1];
    return (localAdGroup.count != -1) && (localAdGroup.states[paramInt2] != 0);
  }
  
  public Period set(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2)
  {
    return set(paramObject1, paramObject2, paramInt, paramLong1, paramLong2, AdPlaybackState.NONE);
  }
  
  public Period set(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2, AdPlaybackState paramAdPlaybackState)
  {
    this.id = paramObject1;
    this.uid = paramObject2;
    this.windowIndex = paramInt;
    this.durationUs = paramLong1;
    this.positionInWindowUs = paramLong2;
    this.adPlaybackState = paramAdPlaybackState;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.Timeline.Period
 * JD-Core Version:    0.7.0.1
 */