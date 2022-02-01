package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;

public final class ExtractorMediaSource$Factory
  implements AdsMediaSource.MediaSourceFactory
{
  private int continueLoadingCheckIntervalBytes;
  @Nullable
  private String customCacheKey;
  private final DataSource.Factory dataSourceFactory;
  @Nullable
  private ExtractorsFactory extractorsFactory;
  private boolean isCreateCalled;
  private int minLoadableRetryCount;
  
  public ExtractorMediaSource$Factory(DataSource.Factory paramFactory)
  {
    this.dataSourceFactory = paramFactory;
    this.minLoadableRetryCount = -1;
    this.continueLoadingCheckIntervalBytes = 1048576;
  }
  
  public ExtractorMediaSource createMediaSource(Uri paramUri)
  {
    return createMediaSource(paramUri, null, null);
  }
  
  public ExtractorMediaSource createMediaSource(Uri paramUri, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener)
  {
    this.isCreateCalled = true;
    if (this.extractorsFactory == null) {
      this.extractorsFactory = new DefaultExtractorsFactory();
    }
    return new ExtractorMediaSource(paramUri, this.dataSourceFactory, this.extractorsFactory, this.minLoadableRetryCount, paramHandler, paramMediaSourceEventListener, this.customCacheKey, this.continueLoadingCheckIntervalBytes, null);
  }
  
  public int[] getSupportedTypes()
  {
    return new int[] { 3 };
  }
  
  public Factory setContinueLoadingCheckIntervalBytes(int paramInt)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.continueLoadingCheckIntervalBytes = paramInt;
      return this;
    }
  }
  
  public Factory setCustomCacheKey(String paramString)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.customCacheKey = paramString;
      return this;
    }
  }
  
  public Factory setExtractorsFactory(ExtractorsFactory paramExtractorsFactory)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.extractorsFactory = paramExtractorsFactory;
      return this;
    }
  }
  
  public Factory setMinLoadableRetryCount(int paramInt)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.minLoadableRetryCount = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaSource.Factory
 * JD-Core Version:    0.7.0.1
 */