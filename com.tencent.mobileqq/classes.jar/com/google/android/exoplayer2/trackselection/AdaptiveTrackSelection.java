package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public class AdaptiveTrackSelection
  extends BaseTrackSelection
{
  public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75F;
  public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75F;
  public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
  public static final int DEFAULT_MAX_INITIAL_BITRATE = 800000;
  public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
  public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
  public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000L;
  private final float bandwidthFraction;
  private final BandwidthMeter bandwidthMeter;
  private final float bufferedFractionToLiveEdgeForQualityIncrease;
  private final Clock clock;
  private long lastBufferEvaluationMs;
  private final long maxDurationForQualityDecreaseUs;
  private final int maxInitialBitrate;
  private final long minDurationForQualityIncreaseUs;
  private final long minDurationToRetainAfterDiscardUs;
  private final long minTimeBetweenBufferReevaluationMs;
  private float playbackSpeed;
  private int reason;
  private int selectedIndex;
  
  public AdaptiveTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, BandwidthMeter paramBandwidthMeter)
  {
    this(paramTrackGroup, paramArrayOfInt, paramBandwidthMeter, 800000, 10000L, 25000L, 25000L, 0.75F, 0.75F, 2000L, Clock.DEFAULT);
  }
  
  public AdaptiveTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, BandwidthMeter paramBandwidthMeter, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, long paramLong4, Clock paramClock)
  {
    super(paramTrackGroup, paramArrayOfInt);
    this.bandwidthMeter = paramBandwidthMeter;
    this.maxInitialBitrate = paramInt;
    this.minDurationForQualityIncreaseUs = (paramLong1 * 1000L);
    this.maxDurationForQualityDecreaseUs = (paramLong2 * 1000L);
    this.minDurationToRetainAfterDiscardUs = (paramLong3 * 1000L);
    this.bandwidthFraction = paramFloat1;
    this.bufferedFractionToLiveEdgeForQualityIncrease = paramFloat2;
    this.minTimeBetweenBufferReevaluationMs = paramLong4;
    this.clock = paramClock;
    this.playbackSpeed = 1.0F;
    this.selectedIndex = determineIdealSelectedIndex(-9223372036854775808L);
    this.reason = 1;
    this.lastBufferEvaluationMs = -9223372036854775807L;
  }
  
  private int determineIdealSelectedIndex(long paramLong)
  {
    long l = this.bandwidthMeter.getBitrateEstimate();
    if (l == -1L) {
      l = this.maxInitialBitrate;
    } else {
      l = ((float)l * this.bandwidthFraction);
    }
    int i = 0;
    int j = 0;
    while (i < this.length)
    {
      if ((paramLong == -9223372036854775808L) || (!isBlacklisted(i, paramLong)))
      {
        if (Math.round(getFormat(i).bitrate * this.playbackSpeed) <= l) {
          return i;
        }
        j = i;
      }
      i += 1;
    }
    return j;
  }
  
  private long minDurationForQualityIncreaseUs(long paramLong)
  {
    int i;
    if ((paramLong != -9223372036854775807L) && (paramLong <= this.minDurationForQualityIncreaseUs)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return ((float)paramLong * this.bufferedFractionToLiveEdgeForQualityIncrease);
    }
    return this.minDurationForQualityIncreaseUs;
  }
  
  public void enable()
  {
    this.lastBufferEvaluationMs = -9223372036854775807L;
  }
  
  public int evaluateQueueSize(long paramLong, List<? extends MediaChunk> paramList)
  {
    long l1 = this.clock.elapsedRealtime();
    long l2 = this.lastBufferEvaluationMs;
    if ((l2 != -9223372036854775807L) && (l1 - l2 < this.minTimeBetweenBufferReevaluationMs)) {
      return paramList.size();
    }
    this.lastBufferEvaluationMs = l1;
    boolean bool = paramList.isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    int j = paramList.size();
    if (Util.getPlayoutDurationForMediaDuration(((MediaChunk)paramList.get(j - 1)).startTimeUs - paramLong, this.playbackSpeed) < this.minDurationToRetainAfterDiscardUs) {
      return j;
    }
    Format localFormat1 = getFormat(determineIdealSelectedIndex(l1));
    while (i < j)
    {
      MediaChunk localMediaChunk = (MediaChunk)paramList.get(i);
      Format localFormat2 = localMediaChunk.trackFormat;
      if ((Util.getPlayoutDurationForMediaDuration(localMediaChunk.startTimeUs - paramLong, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs) && (localFormat2.bitrate < localFormat1.bitrate) && (localFormat2.height != -1) && (localFormat2.height < 720) && (localFormat2.width != -1) && (localFormat2.width < 1280) && (localFormat2.height < localFormat1.height)) {
        return i;
      }
      i += 1;
    }
    return j;
  }
  
  public int getSelectedIndex()
  {
    return this.selectedIndex;
  }
  
  public Object getSelectionData()
  {
    return null;
  }
  
  public int getSelectionReason()
  {
    return this.reason;
  }
  
  public void onPlaybackSpeed(float paramFloat)
  {
    this.playbackSpeed = paramFloat;
  }
  
  public void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = this.clock.elapsedRealtime();
    int i = this.selectedIndex;
    this.selectedIndex = determineIdealSelectedIndex(paramLong1);
    if (this.selectedIndex == i) {
      return;
    }
    if (!isBlacklisted(i, paramLong1))
    {
      Format localFormat1 = getFormat(i);
      Format localFormat2 = getFormat(this.selectedIndex);
      if ((localFormat2.bitrate > localFormat1.bitrate) && (paramLong2 < minDurationForQualityIncreaseUs(paramLong3))) {
        this.selectedIndex = i;
      } else if ((localFormat2.bitrate < localFormat1.bitrate) && (paramLong2 >= this.maxDurationForQualityDecreaseUs)) {
        this.selectedIndex = i;
      }
    }
    if (this.selectedIndex != i) {
      this.reason = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
 * JD-Core Version:    0.7.0.1
 */