package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

final class SingleSampleMediaSource$EventListenerWrapper
  implements MediaSourceEventListener
{
  private final SingleSampleMediaSource.EventListener eventListener;
  private final int eventSourceId;
  
  public SingleSampleMediaSource$EventListenerWrapper(SingleSampleMediaSource.EventListener paramEventListener, int paramInt)
  {
    this.eventListener = ((SingleSampleMediaSource.EventListener)Assertions.checkNotNull(paramEventListener));
    this.eventSourceId = paramInt;
  }
  
  public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
  
  public void onLoadCanceled(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadCompleted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadError(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    this.eventListener.onLoadError(this.eventSourceId, paramIOException);
  }
  
  public void onLoadStarted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onUpstreamDiscarded(int paramInt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListenerWrapper
 * JD-Core Version:    0.7.0.1
 */