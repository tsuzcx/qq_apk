package com.tencent.av.wtogether.media;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class WatchTogetherVideoDecodeHelper$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  WatchTogetherVideoDecodeHelper$1(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    WatchTogetherVideoDecodeHelper.a(this.a, true);
    WatchTogetherVideoDecodeHelper.a(this.a, "onFrameAvailable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.1
 * JD-Core Version:    0.7.0.1
 */