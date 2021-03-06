package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroupArray;

public abstract class TrackSelector
{
  private TrackSelector.InvalidationListener listener;
  
  public final void init(TrackSelector.InvalidationListener paramInvalidationListener)
  {
    this.listener = paramInvalidationListener;
  }
  
  protected final void invalidate()
  {
    TrackSelector.InvalidationListener localInvalidationListener = this.listener;
    if (localInvalidationListener != null) {
      localInvalidationListener.onTrackSelectionsInvalidated();
    }
  }
  
  public abstract void onSelectionActivated(Object paramObject);
  
  public abstract TrackSelectorResult selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray paramTrackGroupArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelector
 * JD-Core Version:    0.7.0.1
 */