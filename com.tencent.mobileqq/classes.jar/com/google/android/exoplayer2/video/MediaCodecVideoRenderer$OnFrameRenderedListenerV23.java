package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;
import android.support.annotation.NonNull;

@TargetApi(23)
final class MediaCodecVideoRenderer$OnFrameRenderedListenerV23
  implements MediaCodec.OnFrameRenderedListener
{
  private MediaCodecVideoRenderer$OnFrameRenderedListenerV23(MediaCodecVideoRenderer paramMediaCodecVideoRenderer, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
  }
  
  public void onFrameRendered(@NonNull MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
  {
    if (this != this.this$0.tunnelingOnFrameRenderedListener) {
      return;
    }
    this.this$0.maybeNotifyRenderedFirstFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.MediaCodecVideoRenderer.OnFrameRenderedListenerV23
 * JD-Core Version:    0.7.0.1
 */