package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

final class MediaPeriodQueue
{
  private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
  private int length;
  private MediaPeriodHolder loading;
  private long nextWindowSequenceNumber;
  private final Timeline.Period period = new Timeline.Period();
  private MediaPeriodHolder playing;
  private MediaPeriodHolder reading;
  private int repeatMode;
  private boolean shuffleModeEnabled;
  private Timeline timeline;
  private final Timeline.Window window = new Timeline.Window();
  
  private boolean canKeepMediaPeriodHolder(MediaPeriodHolder paramMediaPeriodHolder, MediaPeriodInfo paramMediaPeriodInfo)
  {
    paramMediaPeriodHolder = paramMediaPeriodHolder.info;
    return (paramMediaPeriodHolder.startPositionUs == paramMediaPeriodInfo.startPositionUs) && (paramMediaPeriodHolder.endPositionUs == paramMediaPeriodInfo.endPositionUs) && (paramMediaPeriodHolder.id.equals(paramMediaPeriodInfo.id));
  }
  
  private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo paramPlaybackInfo)
  {
    return getMediaPeriodInfo(paramPlaybackInfo.periodId, paramPlaybackInfo.contentPositionUs, paramPlaybackInfo.startPositionUs);
  }
  
  @Nullable
  private MediaPeriodInfo getFollowingMediaPeriodInfo(MediaPeriodHolder paramMediaPeriodHolder, long paramLong)
  {
    Object localObject1 = paramMediaPeriodHolder.info;
    int j;
    int k;
    if (((MediaPeriodInfo)localObject1).isLastInTimelinePeriod)
    {
      i = this.timeline.getNextPeriodIndex(((MediaPeriodInfo)localObject1).id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      if (i == -1) {
        return null;
      }
      j = this.timeline.getPeriod(i, this.period, true).windowIndex;
      Object localObject2 = this.period.uid;
      long l2 = ((MediaPeriodInfo)localObject1).id.windowSequenceNumber;
      k = this.timeline.getWindow(j, this.window).firstPeriodIndex;
      long l1 = 0L;
      if (k == i)
      {
        l1 = paramMediaPeriodHolder.getRendererOffset();
        l2 = ((MediaPeriodInfo)localObject1).durationUs;
        localObject1 = this.timeline.getPeriodPosition(this.window, this.period, j, -9223372036854775807L, Math.max(0L, l1 + l2 - paramLong));
        if (localObject1 == null) {
          return null;
        }
        i = ((Integer)((Pair)localObject1).first).intValue();
        l1 = ((Long)((Pair)localObject1).second).longValue();
        if ((paramMediaPeriodHolder.next != null) && (paramMediaPeriodHolder.next.uid.equals(localObject2)))
        {
          paramLong = paramMediaPeriodHolder.next.info.id.windowSequenceNumber;
        }
        else
        {
          paramLong = this.nextWindowSequenceNumber;
          this.nextWindowSequenceNumber = (1L + paramLong);
        }
      }
      else
      {
        paramLong = l2;
      }
      return getMediaPeriodInfo(resolveMediaPeriodIdForAds(i, l1, paramLong), l1, l1);
    }
    paramMediaPeriodHolder = ((MediaPeriodInfo)localObject1).id;
    this.timeline.getPeriod(paramMediaPeriodHolder.periodIndex, this.period);
    if (paramMediaPeriodHolder.isAd())
    {
      i = paramMediaPeriodHolder.adGroupIndex;
      j = this.period.getAdCountInAdGroup(i);
      if (j == -1) {
        return null;
      }
      k = this.period.getNextAdIndexToPlay(i, paramMediaPeriodHolder.adIndexInAdGroup);
      if (k < j)
      {
        if (!this.period.isAdAvailable(i, k)) {
          return null;
        }
        return getMediaPeriodInfoForAd(paramMediaPeriodHolder.periodIndex, i, k, ((MediaPeriodInfo)localObject1).contentPositionUs, paramMediaPeriodHolder.windowSequenceNumber);
      }
      return getMediaPeriodInfoForContent(paramMediaPeriodHolder.periodIndex, ((MediaPeriodInfo)localObject1).contentPositionUs, paramMediaPeriodHolder.windowSequenceNumber);
    }
    if (((MediaPeriodInfo)localObject1).endPositionUs != -9223372036854775808L)
    {
      i = this.period.getAdGroupIndexForPositionUs(((MediaPeriodInfo)localObject1).endPositionUs);
      if (i == -1) {
        return getMediaPeriodInfoForContent(paramMediaPeriodHolder.periodIndex, ((MediaPeriodInfo)localObject1).endPositionUs, paramMediaPeriodHolder.windowSequenceNumber);
      }
      j = this.period.getFirstAdIndexToPlay(i);
      if (!this.period.isAdAvailable(i, j)) {
        return null;
      }
      return getMediaPeriodInfoForAd(paramMediaPeriodHolder.periodIndex, i, j, ((MediaPeriodInfo)localObject1).endPositionUs, paramMediaPeriodHolder.windowSequenceNumber);
    }
    int i = this.period.getAdGroupCount();
    if (i == 0) {
      return null;
    }
    i -= 1;
    if (this.period.getAdGroupTimeUs(i) == -9223372036854775808L)
    {
      if (this.period.hasPlayedAdGroup(i)) {
        return null;
      }
      j = this.period.getFirstAdIndexToPlay(i);
      if (!this.period.isAdAvailable(i, j)) {
        return null;
      }
      paramLong = this.period.getDurationUs();
      return getMediaPeriodInfoForAd(paramMediaPeriodHolder.periodIndex, i, j, paramLong, paramMediaPeriodHolder.windowSequenceNumber);
    }
    return null;
  }
  
  private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong1, long paramLong2)
  {
    this.timeline.getPeriod(paramMediaPeriodId.periodIndex, this.period);
    if (paramMediaPeriodId.isAd())
    {
      if (!this.period.isAdAvailable(paramMediaPeriodId.adGroupIndex, paramMediaPeriodId.adIndexInAdGroup)) {
        return null;
      }
      return getMediaPeriodInfoForAd(paramMediaPeriodId.periodIndex, paramMediaPeriodId.adGroupIndex, paramMediaPeriodId.adIndexInAdGroup, paramLong1, paramMediaPeriodId.windowSequenceNumber);
    }
    return getMediaPeriodInfoForContent(paramMediaPeriodId.periodIndex, paramLong2, paramMediaPeriodId.windowSequenceNumber);
  }
  
  private MediaPeriodInfo getMediaPeriodInfoForAd(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    MediaSource.MediaPeriodId localMediaPeriodId = new MediaSource.MediaPeriodId(paramInt1, paramInt2, paramInt3, paramLong2);
    boolean bool1 = isLastInPeriod(localMediaPeriodId, -9223372036854775808L);
    boolean bool2 = isLastInTimeline(localMediaPeriodId, bool1);
    long l = this.timeline.getPeriod(localMediaPeriodId.periodIndex, this.period).getAdDurationUs(localMediaPeriodId.adGroupIndex, localMediaPeriodId.adIndexInAdGroup);
    if (paramInt3 == this.period.getFirstAdIndexToPlay(paramInt2)) {
      paramLong2 = this.period.getAdResumePositionUs();
    } else {
      paramLong2 = 0L;
    }
    return new MediaPeriodInfo(localMediaPeriodId, paramLong2, -9223372036854775808L, paramLong1, l, bool1, bool2);
  }
  
  private MediaPeriodInfo getMediaPeriodInfoForContent(int paramInt, long paramLong1, long paramLong2)
  {
    MediaSource.MediaPeriodId localMediaPeriodId = new MediaSource.MediaPeriodId(paramInt, paramLong2);
    this.timeline.getPeriod(localMediaPeriodId.periodIndex, this.period);
    paramInt = this.period.getAdGroupIndexAfterPositionUs(paramLong1);
    if (paramInt == -1) {
      paramLong2 = -9223372036854775808L;
    } else {
      paramLong2 = this.period.getAdGroupTimeUs(paramInt);
    }
    boolean bool1 = isLastInPeriod(localMediaPeriodId, paramLong2);
    boolean bool2 = isLastInTimeline(localMediaPeriodId, bool1);
    long l;
    if (paramLong2 == -9223372036854775808L) {
      l = this.period.getDurationUs();
    } else {
      l = paramLong2;
    }
    return new MediaPeriodInfo(localMediaPeriodId, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2);
  }
  
  private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo paramMediaPeriodInfo, MediaSource.MediaPeriodId paramMediaPeriodId)
  {
    long l3 = paramMediaPeriodInfo.startPositionUs;
    long l2 = paramMediaPeriodInfo.endPositionUs;
    boolean bool1 = isLastInPeriod(paramMediaPeriodId, l2);
    boolean bool2 = isLastInTimeline(paramMediaPeriodId, bool1);
    this.timeline.getPeriod(paramMediaPeriodId.periodIndex, this.period);
    long l1;
    if (paramMediaPeriodId.isAd()) {
      l1 = this.period.getAdDurationUs(paramMediaPeriodId.adGroupIndex, paramMediaPeriodId.adIndexInAdGroup);
    }
    for (;;)
    {
      break;
      if (l2 == -9223372036854775808L) {
        l1 = this.period.getDurationUs();
      } else {
        l1 = l2;
      }
    }
    return new MediaPeriodInfo(paramMediaPeriodId, l3, l2, paramMediaPeriodInfo.contentPositionUs, l1, bool1, bool2);
  }
  
  private boolean isLastInPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    int i = this.timeline.getPeriod(paramMediaPeriodId.periodIndex, this.period).getAdGroupCount();
    boolean bool1 = true;
    if (i == 0) {
      return true;
    }
    int j = i - 1;
    boolean bool2 = paramMediaPeriodId.isAd();
    if (this.period.getAdGroupTimeUs(j) != -9223372036854775808L) {
      return (!bool2) && (paramLong == -9223372036854775808L);
    }
    int k = this.period.getAdCountInAdGroup(j);
    if (k == -1) {
      return false;
    }
    if ((bool2) && (paramMediaPeriodId.adGroupIndex == j) && (paramMediaPeriodId.adIndexInAdGroup == k - 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if ((!bool2) && (this.period.getFirstAdIndexToPlay(j) == k)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean isLastInTimeline(MediaSource.MediaPeriodId paramMediaPeriodId, boolean paramBoolean)
  {
    int i = this.timeline.getPeriod(paramMediaPeriodId.periodIndex, this.period).windowIndex;
    return (!this.timeline.getWindow(i, this.window).isDynamic) && (this.timeline.isLastPeriod(paramMediaPeriodId.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled)) && (paramBoolean);
  }
  
  private MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int paramInt, long paramLong1, long paramLong2)
  {
    this.timeline.getPeriod(paramInt, this.period);
    int i = this.period.getAdGroupIndexForPositionUs(paramLong1);
    if (i == -1) {
      return new MediaSource.MediaPeriodId(paramInt, paramLong2);
    }
    return new MediaSource.MediaPeriodId(paramInt, i, this.period.getFirstAdIndexToPlay(i), paramLong2);
  }
  
  private long resolvePeriodIndexToWindowSequenceNumber(int paramInt)
  {
    Object localObject = this.timeline.getPeriod(paramInt, this.period, true).uid;
    for (MediaPeriodHolder localMediaPeriodHolder = getFrontPeriod(); localMediaPeriodHolder != null; localMediaPeriodHolder = localMediaPeriodHolder.next) {
      if (localMediaPeriodHolder.uid.equals(localObject)) {
        return localMediaPeriodHolder.info.id.windowSequenceNumber;
      }
    }
    paramInt = this.period.windowIndex;
    for (localMediaPeriodHolder = getFrontPeriod(); localMediaPeriodHolder != null; localMediaPeriodHolder = localMediaPeriodHolder.next)
    {
      int i = this.timeline.getIndexOfPeriod(localMediaPeriodHolder.uid);
      if ((i != -1) && (this.timeline.getPeriod(i, this.period).windowIndex == paramInt)) {
        return localMediaPeriodHolder.info.id.windowSequenceNumber;
      }
    }
    long l = this.nextWindowSequenceNumber;
    this.nextWindowSequenceNumber = (1L + l);
    return l;
  }
  
  private boolean updateForPlaybackModeChange()
  {
    MediaPeriodHolder localMediaPeriodHolder2 = getFrontPeriod();
    boolean bool1 = true;
    MediaPeriodHolder localMediaPeriodHolder1 = localMediaPeriodHolder2;
    if (localMediaPeriodHolder2 == null) {
      return true;
    }
    for (;;)
    {
      int i = this.timeline.getNextPeriodIndex(localMediaPeriodHolder1.info.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      while ((localMediaPeriodHolder1.next != null) && (!localMediaPeriodHolder1.info.isLastInTimelinePeriod)) {
        localMediaPeriodHolder1 = localMediaPeriodHolder1.next;
      }
      if ((i == -1) || (localMediaPeriodHolder1.next == null) || (localMediaPeriodHolder1.next.info.id.periodIndex != i)) {
        break;
      }
      localMediaPeriodHolder1 = localMediaPeriodHolder1.next;
    }
    boolean bool2 = removeAfter(localMediaPeriodHolder1);
    localMediaPeriodHolder1.info = getUpdatedMediaPeriodInfo(localMediaPeriodHolder1.info, localMediaPeriodHolder1.info.id);
    if (bool2)
    {
      if (!hasPlayingPeriod()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public MediaPeriodHolder advancePlayingPeriod()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.playing;
    if (localMediaPeriodHolder != null)
    {
      if (localMediaPeriodHolder == this.reading) {
        this.reading = localMediaPeriodHolder.next;
      }
      this.playing.release();
      this.playing = this.playing.next;
      this.length -= 1;
      if (this.length == 0) {
        this.loading = null;
      }
    }
    else
    {
      localMediaPeriodHolder = this.loading;
      this.playing = localMediaPeriodHolder;
      this.reading = localMediaPeriodHolder;
    }
    return this.playing;
  }
  
  public MediaPeriodHolder advanceReadingPeriod()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.reading;
    boolean bool;
    if ((localMediaPeriodHolder != null) && (localMediaPeriodHolder.next != null)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.reading = this.reading.next;
    return this.reading;
  }
  
  public void clear()
  {
    MediaPeriodHolder localMediaPeriodHolder = getFrontPeriod();
    if (localMediaPeriodHolder != null)
    {
      localMediaPeriodHolder.release();
      removeAfter(localMediaPeriodHolder);
    }
    this.playing = null;
    this.loading = null;
    this.reading = null;
    this.length = 0;
  }
  
  public MediaPeriod enqueueNextMediaPeriod(RendererCapabilities[] paramArrayOfRendererCapabilities, long paramLong, TrackSelector paramTrackSelector, Allocator paramAllocator, MediaSource paramMediaSource, Object paramObject, MediaPeriodInfo paramMediaPeriodInfo)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.loading;
    if (localMediaPeriodHolder == null) {
      paramLong = paramMediaPeriodInfo.startPositionUs + paramLong;
    } else {
      paramLong = localMediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs;
    }
    paramArrayOfRendererCapabilities = new MediaPeriodHolder(paramArrayOfRendererCapabilities, paramLong, paramTrackSelector, paramAllocator, paramMediaSource, paramObject, paramMediaPeriodInfo);
    if (this.loading != null)
    {
      Assertions.checkState(hasPlayingPeriod());
      this.loading.next = paramArrayOfRendererCapabilities;
    }
    this.loading = paramArrayOfRendererCapabilities;
    this.length += 1;
    return paramArrayOfRendererCapabilities.mediaPeriod;
  }
  
  public MediaPeriodHolder getFrontPeriod()
  {
    if (hasPlayingPeriod()) {
      return this.playing;
    }
    return this.loading;
  }
  
  public MediaPeriodHolder getLoadingPeriod()
  {
    return this.loading;
  }
  
  @Nullable
  public MediaPeriodInfo getNextMediaPeriodInfo(long paramLong, PlaybackInfo paramPlaybackInfo)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.loading;
    if (localMediaPeriodHolder == null) {
      return getFirstMediaPeriodInfo(paramPlaybackInfo);
    }
    return getFollowingMediaPeriodInfo(localMediaPeriodHolder, paramLong);
  }
  
  public MediaPeriodHolder getPlayingPeriod()
  {
    return this.playing;
  }
  
  public MediaPeriodHolder getReadingPeriod()
  {
    return this.reading;
  }
  
  public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo paramMediaPeriodInfo, int paramInt)
  {
    return getUpdatedMediaPeriodInfo(paramMediaPeriodInfo, paramMediaPeriodInfo.id.copyWithPeriodIndex(paramInt));
  }
  
  public TrackSelectorResult handleLoadingPeriodPrepared(float paramFloat)
  {
    return this.loading.handlePrepared(paramFloat);
  }
  
  public boolean hasPlayingPeriod()
  {
    return this.playing != null;
  }
  
  public boolean isLoading(MediaPeriod paramMediaPeriod)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.loading;
    return (localMediaPeriodHolder != null) && (localMediaPeriodHolder.mediaPeriod == paramMediaPeriod);
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.loading;
    if (localMediaPeriodHolder != null) {
      localMediaPeriodHolder.reevaluateBuffer(paramLong);
    }
  }
  
  public boolean removeAfter(MediaPeriodHolder paramMediaPeriodHolder)
  {
    boolean bool2 = false;
    if (paramMediaPeriodHolder != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1);
    this.loading = paramMediaPeriodHolder;
    boolean bool1 = bool2;
    while (paramMediaPeriodHolder.next != null)
    {
      paramMediaPeriodHolder = paramMediaPeriodHolder.next;
      if (paramMediaPeriodHolder == this.reading)
      {
        this.reading = this.playing;
        bool1 = true;
      }
      paramMediaPeriodHolder.release();
      this.length -= 1;
    }
    this.loading.next = null;
    return bool1;
  }
  
  public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int paramInt, long paramLong)
  {
    return resolveMediaPeriodIdForAds(paramInt, paramLong, resolvePeriodIndexToWindowSequenceNumber(paramInt));
  }
  
  public void setTimeline(Timeline paramTimeline)
  {
    this.timeline = paramTimeline;
  }
  
  public boolean shouldLoadNextMediaPeriod()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.loading;
    return (localMediaPeriodHolder == null) || ((!localMediaPeriodHolder.info.isFinal) && (this.loading.isFullyBuffered()) && (this.loading.info.durationUs != -9223372036854775807L) && (this.length < 100));
  }
  
  public boolean updateQueuedPeriods(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    int i = paramMediaPeriodId.periodIndex;
    paramMediaPeriodId = getFrontPeriod();
    Object localObject1 = null;
    while (paramMediaPeriodId != null)
    {
      if (localObject1 == null)
      {
        paramMediaPeriodId.info = getUpdatedMediaPeriodInfo(paramMediaPeriodId.info, i);
      }
      else
      {
        if ((i == -1) || (!paramMediaPeriodId.uid.equals(this.timeline.getPeriod(i, this.period, true).uid))) {
          break label192;
        }
        localObject2 = getFollowingMediaPeriodInfo((MediaPeriodHolder)localObject1, paramLong);
        if (localObject2 == null) {
          return removeAfter((MediaPeriodHolder)localObject1) ^ true;
        }
        paramMediaPeriodId.info = getUpdatedMediaPeriodInfo(paramMediaPeriodId.info, i);
        if (!canKeepMediaPeriodHolder(paramMediaPeriodId, (MediaPeriodInfo)localObject2)) {
          return removeAfter((MediaPeriodHolder)localObject1) ^ true;
        }
      }
      int j = i;
      if (paramMediaPeriodId.info.isLastInTimelinePeriod) {
        j = this.timeline.getNextPeriodIndex(i, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      }
      Object localObject2 = paramMediaPeriodId.next;
      localObject1 = paramMediaPeriodId;
      paramMediaPeriodId = (MediaSource.MediaPeriodId)localObject2;
      i = j;
      continue;
      label192:
      return removeAfter((MediaPeriodHolder)localObject1) ^ true;
    }
    return true;
  }
  
  public boolean updateRepeatMode(int paramInt)
  {
    this.repeatMode = paramInt;
    return updateForPlaybackModeChange();
  }
  
  public boolean updateShuffleModeEnabled(boolean paramBoolean)
  {
    this.shuffleModeEnabled = paramBoolean;
    return updateForPlaybackModeChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.MediaPeriodQueue
 * JD-Core Version:    0.7.0.1
 */