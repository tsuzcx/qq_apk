package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.lang.ref.WeakReference;

class NewProgressControler$2
  implements Runnable
{
  NewProgressControler$2(NewProgressControler paramNewProgressControler) {}
  
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
        NewProgressControler.a(this.this$0, localIVideoView.e(), localIVideoView.h());
        NewProgressControler.a(this.this$0);
        return;
      }
      this.this$0.g.postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */