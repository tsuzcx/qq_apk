package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;

public final class ExtractorMediaSource
  implements ExtractorMediaPeriod.Listener, MediaSource
{
  public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
  public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
  public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
  public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
  private final int continueLoadingCheckIntervalBytes;
  private final String customCacheKey;
  private final DataSource.Factory dataSourceFactory;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final ExtractorsFactory extractorsFactory;
  private final int minLoadableRetryCount;
  private MediaSource.Listener sourceListener;
  private long timelineDurationUs;
  private boolean timelineIsSeekable;
  private final Uri uri;
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, int paramInt1, Handler paramHandler, ExtractorMediaSource.EventListener paramEventListener, String paramString, int paramInt2)
  {
    this(paramUri, paramFactory, paramExtractorsFactory, paramInt1, paramHandler, paramEventListener, paramString, paramInt2);
  }
  
  private ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, int paramInt1, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener, @Nullable String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.dataSourceFactory = paramFactory;
    this.extractorsFactory = paramExtractorsFactory;
    this.minLoadableRetryCount = paramInt1;
    this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(paramHandler, paramMediaSourceEventListener);
    this.customCacheKey = paramString;
    this.continueLoadingCheckIntervalBytes = paramInt2;
  }
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, Handler paramHandler, ExtractorMediaSource.EventListener paramEventListener)
  {
    this(paramUri, paramFactory, paramExtractorsFactory, paramHandler, paramEventListener, null);
  }
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, Handler paramHandler, ExtractorMediaSource.EventListener paramEventListener, String paramString)
  {
    this(paramUri, paramFactory, paramExtractorsFactory, -1, paramHandler, paramEventListener, paramString, 1048576);
  }
  
  private void notifySourceInfoRefreshed(long paramLong, boolean paramBoolean)
  {
    this.timelineDurationUs = paramLong;
    this.timelineIsSeekable = paramBoolean;
    this.sourceListener.onSourceInfoRefreshed(this, new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false), null);
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    boolean bool;
    if (paramMediaPeriodId.periodIndex == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    return new ExtractorMediaPeriod(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, this.eventDispatcher, this, paramAllocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
  }
  
  public void maybeThrowSourceInfoRefreshError() {}
  
  public void onSourceInfoRefreshed(long paramLong, boolean paramBoolean)
  {
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.timelineDurationUs;
    }
    if ((this.timelineDurationUs == l) && (this.timelineIsSeekable == paramBoolean)) {
      return;
    }
    notifySourceInfoRefreshed(l, paramBoolean);
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    this.sourceListener = paramListener;
    notifySourceInfoRefreshed(-9223372036854775807L, false);
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    ((ExtractorMediaPeriod)paramMediaPeriod).release();
  }
  
  public void releaseSource()
  {
    this.sourceListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaSource
 * JD-Core Version:    0.7.0.1
 */