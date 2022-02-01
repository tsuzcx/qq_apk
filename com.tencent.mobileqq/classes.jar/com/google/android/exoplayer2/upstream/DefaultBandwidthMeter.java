package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;

public final class DefaultBandwidthMeter
  implements BandwidthMeter, TransferListener<Object>
{
  private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
  public static final int DEFAULT_MAX_WEIGHT = 2000;
  private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
  private long bitrateEstimate;
  private final Clock clock;
  private final Handler eventHandler;
  private final BandwidthMeter.EventListener eventListener;
  private long sampleBytesTransferred;
  private long sampleStartTimeMs;
  private final SlidingPercentile slidingPercentile;
  private int streamCount;
  private long totalBytesTransferred;
  private long totalElapsedTimeMs;
  
  public DefaultBandwidthMeter()
  {
    this(null, null);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener)
  {
    this(paramHandler, paramEventListener, 2000);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt)
  {
    this(paramHandler, paramEventListener, paramInt, Clock.DEFAULT);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt, Clock paramClock)
  {
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.slidingPercentile = new SlidingPercentile(paramInt);
    this.clock = paramClock;
    this.bitrateEstimate = -1L;
  }
  
  private void notifyBandwidthSample(int paramInt, long paramLong1, long paramLong2)
  {
    Handler localHandler = this.eventHandler;
    if ((localHandler != null) && (this.eventListener != null)) {
      localHandler.post(new DefaultBandwidthMeter.1(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long getBitrateEstimate()
  {
    try
    {
      long l = this.bitrateEstimate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBytesTransferred(Object paramObject, int paramInt)
  {
    try
    {
      this.sampleBytesTransferred += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void onTransferEnd(Object paramObject)
  {
    for (;;)
    {
      float f;
      try
      {
        if (this.streamCount > 0)
        {
          bool = true;
          Assertions.checkState(bool);
          long l2 = this.clock.elapsedRealtime();
          int i = (int)(l2 - this.sampleStartTimeMs);
          l1 = this.totalElapsedTimeMs;
          long l3 = i;
          this.totalElapsedTimeMs = (l1 + l3);
          this.totalBytesTransferred += this.sampleBytesTransferred;
          if (i > 0)
          {
            f = (float)(this.sampleBytesTransferred * 8000L / l3);
            this.slidingPercentile.addSample((int)Math.sqrt(this.sampleBytesTransferred), f);
            if ((this.totalElapsedTimeMs >= 2000L) || (this.totalBytesTransferred >= 524288L))
            {
              f = this.slidingPercentile.getPercentile(0.5F);
              if (!Float.isNaN(f)) {
                break label213;
              }
              l1 = -1L;
              this.bitrateEstimate = l1;
            }
          }
          notifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
          i = this.streamCount - 1;
          this.streamCount = i;
          if (i > 0) {
            this.sampleStartTimeMs = l2;
          }
          this.sampleBytesTransferred = 0L;
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label213:
      long l1 = f;
    }
  }
  
  public void onTransferStart(Object paramObject, DataSpec paramDataSpec)
  {
    try
    {
      if (this.streamCount == 0) {
        this.sampleStartTimeMs = this.clock.elapsedRealtime();
      }
      this.streamCount += 1;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
 * JD-Core Version:    0.7.0.1
 */