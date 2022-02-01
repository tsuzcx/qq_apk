package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;

public abstract interface TrackSelection
{
  public abstract boolean blacklist(int paramInt, long paramLong);
  
  public abstract void disable();
  
  public abstract void enable();
  
  public abstract int evaluateQueueSize(long paramLong, List<? extends MediaChunk> paramList);
  
  public abstract Format getFormat(int paramInt);
  
  public abstract int getIndexInTrackGroup(int paramInt);
  
  public abstract Format getSelectedFormat();
  
  public abstract int getSelectedIndex();
  
  public abstract int getSelectedIndexInTrackGroup();
  
  public abstract Object getSelectionData();
  
  public abstract int getSelectionReason();
  
  public abstract TrackGroup getTrackGroup();
  
  public abstract int indexOf(int paramInt);
  
  public abstract int indexOf(Format paramFormat);
  
  public abstract int length();
  
  public abstract void onPlaybackSpeed(float paramFloat);
  
  public abstract void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelection
 * JD-Core Version:    0.7.0.1
 */