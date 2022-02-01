package com.tencent.av.wtogether.view;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherAdminControlView$1
  implements Runnable
{
  WatchTogetherAdminControlView$1(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    if ((WatchTogetherAdminControlView.a(this.this$0) == 2) || ((WatchTogetherAdminControlView.a(this.this$0) == 1) && (WatchTogetherAdminControlView.b(this.this$0) == 2)) || (WatchTogetherAdminControlView.a(this.this$0) == 0)) {
      WatchTogetherAdminControlView.a(this.this$0, 0, 2);
    }
    for (;;)
    {
      QLog.d("WatchTogetherVideoPlayView", 1, "run mEnterImmersiveStatus:=" + WatchTogetherAdminControlView.a(this.this$0));
      return;
      WatchTogetherAdminControlView.a(this.this$0).removeCallbacks(WatchTogetherAdminControlView.a(this.this$0));
      WatchTogetherAdminControlView.a(this.this$0).postDelayed(WatchTogetherAdminControlView.a(this.this$0), WatchTogetherAdminControlView.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.1
 * JD-Core Version:    0.7.0.1
 */