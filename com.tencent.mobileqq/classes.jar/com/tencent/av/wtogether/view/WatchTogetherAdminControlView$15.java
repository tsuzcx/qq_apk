package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.util.WTEntranceHelper;

class WatchTogetherAdminControlView$15
  implements Runnable
{
  WatchTogetherAdminControlView$15(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    if (WatchTogetherAdminControlView.a(this.this$0) != 3) {
      WatchTogetherAdminControlView.d(this.this$0).postDelayed(new WatchTogetherAdminControlView.15.1(this), WatchTogetherAdminControlView.t(this.this$0));
    }
    WatchTogetherAdminControlView.i(this.this$0);
    SessionInfo localSessionInfo = SessionMgr.a().b();
    WTEntranceHelper.a((Activity)WatchTogetherAdminControlView.u(this.this$0).getContext(), 2, localSessionInfo.p, localSessionInfo.s);
    AVUtil.a("0X800B630", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.15
 * JD-Core Version:    0.7.0.1
 */