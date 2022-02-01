package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult
{
  public final TrackGroupArray groups;
  public final Object info;
  public final RendererConfiguration[] rendererConfigurations;
  public final boolean[] renderersEnabled;
  public final TrackSelectionArray selections;
  
  public TrackSelectorResult(TrackGroupArray paramTrackGroupArray, boolean[] paramArrayOfBoolean, TrackSelectionArray paramTrackSelectionArray, Object paramObject, RendererConfiguration[] paramArrayOfRendererConfiguration)
  {
    this.groups = paramTrackGroupArray;
    this.renderersEnabled = paramArrayOfBoolean;
    this.selections = paramTrackSelectionArray;
    this.info = paramObject;
    this.rendererConfigurations = paramArrayOfRendererConfiguration;
  }
  
  public boolean isEquivalent(TrackSelectorResult paramTrackSelectorResult)
  {
    if (paramTrackSelectorResult != null)
    {
      if (paramTrackSelectorResult.selections.length != this.selections.length) {
        return false;
      }
      int i = 0;
      while (i < this.selections.length)
      {
        if (!isEquivalent(paramTrackSelectorResult, i)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean isEquivalent(TrackSelectorResult paramTrackSelectorResult, int paramInt)
  {
    boolean bool2 = false;
    if (paramTrackSelectorResult == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.renderersEnabled[paramInt] == paramTrackSelectorResult.renderersEnabled[paramInt])
    {
      bool1 = bool2;
      if (Util.areEqual(this.selections.get(paramInt), paramTrackSelectorResult.selections.get(paramInt)))
      {
        bool1 = bool2;
        if (Util.areEqual(this.rendererConfigurations[paramInt], paramTrackSelectorResult.rendererConfigurations[paramInt])) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelectorResult
 * JD-Core Version:    0.7.0.1
 */