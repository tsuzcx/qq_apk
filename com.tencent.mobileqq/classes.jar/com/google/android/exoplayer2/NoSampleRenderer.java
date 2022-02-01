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
    int i = this.state;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Assertions.checkState(bool);
    this.state = 0;
    this.stream = null;
    this.streamIsFinal = false;
    onDisabled();
  }
  
  public final void enable(RendererConfiguration paramRendererConfiguration, Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    boolean bool;
    if (this.state == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.configuration = paramRendererConfiguration;
    this.state = 1;
    onEnabled(paramBoolean);
    replaceStream(paramArrayOfFormat, paramSampleStream, paramLong2);
    onPositionReset(paramLong1, paramBoolean);
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
    Assertions.checkState(this.streamIsFinal ^ true);
    this.stream = paramSampleStream;
    onRendererOffsetChanged(paramLong);
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
    int i = this.state;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Assertions.checkState(bool);
    this.state = 2;
    onStarted();
  }
  
  public final void stop()
  {
    boolean bool;
    if (this.state == 2) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.state = 1;
    onStopped();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.NoSampleRenderer
 * JD-Core Version:    0.7.0.1
 */