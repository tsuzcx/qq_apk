package com.google.android.exoplayer2.source.hls.playlist;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.List;

final class HlsPlaylistTracker$MediaPlaylistBundle
  implements Loader.Callback<ParsingLoadable<HlsPlaylist>>, Runnable
{
  private long blacklistUntilMs;
  private long earliestNextLoadTimeMs;
  private long lastSnapshotChangeMs;
  private long lastSnapshotLoadMs;
  private boolean loadPending;
  private final ParsingLoadable<HlsPlaylist> mediaPlaylistLoadable;
  private final Loader mediaPlaylistLoader;
  private IOException playlistError;
  private HlsMediaPlaylist playlistSnapshot;
  private final HlsMasterPlaylist.HlsUrl playlistUrl;
  
  public HlsPlaylistTracker$MediaPlaylistBundle(HlsPlaylistTracker paramHlsPlaylistTracker, HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    this.playlistUrl = paramHlsUrl;
    this.mediaPlaylistLoader = new Loader("HlsPlaylistTracker:MediaPlaylist");
    this.mediaPlaylistLoadable = new ParsingLoadable(HlsPlaylistTracker.access$300(paramHlsPlaylistTracker).createDataSource(4), UriUtil.resolveToUri(HlsPlaylistTracker.access$400(paramHlsPlaylistTracker).baseUri, paramHlsUrl.url), 4, HlsPlaylistTracker.access$500(paramHlsPlaylistTracker));
  }
  
  private boolean blacklistPlaylist()
  {
    this.blacklistUntilMs = (SystemClock.elapsedRealtime() + 60000L);
    HlsPlaylistTracker.access$1400(this.this$0, this.playlistUrl, 60000L);
    return (HlsPlaylistTracker.access$1300(this.this$0) == this.playlistUrl) && (!HlsPlaylistTracker.access$1500(this.this$0));
  }
  
  private void loadPlaylistImmediately()
  {
    this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, HlsPlaylistTracker.access$800(this.this$0));
  }
  
  private void processLoadedPlaylist(HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    HlsMediaPlaylist localHlsMediaPlaylist = this.playlistSnapshot;
    long l2 = SystemClock.elapsedRealtime();
    this.lastSnapshotLoadMs = l2;
    this.playlistSnapshot = HlsPlaylistTracker.access$900(this.this$0, localHlsMediaPlaylist, paramHlsMediaPlaylist);
    if (this.playlistSnapshot != localHlsMediaPlaylist)
    {
      this.playlistError = null;
      this.lastSnapshotChangeMs = l2;
      HlsPlaylistTracker.access$1000(this.this$0, this.playlistUrl, this.playlistSnapshot);
      if (this.playlistSnapshot == localHlsMediaPlaylist) {
        break label235;
      }
    }
    label235:
    for (long l1 = this.playlistSnapshot.targetDurationUs;; l1 = this.playlistSnapshot.targetDurationUs / 2L)
    {
      this.earliestNextLoadTimeMs = (C.usToMs(l1) + l2);
      if ((this.playlistUrl == HlsPlaylistTracker.access$1300(this.this$0)) && (!this.playlistSnapshot.hasEndTag)) {
        loadPlaylist();
      }
      return;
      if (this.playlistSnapshot.hasEndTag) {
        break;
      }
      if (paramHlsMediaPlaylist.mediaSequence + paramHlsMediaPlaylist.segments.size() < this.playlistSnapshot.mediaSequence)
      {
        this.playlistError = new HlsPlaylistTracker.PlaylistResetException(this.playlistUrl.url, null);
        break;
      }
      if (l2 - this.lastSnapshotChangeMs <= C.usToMs(this.playlistSnapshot.targetDurationUs) * 3.5D) {
        break;
      }
      this.playlistError = new HlsPlaylistTracker.PlaylistStuckException(this.playlistUrl.url, null);
      blacklistPlaylist();
      break;
    }
  }
  
  public HlsMediaPlaylist getPlaylistSnapshot()
  {
    return this.playlistSnapshot;
  }
  
  public boolean isSnapshotValid()
  {
    if (this.playlistSnapshot == null) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.max(30000L, C.usToMs(this.playlistSnapshot.durationUs));
    } while ((!this.playlistSnapshot.hasEndTag) && (this.playlistSnapshot.playlistType != 2) && (this.playlistSnapshot.playlistType != 1) && (l2 + this.lastSnapshotLoadMs <= l1));
    return true;
  }
  
  public void loadPlaylist()
  {
    this.blacklistUntilMs = 0L;
    if ((this.loadPending) || (this.mediaPlaylistLoader.isLoading())) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < this.earliestNextLoadTimeMs)
    {
      this.loadPending = true;
      HlsPlaylistTracker.access$600(this.this$0).postDelayed(this, this.earliestNextLoadTimeMs - l);
      return;
    }
    loadPlaylistImmediately();
  }
  
  public void maybeThrowPlaylistRefreshError()
  {
    this.mediaPlaylistLoader.maybeThrowError();
    if (this.playlistError != null) {
      throw this.playlistError;
    }
  }
  
  public void onLoadCanceled(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    HlsPlaylistTracker.access$700(this.this$0).loadCanceled(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded());
  }
  
  public void onLoadCompleted(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2)
  {
    HlsPlaylist localHlsPlaylist = (HlsPlaylist)paramParsingLoadable.getResult();
    if ((localHlsPlaylist instanceof HlsMediaPlaylist))
    {
      processLoadedPlaylist((HlsMediaPlaylist)localHlsPlaylist);
      HlsPlaylistTracker.access$700(this.this$0).loadCompleted(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded());
      return;
    }
    this.playlistError = new ParserException("Loaded playlist has unexpected type.");
  }
  
  public int onLoadError(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = paramIOException instanceof ParserException;
    HlsPlaylistTracker.access$700(this.this$0).loadError(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded(), paramIOException, bool);
    if (bool) {
      return 3;
    }
    bool = true;
    if (ChunkedTrackBlacklistUtil.shouldBlacklist(paramIOException)) {
      bool = blacklistPlaylist();
    }
    if (bool) {
      return 0;
    }
    return 2;
  }
  
  public void release()
  {
    this.mediaPlaylistLoader.release();
  }
  
  public void run()
  {
    this.loadPending = false;
    loadPlaylistImmediately();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.MediaPlaylistBundle
 * JD-Core Version:    0.7.0.1
 */