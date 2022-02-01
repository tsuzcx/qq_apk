package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherMediaPlayCtrl$2
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$2(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, VideoSink paramVideoSink) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a != WatchTogetherMediaPlayCtrl.a(this.this$0))) {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "removeVideoSink may call later");
    }
    do
    {
      return;
      WatchTogetherMediaPlayCtrl.a(this.this$0, null);
    } while (WatchTogetherMediaPlayCtrl.a(this.this$0) == null);
    WatchTogetherMediaPlayCtrl.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.2
 * JD-Core Version:    0.7.0.1
 */