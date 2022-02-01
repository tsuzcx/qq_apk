package com.tencent.av.wtogether.media;

class WatchTogetherVideoDecodeHelper$9
  implements Runnable
{
  WatchTogetherVideoDecodeHelper$9(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper) {}
  
  public void run()
  {
    WatchTogetherVideoDecodeHelper.a(this.this$0, null);
    WatchTogetherVideoDecodeHelper.b(this.this$0, false);
    WatchTogetherVideoDecodeHelper.d(this.this$0, false);
    if (!WatchTogetherVideoDecodeHelper.c(this.this$0))
    {
      WatchTogetherVideoDecodeHelper.a(this.this$0, "onResponsePauseMessage");
      return;
    }
    WatchTogetherVideoDecodeHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.9
 * JD-Core Version:    0.7.0.1
 */