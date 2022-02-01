package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;

public abstract interface Renderer
  extends PlayerMessage.Target
{
  public static final int STATE_DISABLED = 0;
  public static final int STATE_ENABLED = 1;
  public static final int STATE_STARTED = 2;
  
  public abstract void disable();
  
  public abstract void enable(RendererConfiguration paramRendererConfiguration, Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract RendererCapabilities getCapabilities();
  
  public abstract MediaClock getMediaClock();
  
  public abstract int getState();
  
  public abstract SampleStream getStream();
  
  public abstract int getTrackType();
  
  public abstract boolean hasReadStreamToEnd();
  
  public abstract boolean isCurrentStreamFinal();
  
  public abstract boolean isEnded();
  
  public abstract boolean isReady();
  
  public abstract void maybeThrowStreamError();
  
  public abstract void render(long paramLong1, long paramLong2);
  
  public abstract void replaceStream(Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong);
  
  public abstract void resetPosition(long paramLong);
  
  public abstract void setCurrentStreamFinal();
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.Renderer
 * JD-Core Version:    0.7.0.1
 */