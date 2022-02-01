package com.tencent.luggage.wxa.ap;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;
import androidx.annotation.NonNull;

@TargetApi(23)
final class e$b
  implements MediaCodec.OnFrameRenderedListener
{
  private e$b(e parame, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
  }
  
  public void onFrameRendered(@NonNull MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
  {
    if (this != this.a.b) {
      return;
    }
    this.a.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.e.b
 * JD-Core Version:    0.7.0.1
 */