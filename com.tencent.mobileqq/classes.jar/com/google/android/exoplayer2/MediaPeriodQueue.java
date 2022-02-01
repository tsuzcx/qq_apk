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
    if (((MediaPeriodInfo)localObject1).isLastInTimelinePeriod)
    {
      i = this.timeline.getNextPeriodIndex(((MediaPeriodInfo)localObject1).id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      if (i == -1) {
        return null;
      }
      j = this.timeline.getPeriod(i, this.period, true).windowIndex;
      Object localObject2 = this.period.uid;
      long l1 = ((MediaPeriodInfo)localObject1).id.windowSequenceNumber;
      long l2;
      if (this.timeline.getWindow(j, this.window).firstPeriodIndex == i)
      {
        l1 = paramMediaPeriodHolder.getRendererOffset();
        l2 = ((MediaPeriodInfo)localObject1).durationUs;
        localObject1 = this.timeline.getPeriodPosition(this.window, this.period, j, -9223372036854775807L, Math.max(0L, l1 + l2 - paramLong));
        if (localObject1 == null) {
          return null;
        }
        i = ((Integer)((Pair)localObject1).first).intValue();
        l2 = ((Long)((Pair)localObject1).second).longValue();
        if ((paramMediaPeriodHolder.next != null) && (paramMediaPeriodHolder.next.uid.equals(localObject2)))
        {
          paramLong = paramMediaPeriodHolder.next.info.id.windowSequenceNumber;
          l1 = paramLong;
        }
      }
      for (paramLong = l2;; paramLong = 0L)
      {
        return getMediaPeriodInfo(resolveMediaPeriodIdForAds(i, paramLong, l1), paramLong, paramLong);
        paramLong = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = (1L + paramLong);
        break;
      }
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
      int k = this.period.getNextAdIndexToPlay(i, paramMediaPeriodHolder.adIndexInAdGroup);
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
    if ((this.period.getAdGroupTimeUs(i) != -9223372036854775808L) || (this.period.hasPlayedAdGroup(i))) {
      return null;
    }
    int j = this.period.getFirstAdIndexToPlay(i);
    if (!this.period.isAdAvailable(i, j)) {
      return null;
    }
    paramLong = this.period.getDurationUs();
    return getMediaPeriodInfoForAd(paramMediaPeriodHolder.periodIndex, i, j, paramLong, paramMediaPeriodHolder.windowSequenceNumber);
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
    if (paramInt3 == this.period.getFirstAdIndexToPlay(paramInt2)) {}
    for (paramLong2 = this.period.getAdResumePositionUs();; paramLong2 = 0L) {
      return new MediaPeriodInfo(localMediaPeriodId, paramLong2, -9223372036854775808L, paramLong1, l, bool1, bool2);
    }
  }
  
  private MediaPeriodInfo getMediaPeriodInfoForContent(int paramInt, long paramLong1, long paramLong2)
  {
    MediaSource.MediaPeriodId localMediaPeriodId = new MediaSource.MediaPeriodId(paramInt, paramLong2);
    this.timeline.getPeriod(localMediaPeriodId.periodIndex, this.period);
    paramInt = this.period.getAdGroupIndexAfterPositionUs(paramLong1);
    boolean bool1;
    boolean bool2;
    if (paramInt == -1)
    {
      paramLong2 = -9223372036854775808L;
      bool1 = isLastInPeriod(localMediaPeriodId, paramLong2);
      bool2 = isLastInTimeline(localMediaPeriodId, bool1);
      if (paramLong2 != -9223372036854775808L) {
        break label121;
      }
    }
    label121:
    for (long l = this.period.getDurationUs();; l = paramLong2)
    {
      return new MediaPeriodInfo(localMediaPeriodId, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2);
      paramLong2 = this.period.getAdGroupTimeUs(paramInt);
      break;
    }
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
      return new MediaPeriodInfo(paramMediaPeriodId, l3, l2, paramMediaPeriodInfo.contentPositionUs, l1, bool1, bool2);
      if (l2 == -9223372036854775808L) {
        l1 = this.period.getDurationUs();
      } else {
        l1 = l2;
      }
    }
  }
  
  private boolean isLastInPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    boolean bool2 = false;
    int i = this.timeline.getPeriod(paramMediaPeriodId.periodIndex, this.period).getAdGroupCount();
    if (i == 0) {}
    int j;
    boolean bool3;
    do
    {
      return true;
      j = i - 1;
      bool3 = paramMediaPeriodId.isAd();
      if (this.period.getAdGroupTimeUs(j) == -9223372036854775808L) {
        break;
      }
    } while ((!bool3) && (paramLong == -9223372036854775808L));
    return false;
    int k = this.period.getAdCountInAdGroup(j);
    if (k == -1) {
      return false;
    }
    if ((bool3) && (paramMediaPeriodId.adGroupIndex == j) && (paramMediaPeriodId.adIndexInAdGroup == k - 1)) {}
    for (i = 1;; i = 0)
    {
      boolean bool1;
      if (i == 0)
      {
        bool1 = bool2;
        if (!bool3)
        {
          bool1 = bool2;
          if (this.period.getFirstAdIndexToPlay(j) != k) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
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
    MediaPeriodHolder localMediaPeriodHolder = getFrontPeriod();
    if (localMediaPeriodHolder == null)
    {
      return true;
      localMediaPeriodHolder = localMediaPeriodHolder.next;
    }
    for (;;)
    {
      int i = this.timeline.getNextPeriodIndex(localMediaPeriodHolder.info.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      while ((localMediaPeriodHolder.next != null) && (!localMediaPeriodHolder.info.isLastInTimelinePeriod)) {
        localMediaPeriodHolder = localMediaPeriodHolder.next;
      }
      if ((i != -1) && (localMediaPeriodHolder.next != null) && (localMediaPeriodHolder.next.info.id.periodIndex == i)) {
        break;
      }
      boolean bool = removeAfter(localMediaPeriodHolder);
      localMediaPeriodHolder.info = getUpdatedMediaPeriodInfo(localMediaPeriodHolder.info, localMediaPeriodHolder.info.id);
      if ((!bool) || (!hasPlayingPeriod())) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public MediaPeriodHolder advancePlayingPeriod()
  {
    if (this.playing != null)
    {
      if (this.playing == this.reading) {
        this.reading = this.playing.next;
      }
      this.playing.release();
      this.playing = this.playing.next;
      this.length -= 1;
      if (this.length == 0) {
        this.loading = null;
      }
    }
    for (;;)
    {
      return this.playing;
      this.playing = this.loading;
      this.reading = this.loading;
    }
  }
  
  public MediaPeriodHolder advanceReadingPeriod()
  {
    if ((this.reading != null) && (this.reading.next != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.reading = this.reading.next;
      return this.reading;
    }
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
    if (this.loading == null) {}
    for (paramLong = paramMediaPeriodInfo.startPositionUs + paramLong;; paramLong = this.loading.info.durationUs + paramLong)
    {
      paramArrayOfRendererCapabilities = new MediaPeriodHolder(paramArrayOfRendererCapabilities, paramLong, paramTrackSelector, paramAllocator, paramMediaSource, paramObject, paramMediaPeriodInfo);
      if (this.loading != null)
      {
        Assertions.checkState(hasPlayingPeriod());
        this.loading.next = paramArrayOfRendererCapabilities;
      }
      this.loading = paramArrayOfRendererCapabilities;
      this.length += 1;
      return paramArrayOfRendererCapabilities.mediaPeriod;
      paramLong = this.loading.getRendererOffset();
    }
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
    if (this.loading == null) {
      return getFirstMediaPeriodInfo(paramPlaybackInfo);
    }
    return getFollowingMediaPeriodInfo(this.loading, paramLong);
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
    return (this.loading != null) && (this.loading.mediaPeriod == paramMediaPeriod);
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    if (this.loading != null) {
      this.loading.reevaluateBuffer(paramLong);
    }
  }
  
  public boolean removeAfter(MediaPeriodHolder paramMediaPeriodHolder)
  {
    boolean bool2 = false;
    if (paramMediaPeriodHolder != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assertions.checkState(bool1);
      this.loading = paramMediaPeriodHolder;
      bool1 = bool2;
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
    return (this.loading == null) || ((!this.loading.info.isFinal) && (this.loading.isFullyBuffered()) && (this.loading.info.durationUs != -9223372036854775807L) && (this.length < 100));
  }
  
  public boolean updateQueuedPeriods(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    boolean bool2 = true;
    int i = paramMediaPeriodId.periodIndex;
    paramMediaPeriodId = getFrontPeriod();
    MediaSource.MediaPeriodId localMediaPeriodId = null;
    boolean bool1;
    Object localObject;
    for (;;)
    {
      bool1 = bool2;
      if (paramMediaPeriodId == null) {
        break label149;
      }
      if (localMediaPeriodId != null) {
        break;
      }
      paramMediaPeriodId.info = getUpdatedMediaPeriodInfo(paramMediaPeriodId.info, i);
      int j = i;
      if (paramMediaPeriodId.info.isLastInTimelinePeriod) {
        j = this.timeline.getNextPeriodIndex(i, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      }
      localObject = paramMediaPeriodId.next;
      localMediaPeriodId = paramMediaPeriodId;
      i = j;
      paramMediaPeriodId = (MediaSource.MediaPeriodId)localObject;
    }
    if ((i == -1) || (!paramMediaPeriodId.uid.equals(this.timeline.getPeriod(i, this.period, true).uid))) {
      if (!removeAfter(localMediaPeriodId)) {
        bool1 = true;
      }
    }
    label149:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        localObject = getFollowingMediaPeriodInfo(localMediaPeriodId, paramLong);
        if (localObject != null) {
          break;
        }
        bool1 = bool2;
      } while (!removeAfter(localMediaPeriodId));
      return false;
      paramMediaPeriodId.info = getUpdatedMediaPeriodInfo(paramMediaPeriodId.info, i);
      if (canKeepMediaPeriodHolder(paramMediaPeriodId, (MediaPeriodInfo)localObject)) {
        break;
      }
      bool1 = bool2;
    } while (!removeAfter(localMediaPeriodId));
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.MediaPeriodQueue
 * JD-Core Version:    0.7.0.1
 */