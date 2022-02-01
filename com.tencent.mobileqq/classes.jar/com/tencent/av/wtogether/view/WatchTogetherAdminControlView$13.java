package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.util.WTEntranceHelper;

class WatchTogetherAdminControlView$13
  implements Runnable
{
  WatchTogetherAdminControlView$13(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    if (WatchTogetherAdminControlView.a(this.this$0) != 3) {
      WatchTogetherAdminControlView.a(this.this$0).postDelayed(new WatchTogetherAdminControlView.13.1(this), WatchTogetherAdminControlView.d(this.this$0));
    }
    WatchTogetherAdminControlView.c(this.this$0);
    SessionInfo localSessionInfo = SessionMgr.a().a();
    WTEntranceHelper.a((Activity)WatchTogetherAdminControlView.a(this.this$0).getContext(), 2, localSessionInfo.j, localSessionInfo.d);
    AVUtil.a("0X800B630", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.13
 * JD-Core Version:    0.7.0.1
 */