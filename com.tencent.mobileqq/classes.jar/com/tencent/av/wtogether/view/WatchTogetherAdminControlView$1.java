package com.tencent.av.wtogether.view;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherAdminControlView$1
  implements Runnable
{
  WatchTogetherAdminControlView$1(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    if ((WatchTogetherAdminControlView.a(this.this$0) != 2) && ((WatchTogetherAdminControlView.a(this.this$0) != 1) || (WatchTogetherAdminControlView.b(this.this$0) != 2)) && (WatchTogetherAdminControlView.a(this.this$0) != 0))
    {
      WatchTogetherAdminControlView.d(this.this$0).removeCallbacks(WatchTogetherAdminControlView.c(this.this$0));
      WatchTogetherAdminControlView.d(this.this$0).postDelayed(WatchTogetherAdminControlView.c(this.this$0), WatchTogetherAdminControlView.e(this.this$0));
    }
    else
    {
      WatchTogetherAdminControlView.a(this.this$0, 0, 2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run mEnterImmersiveStatus:=");
    localStringBuilder.append(WatchTogetherAdminControlView.a(this.this$0));
    QLog.d("WatchTogetherVideoPlayView", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.1
 * JD-Core Version:    0.7.0.1
 */