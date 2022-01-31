package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;

public abstract class NoSampleRenderer
  implements Renderer, RendererCapabilities
{
  private RendererConfiguration configuration;
  private int index;
  private int state;
  private SampleStream stream;
  private boolean streamIsFinal;
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      Assertions.checkState(bool);
      this.state = 0;
      this.stream = null;
      this.streamIsFinal = false;
      onDisabled();
      return;
      bool = false;
    }
  }
  
  public final void enable(RendererConfiguration paramRendererConfiguration, Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.configuration = paramRendererConfiguration;
      this.state = 1;
      onEnabled(paramBoolean);
      replaceStream(paramArrayOfFormat, paramSampleStream, paramLong2);
      onPositionReset(paramLong1, paramBoolean);
      return;
    }
  }
  
  public final RendererCapabilities getCapabilities()
  {
    return this;
  }
  
  protected final RendererConfiguration getConfiguration()
  {
    return this.configuration;
  }
  
  protected final int getIndex()
  {
    return this.index;
  }
  
  public MediaClock getMediaClock()
  {
    return null;
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public final SampleStream getStream()
  {
    return this.stream;
  }
  
  public final int getTrackType()
  {
    return 5;
  }
  
  public void handleMessage(int paramInt, Object paramObject) {}
  
  public final boolean hasReadStreamToEnd()
  {
    return true;
  }
  
  public final boolean isCurrentStreamFinal()
  {
    return this.streamIsFinal;
  }
  
  public boolean isEnded()
  {
    return true;
  }
  
  public boolean isReady()
  {
    return true;
  }
  
  public final void maybeThrowStreamError() {}
  
  protected void onDisabled() {}
  
  protected void onEnabled(boolean paramBoolean) {}
  
  protected void onPositionReset(long paramLong, boolean paramBoolean) {}
  
  protected void onRendererOffsetChanged(long paramLong) {}
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  public final void replaceStream(Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong)
  {
    if (!this.streamIsFinal) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.stream = paramSampleStream;
      onRendererOffsetChanged(paramLong);
      return;
    }
  }
  
  public final void resetPosition(long paramLong)
  {
    this.streamIsFinal = false;
    onPositionReset(paramLong, false);
  }
  
  public final void setCurrentStreamFinal()
  {
    this.streamIsFinal = true;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void start()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      Assertions.checkState(bool);
      this.state = 2;
      onStarted();
      return;
      bool = false;
    }
  }
  
  public final void stop()
  {
    if (this.state == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.state = 1;
      onStopped();
      return;
    }
  }
  
  public int supportsFormat(Format paramFormat)
  {
    return 0;
  }
  
  public int supportsMixedMimeTypeAdaptation()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.NoSampleRenderer
 * JD-Core Version:    0.7.0.1
 */