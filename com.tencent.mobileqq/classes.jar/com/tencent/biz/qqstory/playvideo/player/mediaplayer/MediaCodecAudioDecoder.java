package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.media.MediaCodec;
import android.media.MediaFormat;

class MediaCodecAudioDecoder
  extends MediaCodecDecoder
{
  private AudioPlayback b;
  
  public MediaCodecAudioDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener, AudioPlayback paramAudioPlayback)
  {
    super(paramMediaExtractor, paramBoolean, paramInt, paramOnDecoderEventListener);
    this.b = paramAudioPlayback;
    f();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    super.a(paramMediaCodec, paramMediaFormat);
    this.b.a(paramMediaFormat);
  }
  
  protected void a(MediaFormat paramMediaFormat)
  {
    this.b.a(paramMediaFormat);
  }
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, long paramLong)
  {
    this.b.a(paramFrameInfo.b, paramFrameInfo.c);
    b(paramFrameInfo);
  }
  
  protected boolean a()
  {
    if (!e()) {
      return this.b.h() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */