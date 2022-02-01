package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherVideoDecodeHelper$4
  implements Runnable
{
  WatchTogetherVideoDecodeHelper$4(WatchTogetherVideoDecodeHelper paramWatchTogetherVideoDecodeHelper, VideoSink paramVideoSink) {}
  
  public void run()
  {
    if (WatchTogetherVideoDecodeHelper.a(this.this$0) != null) {
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "should release lastest videoSink");
    }
    WatchTogetherVideoDecodeHelper.a(this.this$0, this.a);
    WatchTogetherVideoDecodeHelper.b(this.this$0, true);
    WatchTogetherVideoDecodeHelper.a(this.this$0, true);
    this.a.a();
    WatchTogetherVideoDecodeHelper.a(this.this$0, "startVideoSinkListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.4
 * JD-Core Version:    0.7.0.1
 */