package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.VideoSink;

class WatchTogetherMediaPlayCtrl$1
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$1(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, VideoSink paramVideoSink) {}
  
  public void run()
  {
    VideoSink localVideoSink1 = WatchTogetherMediaPlayCtrl.a(this.this$0);
    VideoSink localVideoSink2 = this.a;
    if (localVideoSink1 != localVideoSink2)
    {
      if (localVideoSink2 == null) {
        return;
      }
      WatchTogetherMediaPlayCtrl.a(this.this$0, localVideoSink2);
      WatchTogetherMediaPlayCtrl.b(this.this$0);
      WatchTogetherMediaPlayCtrl.c(this.this$0).a(WatchTogetherMediaPlayCtrl.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.1
 * JD-Core Version:    0.7.0.1
 */