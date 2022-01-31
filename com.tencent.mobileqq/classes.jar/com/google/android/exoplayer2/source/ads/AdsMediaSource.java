package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.DeferredMediaPeriod;
import com.google.android.exoplayer2.source.ExtractorMediaSource.Factory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AdsMediaSource
  extends CompositeMediaSource<MediaSource.MediaPeriodId>
{
  private static final String TAG = "AdsMediaSource";
  private long[][] adDurationsUs;
  private MediaSource[][] adGroupMediaSources;
  private final AdsMediaSource.MediaSourceFactory adMediaSourceFactory;
  private AdPlaybackState adPlaybackState;
  private final ViewGroup adUiViewGroup;
  private final AdsLoader adsLoader;
  private AdsMediaSource.ComponentListener componentListener;
  private Object contentManifest;
  private final MediaSource contentMediaSource;
  private Timeline contentTimeline;
  private final Map<MediaSource, List<DeferredMediaPeriod>> deferredMediaPeriodByAdMediaSource;
  @Nullable
  private final Handler eventHandler;
  @Nullable
  private final AdsMediaSource.EventListener eventListener;
  private MediaSource.Listener listener;
  private final Handler mainHandler;
  private final Timeline.Period period;
  
  public AdsMediaSource(MediaSource paramMediaSource, AdsMediaSource.MediaSourceFactory paramMediaSourceFactory, AdsLoader paramAdsLoader, ViewGroup paramViewGroup, @Nullable Handler paramHandler, @Nullable AdsMediaSource.EventListener paramEventListener)
  {
    this.contentMediaSource = paramMediaSource;
    this.adMediaSourceFactory = paramMediaSourceFactory;
    this.adsLoader = paramAdsLoader;
    this.adUiViewGroup = paramViewGroup;
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.deferredMediaPeriodByAdMediaSource = new HashMap();
    this.period = new Timeline.Period();
    this.adGroupMediaSources = new MediaSource[0][];
    this.adDurationsUs = new long[0][];
    paramAdsLoader.setSupportedContentTypes(paramMediaSourceFactory.getSupportedTypes());
  }
  
  public AdsMediaSource(MediaSource paramMediaSource, DataSource.Factory paramFactory, AdsLoader paramAdsLoader, ViewGroup paramViewGroup)
  {
    this(paramMediaSource, paramFactory, paramAdsLoader, paramViewGroup, null, null);
  }
  
  public AdsMediaSource(MediaSource paramMediaSource, DataSource.Factory paramFactory, AdsLoader paramAdsLoader, ViewGroup paramViewGroup, @Nullable Handler paramHandler, @Nullable AdsMediaSource.EventListener paramEventListener)
  {
    this(paramMediaSource, new ExtractorMediaSource.Factory(paramFactory), paramAdsLoader, paramViewGroup, paramHandler, paramEventListener);
  }
  
  private void maybeUpdateSourceInfo()
  {
    if ((this.adPlaybackState != null) && (this.contentTimeline != null))
    {
      this.adPlaybackState = this.adPlaybackState.withAdDurationsUs(this.adDurationsUs);
      if (this.adPlaybackState.adGroupCount != 0) {
        break label60;
      }
    }
    label60:
    for (Object localObject = this.contentTimeline;; localObject = new SinglePeriodAdTimeline(this.contentTimeline, this.adPlaybackState))
    {
      this.listener.onSourceInfoRefreshed(this, (Timeline)localObject, this.contentManifest);
      return;
    }
  }
  
  private void onAdPlaybackState(AdPlaybackState paramAdPlaybackState)
  {
    if (this.adPlaybackState == null)
    {
      this.adGroupMediaSources = new MediaSource[paramAdPlaybackState.adGroupCount][];
      Arrays.fill(this.adGroupMediaSources, new MediaSource[0]);
      this.adDurationsUs = new long[paramAdPlaybackState.adGroupCount][];
      Arrays.fill(this.adDurationsUs, new long[0]);
    }
    this.adPlaybackState = paramAdPlaybackState;
    maybeUpdateSourceInfo();
  }
  
  private void onAdSourceInfoRefreshed(MediaSource paramMediaSource, int paramInt1, int paramInt2, Timeline paramTimeline)
  {
    boolean bool = true;
    if (paramTimeline.getPeriodCount() == 1) {}
    for (;;)
    {
      Assertions.checkArgument(bool);
      this.adDurationsUs[paramInt1][paramInt2] = paramTimeline.getPeriod(0, this.period).getDurationUs();
      if (!this.deferredMediaPeriodByAdMediaSource.containsKey(paramMediaSource)) {
        break label117;
      }
      paramTimeline = (List)this.deferredMediaPeriodByAdMediaSource.get(paramMediaSource);
      paramInt1 = 0;
      while (paramInt1 < paramTimeline.size())
      {
        ((DeferredMediaPeriod)paramTimeline.get(paramInt1)).createPeriod();
        paramInt1 += 1;
      }
      bool = false;
    }
    this.deferredMediaPeriodByAdMediaSource.remove(paramMediaSource);
    label117:
    maybeUpdateSourceInfo();
  }
  
  private void onContentSourceInfoRefreshed(Timeline paramTimeline, Object paramObject)
  {
    this.contentTimeline = paramTimeline;
    this.contentManifest = paramObject;
    maybeUpdateSourceInfo();
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    if ((this.adPlaybackState.adGroupCount > 0) && (paramMediaPeriodId.isAd()))
    {
      int i = paramMediaPeriodId.adGroupIndex;
      int j = paramMediaPeriodId.adIndexInAdGroup;
      if (this.adGroupMediaSources[i].length <= j)
      {
        localObject = this.adPlaybackState.adGroups[paramMediaPeriodId.adGroupIndex].uris[paramMediaPeriodId.adIndexInAdGroup];
        localObject = this.adMediaSourceFactory.createMediaSource((Uri)localObject, this.eventHandler, this.eventListener);
        int k = this.adGroupMediaSources[paramMediaPeriodId.adGroupIndex].length;
        if (j >= k)
        {
          int m = j + 1;
          this.adGroupMediaSources[i] = ((MediaSource[])Arrays.copyOf(this.adGroupMediaSources[i], m));
          this.adDurationsUs[i] = Arrays.copyOf(this.adDurationsUs[i], m);
          Arrays.fill(this.adDurationsUs[i], k, m, -9223372036854775807L);
        }
        this.adGroupMediaSources[i][j] = localObject;
        this.deferredMediaPeriodByAdMediaSource.put(localObject, new ArrayList());
        prepareChildSource(paramMediaPeriodId, (MediaSource)localObject);
      }
      Object localObject = this.adGroupMediaSources[i][j];
      paramMediaPeriodId = new DeferredMediaPeriod((MediaSource)localObject, new MediaSource.MediaPeriodId(0, paramMediaPeriodId.windowSequenceNumber), paramAllocator);
      paramMediaPeriodId.setPrepareErrorListener(new AdsMediaSource.AdPrepareErrorListener(this, i, j));
      paramAllocator = (List)this.deferredMediaPeriodByAdMediaSource.get(localObject);
      if (paramAllocator == null) {
        paramMediaPeriodId.createPeriod();
      }
      for (;;)
      {
        return paramMediaPeriodId;
        paramAllocator.add(paramMediaPeriodId);
      }
    }
    paramMediaPeriodId = new DeferredMediaPeriod(this.contentMediaSource, paramMediaPeriodId, paramAllocator);
    paramMediaPeriodId.createPeriod();
    return paramMediaPeriodId;
  }
  
  protected void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId paramMediaPeriodId, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    if (paramMediaPeriodId.isAd())
    {
      onAdSourceInfoRefreshed(paramMediaSource, paramMediaPeriodId.adGroupIndex, paramMediaPeriodId.adIndexInAdGroup, paramTimeline);
      return;
    }
    onContentSourceInfoRefreshed(paramTimeline, paramObject);
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    Assertions.checkArgument(paramBoolean);
    AdsMediaSource.ComponentListener localComponentListener = new AdsMediaSource.ComponentListener(this);
    this.listener = paramListener;
    this.componentListener = localComponentListener;
    prepareChildSource(new MediaSource.MediaPeriodId(0), this.contentMediaSource);
    this.mainHandler.post(new AdsMediaSource.1(this, paramExoPlayer, localComponentListener));
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    paramMediaPeriod = (DeferredMediaPeriod)paramMediaPeriod;
    List localList = (List)this.deferredMediaPeriodByAdMediaSource.get(paramMediaPeriod.mediaSource);
    if (localList != null) {
      localList.remove(paramMediaPeriod);
    }
    paramMediaPeriod.releasePeriod();
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.componentListener.release();
    this.componentListener = null;
    this.deferredMediaPeriodByAdMediaSource.clear();
    this.contentTimeline = null;
    this.contentManifest = null;
    this.adPlaybackState = null;
    this.adGroupMediaSources = new MediaSource[0][];
    this.adDurationsUs = new long[0][];
    this.listener = null;
    this.mainHandler.post(new AdsMediaSource.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource
 * JD-Core Version:    0.7.0.1
 */