package com.google.android.exoplayer2.source;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public abstract class CompositeMediaSource<T>
  implements MediaSource
{
  private final HashMap<T, MediaSource> childSources = new HashMap();
  private ExoPlayer player;
  
  @CallSuper
  public void maybeThrowSourceInfoRefreshError()
  {
    Iterator localIterator = this.childSources.values().iterator();
    while (localIterator.hasNext()) {
      ((MediaSource)localIterator.next()).maybeThrowSourceInfoRefreshError();
    }
  }
  
  protected abstract void onChildSourceInfoRefreshed(@Nullable T paramT, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject);
  
  protected void prepareChildSource(@Nullable T paramT, MediaSource paramMediaSource)
  {
    if (!this.childSources.containsKey(paramT)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.childSources.put(paramT, paramMediaSource);
      paramMediaSource.prepareSource(this.player, false, new CompositeMediaSource.1(this, paramT, paramMediaSource));
      return;
    }
  }
  
  @CallSuper
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    this.player = paramExoPlayer;
  }
  
  protected void releaseChildSource(@Nullable T paramT)
  {
    ((MediaSource)this.childSources.remove(paramT)).releaseSource();
  }
  
  @CallSuper
  public void releaseSource()
  {
    Iterator localIterator = this.childSources.values().iterator();
    while (localIterator.hasNext()) {
      ((MediaSource)localIterator.next()).releaseSource();
    }
    this.childSources.clear();
    this.player = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.CompositeMediaSource
 * JD-Core Version:    0.7.0.1
 */