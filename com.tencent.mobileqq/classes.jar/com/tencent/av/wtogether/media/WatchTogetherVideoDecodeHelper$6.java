package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.VideoSink;

class WatchTogetherVideoDecodeHelper$6
  implements Runnable
{
  WatchTogetherVideoDecodeHelper$6(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper) {}
  
  public void run()
  {
    WatchTogetherVideoDecodeHelper.c(this.this$0, true);
    if (!WatchTogetherVideoDecodeHelper.f(this.this$0))
    {
      WatchTogetherVideoDecodeHelper.g(this.this$0);
      return;
    }
    if (WatchTogetherVideoDecodeHelper.d(this.this$0) != null) {
      WatchTogetherVideoDecodeHelper.d(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.6
 * JD-Core Version:    0.7.0.1
 */