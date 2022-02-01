package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public final class HlsMediaSource
  implements MediaSource, HlsPlaylistTracker.PrimaryPlaylistListener
{
  public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
  private final boolean allowChunklessPreparation;
  private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
  private final HlsDataSourceFactory dataSourceFactory;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final HlsExtractorFactory extractorFactory;
  private final Uri manifestUri;
  private final int minLoadableRetryCount;
  private final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
  private HlsPlaylistTracker playlistTracker;
  private MediaSource.Listener sourceListener;
  
  static
  {
    ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
  }
  
  @Deprecated
  public HlsMediaSource(Uri paramUri, HlsDataSourceFactory paramHlsDataSourceFactory, HlsExtractorFactory paramHlsExtractorFactory, int paramInt, Handler paramHandler, MediaSourceEventListener paramMediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> paramParser)
  {
    this(paramUri, paramHlsDataSourceFactory, paramHlsExtractorFactory, new DefaultCompositeSequenceableLoaderFactory(), paramInt, paramHandler, paramMediaSourceEventListener, paramParser, false);
  }
  
  private HlsMediaSource(Uri paramUri, HlsDataSourceFactory paramHlsDataSourceFactory, HlsExtractorFactory paramHlsExtractorFactory, CompositeSequenceableLoaderFactory paramCompositeSequenceableLoaderFactory, int paramInt, Handler paramHandler, MediaSourceEventListener paramMediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> paramParser, boolean paramBoolean)
  {
    this.manifestUri = paramUri;
    this.dataSourceFactory = paramHlsDataSourceFactory;
    this.extractorFactory = paramHlsExtractorFactory;
    this.compositeSequenceableLoaderFactory = paramCompositeSequenceableLoaderFactory;
    this.minLoadableRetryCount = paramInt;
    this.playlistParser = paramParser;
    this.allowChunklessPreparation = paramBoolean;
    this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(paramHandler, paramMediaSourceEventListener);
  }
  
  @Deprecated
  public HlsMediaSource(Uri paramUri, DataSource.Factory paramFactory, int paramInt, Handler paramHandler, MediaSourceEventListener paramMediaSourceEventListener)
  {
    this(paramUri, new DefaultHlsDataSourceFactory(paramFactory), HlsExtractorFactory.DEFAULT, paramInt, paramHandler, paramMediaSourceEventListener, new HlsPlaylistParser());
  }
  
  @Deprecated
  public HlsMediaSource(Uri paramUri, DataSource.Factory paramFactory, Handler paramHandler, MediaSourceEventListener paramMediaSourceEventListener)
  {
    this(paramUri, paramFactory, 3, paramHandler, paramMediaSourceEventListener);
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    if (paramMediaPeriodId.periodIndex == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, paramAllocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation);
    }
  }
  
  public void maybeThrowSourceInfoRefreshError()
  {
    this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
  }
  
  public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    long l1;
    long l3;
    label34:
    long l2;
    long l6;
    long l4;
    label80:
    long l5;
    label112:
    boolean bool;
    if (paramHlsMediaPlaylist.hasProgramDateTime)
    {
      l1 = C.usToMs(paramHlsMediaPlaylist.startTimeUs);
      if ((paramHlsMediaPlaylist.playlistType != 2) && (paramHlsMediaPlaylist.playlistType != 1)) {
        break label190;
      }
      l3 = l1;
      l2 = paramHlsMediaPlaylist.startOffsetUs;
      if (!this.playlistTracker.isLive()) {
        break label243;
      }
      l6 = paramHlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
      if (!paramHlsMediaPlaylist.hasEndTag) {
        break label198;
      }
      l4 = l6 + paramHlsMediaPlaylist.durationUs;
      localObject = paramHlsMediaPlaylist.segments;
      l5 = l2;
      if (l2 == -9223372036854775807L)
      {
        if (!((List)localObject).isEmpty()) {
          break label206;
        }
        l2 = 0L;
        l5 = l2;
      }
      l2 = paramHlsMediaPlaylist.durationUs;
      if (paramHlsMediaPlaylist.hasEndTag) {
        break label237;
      }
      bool = true;
    }
    label132:
    for (Object localObject = new SinglePeriodTimeline(l3, l1, l4, l2, l6, l5, true, bool);; localObject = new SinglePeriodTimeline(l3, l1, paramHlsMediaPlaylist.durationUs, paramHlsMediaPlaylist.durationUs, 0L, l4, true, false))
    {
      this.sourceListener.onSourceInfoRefreshed(this, (Timeline)localObject, new HlsManifest(this.playlistTracker.getMasterPlaylist(), paramHlsMediaPlaylist));
      return;
      l1 = -9223372036854775807L;
      break;
      label190:
      l3 = -9223372036854775807L;
      break label34;
      label198:
      l4 = -9223372036854775807L;
      break label80;
      label206:
      l2 = ((HlsMediaPlaylist.Segment)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).relativeStartTimeUs;
      break label112;
      label237:
      bool = false;
      break label132;
      label243:
      l4 = l2;
      if (l2 == -9223372036854775807L) {
        l4 = 0L;
      }
    }
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    this.sourceListener = paramListener;
    this.playlistTracker = new HlsPlaylistTracker(this.manifestUri, this.dataSourceFactory, this.eventDispatcher, this.minLoadableRetryCount, this, this.playlistParser);
    this.playlistTracker.start();
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    ((HlsMediaPeriod)paramMediaPeriod).release();
  }
  
  public void releaseSource()
  {
    if (this.playlistTracker != null)
    {
      this.playlistTracker.release();
      this.playlistTracker = null;
    }
    this.sourceListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaSource
 * JD-Core Version:    0.7.0.1
 */