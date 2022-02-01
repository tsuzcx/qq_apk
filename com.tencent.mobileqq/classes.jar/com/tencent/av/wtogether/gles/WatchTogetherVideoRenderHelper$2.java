package com.tencent.av.wtogether.gles;

import android.os.Build.VERSION;

class WatchTogetherVideoRenderHelper$2
  implements Runnable
{
  WatchTogetherVideoRenderHelper$2(WatchTogetherVideoRenderHelper paramWatchTogetherVideoRenderHelper) {}
  
  public void run()
  {
    if ((WatchTogetherVideoRenderHelper.b(this.this$0) != null) && (Build.VERSION.SDK_INT >= 16)) {
      synchronized (WatchTogetherVideoRenderHelper.b(this.this$0))
      {
        if (WatchTogetherVideoRenderHelper.c(this.this$0))
        {
          WatchTogetherVideoRenderHelper.b(this.this$0).d();
          WatchTogetherVideoRenderHelper.a(this.this$0, false);
        }
        WatchTogetherVideoRenderHelper.b(this.this$0).f();
        WatchTogetherVideoRenderHelper.a(this.this$0, -1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper.2
 * JD-Core Version:    0.7.0.1
 */