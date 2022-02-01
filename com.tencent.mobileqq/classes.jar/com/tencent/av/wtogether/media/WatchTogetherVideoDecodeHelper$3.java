package com.tencent.av.wtogether.media;

import android.graphics.SurfaceTexture;

class WatchTogetherVideoDecodeHelper$3
  implements Runnable
{
  WatchTogetherVideoDecodeHelper$3(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WatchTogetherVideoDecodeHelper.a(this.this$0, this.a);
    WatchTogetherVideoDecodeHelper.b(this.this$0, this.b);
    WatchTogetherVideoDecodeHelper.a(this.this$0).setDefaultBufferSize(WatchTogetherVideoDecodeHelper.a(this.this$0), WatchTogetherVideoDecodeHelper.b(this.this$0));
    WatchTogetherVideoDecodeHelper.a(this.this$0, "onTextureDefaultSize");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.3
 * JD-Core Version:    0.7.0.1
 */