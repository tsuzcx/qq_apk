package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class HlsPlaylistTracker
  implements Loader.Callback<ParsingLoadable<HlsPlaylist>>
{
  private static final double PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5D;
  private final HlsDataSourceFactory dataSourceFactory;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final Loader initialPlaylistLoader;
  private final Uri initialPlaylistUri;
  private long initialStartTimeUs;
  private boolean isLive;
  private final List<HlsPlaylistTracker.PlaylistEventListener> listeners;
  private HlsMasterPlaylist masterPlaylist;
  private final int minRetryCount;
  private final IdentityHashMap<HlsMasterPlaylist.HlsUrl, HlsPlaylistTracker.MediaPlaylistBundle> playlistBundles;
  private final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
  private final Handler playlistRefreshHandler;
  private HlsMasterPlaylist.HlsUrl primaryHlsUrl;
  private final HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener;
  private HlsMediaPlaylist primaryUrlSnapshot;
  
  public HlsPlaylistTracker(Uri paramUri, HlsDataSourceFactory paramHlsDataSourceFactory, MediaSourceEventListener.EventDispatcher paramEventDispatcher, int paramInt, HlsPlaylistTracker.PrimaryPlaylistListener paramPrimaryPlaylistListener, ParsingLoadable.Parser<HlsPlaylist> paramParser)
  {
    this.initialPlaylistUri = paramUri;
    this.dataSourceFactory = paramHlsDataSourceFactory;
    this.eventDispatcher = paramEventDispatcher;
    this.minRetryCount = paramInt;
    this.primaryPlaylistListener = paramPrimaryPlaylistListener;
    this.playlistParser = paramParser;
    this.listeners = new ArrayList();
    this.initialPlaylistLoader = new Loader("HlsPlaylistTracker:MasterPlaylist");
    this.playlistBundles = new IdentityHashMap();
    this.playlistRefreshHandler = new Handler();
    this.initialStartTimeUs = -9223372036854775807L;
  }
  
  private void createBundles(List<HlsMasterPlaylist.HlsUrl> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      HlsMasterPlaylist.HlsUrl localHlsUrl = (HlsMasterPlaylist.HlsUrl)paramList.get(i);
      HlsPlaylistTracker.MediaPlaylistBundle localMediaPlaylistBundle = new HlsPlaylistTracker.MediaPlaylistBundle(this, localHlsUrl);
      this.playlistBundles.put(localHlsUrl, localMediaPlaylistBundle);
      i += 1;
    }
  }
  
  private static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist paramHlsMediaPlaylist1, HlsMediaPlaylist paramHlsMediaPlaylist2)
  {
    int i = (int)(paramHlsMediaPlaylist2.mediaSequence - paramHlsMediaPlaylist1.mediaSequence);
    paramHlsMediaPlaylist1 = paramHlsMediaPlaylist1.segments;
    if (i < paramHlsMediaPlaylist1.size()) {
      return (HlsMediaPlaylist.Segment)paramHlsMediaPlaylist1.get(i);
    }
    return null;
  }
  
  private HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist paramHlsMediaPlaylist1, HlsMediaPlaylist paramHlsMediaPlaylist2)
  {
    if (!paramHlsMediaPlaylist2.isNewerThan(paramHlsMediaPlaylist1))
    {
      HlsMediaPlaylist localHlsMediaPlaylist = paramHlsMediaPlaylist1;
      if (paramHlsMediaPlaylist2.hasEndTag) {
        localHlsMediaPlaylist = paramHlsMediaPlaylist1.copyWithEndTag();
      }
      return localHlsMediaPlaylist;
    }
    return paramHlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(paramHlsMediaPlaylist1, paramHlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(paramHlsMediaPlaylist1, paramHlsMediaPlaylist2));
  }
  
  private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist paramHlsMediaPlaylist1, HlsMediaPlaylist paramHlsMediaPlaylist2)
  {
    int j;
    if (paramHlsMediaPlaylist2.hasDiscontinuitySequence)
    {
      j = paramHlsMediaPlaylist2.discontinuitySequence;
      return j;
    }
    if (this.primaryUrlSnapshot != null) {}
    for (int i = this.primaryUrlSnapshot.discontinuitySequence;; i = 0)
    {
      j = i;
      if (paramHlsMediaPlaylist1 == null) {
        break;
      }
      HlsMediaPlaylist.Segment localSegment = getFirstOldOverlappingSegment(paramHlsMediaPlaylist1, paramHlsMediaPlaylist2);
      j = i;
      if (localSegment == null) {
        break;
      }
      i = paramHlsMediaPlaylist1.discontinuitySequence;
      return localSegment.relativeDiscontinuitySequence + i - ((HlsMediaPlaylist.Segment)paramHlsMediaPlaylist2.segments.get(0)).relativeDiscontinuitySequence;
    }
  }
  
  private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist paramHlsMediaPlaylist1, HlsMediaPlaylist paramHlsMediaPlaylist2)
  {
    long l2;
    if (paramHlsMediaPlaylist2.hasProgramDateTime) {
      l2 = paramHlsMediaPlaylist2.startTimeUs;
    }
    int i;
    label79:
    do
    {
      return l2;
      if (this.primaryUrlSnapshot != null) {}
      for (long l1 = this.primaryUrlSnapshot.startTimeUs;; l1 = 0L)
      {
        l2 = l1;
        if (paramHlsMediaPlaylist1 == null) {
          break;
        }
        i = paramHlsMediaPlaylist1.segments.size();
        HlsMediaPlaylist.Segment localSegment = getFirstOldOverlappingSegment(paramHlsMediaPlaylist1, paramHlsMediaPlaylist2);
        if (localSegment == null) {
          break label79;
        }
        return paramHlsMediaPlaylist1.startTimeUs + localSegment.relativeStartTimeUs;
      }
      l2 = l1;
    } while (i != paramHlsMediaPlaylist2.mediaSequence - paramHlsMediaPlaylist1.mediaSequence);
    return paramHlsMediaPlaylist1.getEndTimeUs();
  }
  
  private boolean maybeSelectNewPrimaryUrl()
  {
    List localList = this.masterPlaylist.variants;
    int j = localList.size();
    long l = SystemClock.elapsedRealtime();
    int i = 0;
    while (i < j)
    {
      HlsPlaylistTracker.MediaPlaylistBundle localMediaPlaylistBundle = (HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(localList.get(i));
      if (l > HlsPlaylistTracker.MediaPlaylistBundle.access$100(localMediaPlaylistBundle))
      {
        this.primaryHlsUrl = HlsPlaylistTracker.MediaPlaylistBundle.access$200(localMediaPlaylistBundle);
        localMediaPlaylistBundle.loadPlaylist();
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void maybeSetPrimaryUrl(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    if ((paramHlsUrl == this.primaryHlsUrl) || (!this.masterPlaylist.variants.contains(paramHlsUrl)) || ((this.primaryUrlSnapshot != null) && (this.primaryUrlSnapshot.hasEndTag))) {
      return;
    }
    this.primaryHlsUrl = paramHlsUrl;
    ((HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(this.primaryHlsUrl)).loadPlaylist();
  }
  
  private void notifyPlaylistBlacklisting(HlsMasterPlaylist.HlsUrl paramHlsUrl, long paramLong)
  {
    int j = this.listeners.size();
    int i = 0;
    while (i < j)
    {
      ((HlsPlaylistTracker.PlaylistEventListener)this.listeners.get(i)).onPlaylistBlacklisted(paramHlsUrl, paramLong);
      i += 1;
    }
  }
  
  private void onPlaylistUpdated(HlsMasterPlaylist.HlsUrl paramHlsUrl, HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    int i = 0;
    if (paramHlsUrl == this.primaryHlsUrl) {
      if (this.primaryUrlSnapshot == null) {
        if (paramHlsMediaPlaylist.hasEndTag) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      this.isLive = bool;
      this.initialStartTimeUs = paramHlsMediaPlaylist.startTimeUs;
      this.primaryUrlSnapshot = paramHlsMediaPlaylist;
      this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(paramHlsMediaPlaylist);
      int j = this.listeners.size();
      while (i < j)
      {
        ((HlsPlaylistTracker.PlaylistEventListener)this.listeners.get(i)).onPlaylistChanged();
        i += 1;
      }
    }
  }
  
  public void addListener(HlsPlaylistTracker.PlaylistEventListener paramPlaylistEventListener)
  {
    this.listeners.add(paramPlaylistEventListener);
  }
  
  public long getInitialStartTimeUs()
  {
    return this.initialStartTimeUs;
  }
  
  public HlsMasterPlaylist getMasterPlaylist()
  {
    return this.masterPlaylist;
  }
  
  public HlsMediaPlaylist getPlaylistSnapshot(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    HlsMediaPlaylist localHlsMediaPlaylist = ((HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(paramHlsUrl)).getPlaylistSnapshot();
    if (localHlsMediaPlaylist != null) {
      maybeSetPrimaryUrl(paramHlsUrl);
    }
    return localHlsMediaPlaylist;
  }
  
  public boolean isLive()
  {
    return this.isLive;
  }
  
  public boolean isSnapshotValid(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    return ((HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(paramHlsUrl)).isSnapshotValid();
  }
  
  public void maybeThrowPlaylistRefreshError(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    ((HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(paramHlsUrl)).maybeThrowPlaylistRefreshError();
  }
  
  public void maybeThrowPrimaryPlaylistRefreshError()
  {
    this.initialPlaylistLoader.maybeThrowError();
    if (this.primaryHlsUrl != null) {
      maybeThrowPlaylistRefreshError(this.primaryHlsUrl);
    }
  }
  
  public void onLoadCanceled(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded());
  }
  
  public void onLoadCompleted(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2)
  {
    HlsPlaylist localHlsPlaylist = (HlsPlaylist)paramParsingLoadable.getResult();
    boolean bool = localHlsPlaylist instanceof HlsMediaPlaylist;
    Object localObject;
    if (bool)
    {
      localObject = HlsMasterPlaylist.createSingleVariantMasterPlaylist(localHlsPlaylist.baseUri);
      this.masterPlaylist = ((HlsMasterPlaylist)localObject);
      this.primaryHlsUrl = ((HlsMasterPlaylist.HlsUrl)((HlsMasterPlaylist)localObject).variants.get(0));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((HlsMasterPlaylist)localObject).variants);
      localArrayList.addAll(((HlsMasterPlaylist)localObject).audios);
      localArrayList.addAll(((HlsMasterPlaylist)localObject).subtitles);
      createBundles(localArrayList);
      localObject = (HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(this.primaryHlsUrl);
      if (!bool) {
        break label164;
      }
      HlsPlaylistTracker.MediaPlaylistBundle.access$000((HlsPlaylistTracker.MediaPlaylistBundle)localObject, (HlsMediaPlaylist)localHlsPlaylist);
    }
    for (;;)
    {
      this.eventDispatcher.loadCompleted(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded());
      return;
      localObject = (HlsMasterPlaylist)localHlsPlaylist;
      break;
      label164:
      ((HlsPlaylistTracker.MediaPlaylistBundle)localObject).loadPlaylist();
    }
  }
  
  public int onLoadError(ParsingLoadable<HlsPlaylist> paramParsingLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = paramIOException instanceof ParserException;
    this.eventDispatcher.loadError(paramParsingLoadable.dataSpec, 4, paramLong1, paramLong2, paramParsingLoadable.bytesLoaded(), paramIOException, bool);
    if (bool) {
      return 3;
    }
    return 0;
  }
  
  public void refreshPlaylist(HlsMasterPlaylist.HlsUrl paramHlsUrl)
  {
    ((HlsPlaylistTracker.MediaPlaylistBundle)this.playlistBundles.get(paramHlsUrl)).loadPlaylist();
  }
  
  public void release()
  {
    this.initialPlaylistLoader.release();
    Iterator localIterator = this.playlistBundles.values().iterator();
    while (localIterator.hasNext()) {
      ((HlsPlaylistTracker.MediaPlaylistBundle)localIterator.next()).release();
    }
    this.playlistRefreshHandler.removeCallbacksAndMessages(null);
    this.playlistBundles.clear();
  }
  
  public void removeListener(HlsPlaylistTracker.PlaylistEventListener paramPlaylistEventListener)
  {
    this.listeners.remove(paramPlaylistEventListener);
  }
  
  public void start()
  {
    ParsingLoadable localParsingLoadable = new ParsingLoadable(this.dataSourceFactory.createDataSource(4), this.initialPlaylistUri, 4, this.playlistParser);
    this.initialPlaylistLoader.startLoading(localParsingLoadable, this, this.minRetryCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
 * JD-Core Version:    0.7.0.1
 */