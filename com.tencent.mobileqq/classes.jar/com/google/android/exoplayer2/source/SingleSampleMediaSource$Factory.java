package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;

public final class SingleSampleMediaSource$Factory
{
  private final DataSource.Factory dataSourceFactory;
  private boolean isCreateCalled;
  private int minLoadableRetryCount;
  private boolean treatLoadErrorsAsEndOfStream;
  
  public SingleSampleMediaSource$Factory(DataSource.Factory paramFactory)
  {
    this.dataSourceFactory = ((DataSource.Factory)Assertions.checkNotNull(paramFactory));
    this.minLoadableRetryCount = 3;
  }
  
  public SingleSampleMediaSource createMediaSource(Uri paramUri, Format paramFormat, long paramLong)
  {
    return createMediaSource(paramUri, paramFormat, paramLong, null, null);
  }
  
  public SingleSampleMediaSource createMediaSource(Uri paramUri, Format paramFormat, long paramLong, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener)
  {
    this.isCreateCalled = true;
    return new SingleSampleMediaSource(paramUri, this.dataSourceFactory, paramFormat, paramLong, this.minLoadableRetryCount, paramHandler, paramMediaSourceEventListener, this.treatLoadErrorsAsEndOfStream, null);
  }
  
  public Factory setMinLoadableRetryCount(int paramInt)
  {
    Assertions.checkState(this.isCreateCalled ^ true);
    this.minLoadableRetryCount = paramInt;
    return this;
  }
  
  public Factory setTreatLoadErrorsAsEndOfStream(boolean paramBoolean)
  {
    Assertions.checkState(this.isCreateCalled ^ true);
    this.treatLoadErrorsAsEndOfStream = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory
 * JD-Core Version:    0.7.0.1
 */