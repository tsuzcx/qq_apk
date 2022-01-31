package com.tencent.TMG.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;

class AndroidCodec$1
  extends MediaCodec.Callback
{
  AndroidCodec$1(AndroidCodec paramAndroidCodec, IMediaCodecCallback paramIMediaCodecCallback) {}
  
  public void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
  {
    if (this.val$cb != null) {
      this.val$cb.onError(paramMediaCodec, paramCodecException);
    }
  }
  
  public void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    if (this.val$cb != null) {
      this.val$cb.onInputBufferAvailable(paramMediaCodec, paramInt);
    }
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.val$cb != null) {
      this.val$cb.onOutputBufferAvailable(paramMediaCodec, paramInt, paramBufferInfo);
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.val$cb != null) {
      this.val$cb.onOutputFormatChanged(paramMediaCodec, paramMediaFormat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.AndroidCodec.1
 * JD-Core Version:    0.7.0.1
 */