package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.media.MediaCodec;
import android.media.MediaFormat;

class MediaCodecAudioDecoder
  extends MediaCodecDecoder
{
  private AudioPlayback a;
  
  public MediaCodecAudioDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener, AudioPlayback paramAudioPlayback)
  {
    super(paramMediaExtractor, paramBoolean, paramInt, paramOnDecoderEventListener);
    this.a = paramAudioPlayback;
    a();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    super.a(paramMediaCodec, paramMediaFormat);
    this.a.a(paramMediaFormat);
  }
  
  protected void a(MediaFormat paramMediaFormat)
  {
    this.a.a(paramMediaFormat);
  }
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, long paramLong)
  {
    this.a.a(paramFrameInfo.jdField_a_of_type_JavaNioByteBuffer, paramFrameInfo.jdField_a_of_type_Long);
    b(paramFrameInfo);
  }
  
  protected boolean a()
  {
    if (!c()) {
      return this.a.a() < 200000L;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */