package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;

public abstract class BaseRenderer
  implements Renderer, RendererCapabilities
{
  private RendererConfiguration configuration;
  private int index;
  private boolean readEndOfStream;
  private int state;
  private SampleStream stream;
  private boolean streamIsFinal;
  private long streamOffsetUs;
  private final int trackType;
  
  public BaseRenderer(int paramInt)
  {
    this.trackType = paramInt;
    this.readEndOfStream = true;
  }
  
  protected static boolean supportsFormatDrm(@Nullable DrmSessionManager<?> paramDrmSessionManager, @Nullable DrmInitData paramDrmInitData)
  {
    if (paramDrmInitData == null) {
      return true;
    }
    if (paramDrmSessionManager == null) {
      return false;
    }
    return paramDrmSessionManager.canAcquireSession(paramDrmInitData);
  }
  
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
    return this.trackType;
  }
  
  public void handleMessage(int paramInt, Object paramObject) {}
  
  public final boolean hasReadStreamToEnd()
  {
    return this.readEndOfStream;
  }
  
  public final boolean isCurrentStreamFinal()
  {
    return this.streamIsFinal;
  }
  
  protected final boolean isSourceReady()
  {
    if (this.readEndOfStream) {
      return this.streamIsFinal;
    }
    return this.stream.isReady();
  }
  
  public final void maybeThrowStreamError()
  {
    this.stream.maybeThrowError();
  }
  
  protected void onDisabled() {}
  
  protected void onEnabled(boolean paramBoolean) {}
  
  protected void onPositionReset(long paramLong, boolean paramBoolean) {}
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  protected void onStreamChanged(Format[] paramArrayOfFormat, long paramLong) {}
  
  protected final int readSource(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    int i = this.stream.readData(paramFormatHolder, paramDecoderInputBuffer, paramBoolean);
    if (i == -4)
    {
      if (paramDecoderInputBuffer.isEndOfStream())
      {
        this.readEndOfStream = true;
        if (this.streamIsFinal) {
          return -4;
        }
        return -3;
      }
      paramDecoderInputBuffer.timeUs += this.streamOffsetUs;
      return i;
    }
    if (i == -5)
    {
      paramDecoderInputBuffer = paramFormatHolder.format;
      if (paramDecoderInputBuffer.subsampleOffsetUs != 9223372036854775807L) {
        paramFormatHolder.format = paramDecoderInputBuffer.copyWithSubsampleOffsetUs(paramDecoderInputBuffer.subsampleOffsetUs + this.streamOffsetUs);
      }
    }
    return i;
  }
  
  public final void replaceStream(Format[] paramArrayOfFormat, SampleStream paramSampleStream, long paramLong)
  {
    Assertions.checkState(this.streamIsFinal ^ true);
    this.stream = paramSampleStream;
    this.readEndOfStream = false;
    this.streamOffsetUs = paramLong;
    onStreamChanged(paramArrayOfFormat, paramLong);
  }
  
  public final void resetPosition(long paramLong)
  {
    this.streamIsFinal = false;
    this.readEndOfStream = false;
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
  
  protected int skipSource(long paramLong)
  {
    return this.stream.skipData(paramLong - this.streamOffsetUs);
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
  
  public int supportsMixedMimeTypeAdaptation()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.BaseRenderer
 * JD-Core Version:    0.7.0.1
 */