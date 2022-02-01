package com.google.android.exoplayer2.ext.mediaplayer;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.ext.audio.AudioFrameManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer.Output;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer.Output;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.List;

class ExoMediaPlayer$RendererEventListener
  implements AudioRendererEventListener, MetadataRenderer.Output, TextRenderer.Output, VideoRendererEventListener
{
  private ExoMediaPlayer$RendererEventListener(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public boolean isNeedAudioData()
  {
    return (ExoMediaPlayer.access$1700(this.this$0) != null) || (ExoMediaPlayer.access$1800(this.this$0));
  }
  
  public void onAudioDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioDecoderInitialized decoderName=" + paramString + ",initializedTimestampMs" + paramLong1 + ",initializationDurationMs" + paramLong2);
    this.this$0.mAudioDecoderInfo = new DecoderInfo(1, paramString, paramLong2);
  }
  
  public void onAudioDisabled(DecoderCounters paramDecoderCounters) {}
  
  public void onAudioEnabled(DecoderCounters paramDecoderCounters)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioEnabled");
    ExoMediaPlayer.access$1602(this.this$0, 0);
  }
  
  public void onAudioInputFormatChanged(Format paramFormat)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioInputFormatChanged");
    this.this$0.mAudioFormat = paramFormat;
  }
  
  public void onAudioSessionId(int paramInt)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioSessionId " + paramInt);
    ExoMediaPlayer.access$1602(this.this$0, paramInt);
  }
  
  public void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioSinkUnderrun bufferSize=" + paramInt + ",bufferSizeMs" + paramLong1 + ",elapsedSinceLastFeedMs" + paramLong2);
  }
  
  public void onCues(List<Cue> paramList)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onCues");
  }
  
  public void onDroppedFrames(int paramInt, long paramLong)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onDroppedFrames");
  }
  
  public void onMetadata(Metadata paramMetadata)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onMetadata");
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte)
  {
    ExoMediaPlayer.getLogger().v("ExoMediaPlayer", "onRenderAudioData " + paramArrayOfByte.length);
    if ((ExoMediaPlayer.access$1800(this.this$0)) && (ExoMediaPlayer.access$1900(this.this$0) == null)) {
      ExoMediaPlayer.access$1902(this.this$0, new AudioFrameManager());
    }
    if (ExoMediaPlayer.access$1900(this.this$0) != null) {
      ExoMediaPlayer.access$1900(this.this$0).feedAudioData(paramArrayOfByte, this.this$0.mAudioFormat);
    }
    if (ExoMediaPlayer.access$1700(this.this$0) != null) {
      ExoMediaPlayer.access$1700(this.this$0).onRenderAudioData(paramArrayOfByte, this.this$0.mAudioFormat);
    }
  }
  
  public void onRenderedFirstFrame(Surface paramSurface)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onRenderedFirstFrame");
    if ((ExoMediaPlayer.access$700(this.this$0) != null) && (ExoMediaPlayer.access$1300(this.this$0) == paramSurface) && (ExoMediaPlayer.access$700(this.this$0).getPlayWhenReady()) && (!ExoMediaPlayer.access$1400(this.this$0)))
    {
      ExoMediaPlayer.access$1200(this.this$0, 3, 0);
      ExoMediaPlayer.access$1402(this.this$0, true);
    }
    ExoMediaPlayer.access$1502(this.this$0, true);
  }
  
  public void onVideoDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onAudioDecoderInitialized decoderName=" + paramString + ",initializedTimestampMs=" + paramLong1 + ",initializationDurationMs=" + paramLong2);
    this.this$0.mVideoDecoderInfo = new DecoderInfo(0, paramString, paramLong2);
  }
  
  public void onVideoDisabled(DecoderCounters paramDecoderCounters)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onVideoDisabled");
  }
  
  public void onVideoEnabled(DecoderCounters paramDecoderCounters)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onVideoEnabled");
  }
  
  public void onVideoInputFormatChanged(Format paramFormat)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onVideoInputFormatChanged");
    this.this$0.mVideoFormat = paramFormat;
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    ExoMediaPlayer.access$902(this.this$0, paramInt1);
    ExoMediaPlayer.access$1002(this.this$0, paramInt2);
    ExoMediaPlayer.access$1100(this.this$0, paramInt1, paramInt2, 1, 1);
    if (paramInt3 > 0) {
      ExoMediaPlayer.access$1200(this.this$0, 10001, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.RendererEventListener
 * JD-Core Version:    0.7.0.1
 */