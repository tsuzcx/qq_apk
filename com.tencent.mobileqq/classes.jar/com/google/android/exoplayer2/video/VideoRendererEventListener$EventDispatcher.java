package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

public final class VideoRendererEventListener$EventDispatcher
{
  @Nullable
  private final Handler handler;
  @Nullable
  private final VideoRendererEventListener listener;
  
  public VideoRendererEventListener$EventDispatcher(@Nullable Handler paramHandler, @Nullable VideoRendererEventListener paramVideoRendererEventListener)
  {
    if (paramVideoRendererEventListener != null) {
      paramHandler = (Handler)Assertions.checkNotNull(paramHandler);
    } else {
      paramHandler = null;
    }
    this.handler = paramHandler;
    this.listener = paramVideoRendererEventListener;
  }
  
  public void decoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.2(this, paramString, paramLong1, paramLong2));
    }
  }
  
  public void disabled(DecoderCounters paramDecoderCounters)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.7(this, paramDecoderCounters));
    }
  }
  
  public void droppedFrames(int paramInt, long paramLong)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.4(this, paramInt, paramLong));
    }
  }
  
  public void enabled(DecoderCounters paramDecoderCounters)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.1(this, paramDecoderCounters));
    }
  }
  
  public void inputFormatChanged(Format paramFormat)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.3(this, paramFormat));
    }
  }
  
  public void renderedFirstFrame(Surface paramSurface)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.6(this, paramSurface));
    }
  }
  
  public void videoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (this.listener != null) {
      this.handler.post(new VideoRendererEventListener.EventDispatcher.5(this, paramInt1, paramInt2, paramInt3, paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */