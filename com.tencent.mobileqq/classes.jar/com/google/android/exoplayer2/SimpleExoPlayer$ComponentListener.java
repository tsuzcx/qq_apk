package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class SimpleExoPlayer$ComponentListener
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener
{
  private SimpleExoPlayer$ComponentListener(SimpleExoPlayer paramSimpleExoPlayer) {}
  
  public boolean isNeedAudioData()
  {
    return SimpleExoPlayer.access$700(this.this$0).size() > 0;
  }
  
  public void onAudioDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioDecoderInitialized(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onAudioDisabled(DecoderCounters paramDecoderCounters)
  {
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioDisabled(paramDecoderCounters);
    }
    SimpleExoPlayer.access$902(this.this$0, null);
    SimpleExoPlayer.access$602(this.this$0, null);
    SimpleExoPlayer.access$802(this.this$0, 0);
  }
  
  public void onAudioEnabled(DecoderCounters paramDecoderCounters)
  {
    SimpleExoPlayer.access$602(this.this$0, paramDecoderCounters);
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioEnabled(paramDecoderCounters);
    }
  }
  
  public void onAudioInputFormatChanged(Format paramFormat)
  {
    SimpleExoPlayer.access$902(this.this$0, paramFormat);
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioInputFormatChanged(paramFormat);
    }
  }
  
  public void onAudioSessionId(int paramInt)
  {
    SimpleExoPlayer.access$802(this.this$0, paramInt);
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioSessionId(paramInt);
    }
  }
  
  public void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onAudioSinkUnderrun(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void onCues(List<Cue> paramList)
  {
    Iterator localIterator = SimpleExoPlayer.access$1000(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((TextOutput)localIterator.next()).onCues(paramList);
    }
  }
  
  public void onDroppedFrames(int paramInt, long paramLong)
  {
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onDroppedFrames(paramInt, paramLong);
    }
  }
  
  public void onMetadata(Metadata paramMetadata)
  {
    Iterator localIterator = SimpleExoPlayer.access$1100(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((MetadataOutput)localIterator.next()).onMetadata(paramMetadata);
    }
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte)
  {
    Iterator localIterator = SimpleExoPlayer.access$700(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AudioRendererEventListener)localIterator.next()).onRenderAudioData(paramArrayOfByte);
    }
  }
  
  public void onRenderedFirstFrame(Surface paramSurface)
  {
    if (SimpleExoPlayer.access$500(this.this$0) == paramSurface)
    {
      localIterator = SimpleExoPlayer.access$400(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((VideoListener)localIterator.next()).onRenderedFirstFrame();
      }
    }
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onRenderedFirstFrame(paramSurface);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    SimpleExoPlayer.access$1200(this.this$0, new Surface(paramSurfaceTexture), true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    SimpleExoPlayer.access$1200(this.this$0, null, true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onVideoDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onVideoDecoderInitialized(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onVideoDisabled(DecoderCounters paramDecoderCounters)
  {
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onVideoDisabled(paramDecoderCounters);
    }
    SimpleExoPlayer.access$302(this.this$0, null);
    SimpleExoPlayer.access$102(this.this$0, null);
  }
  
  public void onVideoEnabled(DecoderCounters paramDecoderCounters)
  {
    SimpleExoPlayer.access$102(this.this$0, paramDecoderCounters);
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onVideoEnabled(paramDecoderCounters);
    }
  }
  
  public void onVideoInputFormatChanged(Format paramFormat)
  {
    SimpleExoPlayer.access$302(this.this$0, paramFormat);
    Iterator localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onVideoInputFormatChanged(paramFormat);
    }
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Iterator localIterator = SimpleExoPlayer.access$400(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoListener)localIterator.next()).onVideoSizeChanged(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    localIterator = SimpleExoPlayer.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoRendererEventListener)localIterator.next()).onVideoSizeChanged(paramInt1, paramInt2, paramInt3, paramFloat);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    SimpleExoPlayer.access$1200(this.this$0, paramSurfaceHolder.getSurface(), false);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    SimpleExoPlayer.access$1200(this.this$0, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener
 * JD-Core Version:    0.7.0.1
 */