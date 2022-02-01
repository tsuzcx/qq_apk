package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.lang.ref.WeakReference;

class ProgressControler$2
  implements Runnable
{
  ProgressControler$2(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    if (this.this$0.e) {
      return;
    }
    if (this.this$0.d != null)
    {
      IVideoView localIVideoView = (IVideoView)this.this$0.d.get();
      if (localIVideoView == null) {
        return;
      }
      if (localIVideoView.h() > 0L)
      {
        this.this$0.a(localIVideoView.e(), localIVideoView.h(), localIVideoView);
        return;
      }
      this.this$0.g.postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */