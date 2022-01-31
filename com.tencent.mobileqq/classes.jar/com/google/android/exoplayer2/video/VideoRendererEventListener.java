package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public abstract interface VideoRendererEventListener
{
  public abstract void onDroppedFrames(int paramInt, long paramLong);
  
  public abstract void onRenderedFirstFrame(Surface paramSurface);
  
  public abstract void onVideoDecoderInitialized(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onVideoDisabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onVideoEnabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onVideoInputFormatChanged(Format paramFormat);
  
  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener
 * JD-Core Version:    0.7.0.1
 */