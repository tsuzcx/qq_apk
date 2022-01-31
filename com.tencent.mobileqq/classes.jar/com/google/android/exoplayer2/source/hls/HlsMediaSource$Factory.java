package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;

public final class HlsMediaSource$Factory
  implements AdsMediaSource.MediaSourceFactory
{
  private boolean allowChunklessPreparation;
  private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
  private HlsExtractorFactory extractorFactory;
  private final HlsDataSourceFactory hlsDataSourceFactory;
  private boolean isCreateCalled;
  private int minLoadableRetryCount;
  @Nullable
  private ParsingLoadable.Parser<HlsPlaylist> playlistParser;
  
  public HlsMediaSource$Factory(HlsDataSourceFactory paramHlsDataSourceFactory)
  {
    this.hlsDataSourceFactory = ((HlsDataSourceFactory)Assertions.checkNotNull(paramHlsDataSourceFactory));
    this.extractorFactory = HlsExtractorFactory.DEFAULT;
    this.minLoadableRetryCount = 3;
    this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
  }
  
  public HlsMediaSource$Factory(DataSource.Factory paramFactory)
  {
    this(new DefaultHlsDataSourceFactory(paramFactory));
  }
  
  public HlsMediaSource createMediaSource(Uri paramUri)
  {
    return createMediaSource(paramUri, null, null);
  }
  
  public HlsMediaSource createMediaSource(Uri paramUri, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener)
  {
    this.isCreateCalled = true;
    if (this.playlistParser == null) {
      this.playlistParser = new HlsPlaylistParser();
    }
    return new HlsMediaSource(paramUri, this.hlsDataSourceFactory, this.extractorFactory, this.compositeSequenceableLoaderFactory, this.minLoadableRetryCount, paramHandler, paramMediaSourceEventListener, this.playlistParser, this.allowChunklessPreparation, null);
  }
  
  public int[] getSupportedTypes()
  {
    return new int[] { 2 };
  }
  
  public Factory setAllowChunklessPreparation(boolean paramBoolean)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.allowChunklessPreparation = paramBoolean;
      return this;
    }
  }
  
  public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory paramCompositeSequenceableLoaderFactory)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.compositeSequenceableLoaderFactory = ((CompositeSequenceableLoaderFactory)Assertions.checkNotNull(paramCompositeSequenceableLoaderFactory));
      return this;
    }
  }
  
  public Factory setExtractorFactory(HlsExtractorFactory paramHlsExtractorFactory)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.extractorFactory = ((HlsExtractorFactory)Assertions.checkNotNull(paramHlsExtractorFactory));
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
  
  public Factory setPlaylistParser(ParsingLoadable.Parser<HlsPlaylist> paramParser)
  {
    if (!this.isCreateCalled) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.playlistParser = ((ParsingLoadable.Parser)Assertions.checkNotNull(paramParser));
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory
 * JD-Core Version:    0.7.0.1
 */