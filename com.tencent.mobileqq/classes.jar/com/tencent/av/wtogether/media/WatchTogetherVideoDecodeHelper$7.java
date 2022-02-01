package com.tencent.av.wtogether.media;

class WatchTogetherVideoDecodeHelper$7
  implements Runnable
{
  WatchTogetherVideoDecodeHelper$7(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper) {}
  
  public void run()
  {
    WatchTogetherVideoDecodeHelper.d(this.this$0, false);
    WatchTogetherVideoDecodeHelper.b(this.this$0, false);
    WatchTogetherVideoDecodeHelper.a(this.this$0, null);
    WatchTogetherVideoDecodeHelper.a(this.this$0, true);
    if (!WatchTogetherVideoDecodeHelper.c(this.this$0))
    {
      WatchTogetherVideoDecodeHelper.a(this.this$0, "onLostEglContext");
      return;
    }
    WatchTogetherVideoDecodeHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.7
 * JD-Core Version:    0.7.0.1
 */