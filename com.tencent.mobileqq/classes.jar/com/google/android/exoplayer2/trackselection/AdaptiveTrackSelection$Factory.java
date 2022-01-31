package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;

public final class AdaptiveTrackSelection$Factory
  implements TrackSelection.Factory
{
  private final float bandwidthFraction;
  private final BandwidthMeter bandwidthMeter;
  private final float bufferedFractionToLiveEdgeForQualityIncrease;
  private final Clock clock;
  private final int maxDurationForQualityDecreaseMs;
  private final int maxInitialBitrate;
  private final int minDurationForQualityIncreaseMs;
  private final int minDurationToRetainAfterDiscardMs;
  private final long minTimeBetweenBufferReevaluationMs;
  
  public AdaptiveTrackSelection$Factory(BandwidthMeter paramBandwidthMeter)
  {
    this(paramBandwidthMeter, 800000, 10000, 25000, 25000, 0.75F, 0.75F, 2000L, Clock.DEFAULT);
  }
  
  public AdaptiveTrackSelection$Factory(BandwidthMeter paramBandwidthMeter, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    this(paramBandwidthMeter, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, 0.75F, 2000L, Clock.DEFAULT);
  }
  
  public AdaptiveTrackSelection$Factory(BandwidthMeter paramBandwidthMeter, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, long paramLong, Clock paramClock)
  {
    this.bandwidthMeter = paramBandwidthMeter;
    this.maxInitialBitrate = paramInt1;
    this.minDurationForQualityIncreaseMs = paramInt2;
    this.maxDurationForQualityDecreaseMs = paramInt3;
    this.minDurationToRetainAfterDiscardMs = paramInt4;
    this.bandwidthFraction = paramFloat1;
    this.bufferedFractionToLiveEdgeForQualityIncrease = paramFloat2;
    this.minTimeBetweenBufferReevaluationMs = paramLong;
    this.clock = paramClock;
  }
  
  public AdaptiveTrackSelection createTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    return new AdaptiveTrackSelection(paramTrackGroup, paramVarArgs, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory
 * JD-Core Version:    0.7.0.1
 */