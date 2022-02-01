package com.tencent.av.wtogether.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;

class WatchTogetherAdminControlView$3
  implements View.OnTouchListener
{
  WatchTogetherAdminControlView$3(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!WatchTogetherAdminControlView.a(this.a)) {
      return false;
    }
    paramView = SessionMgr.a().a();
    if ((WatchTogetherAdminControlView.a(this.a)) && (paramView != null) && (paramView.w)) {
      return false;
    }
    WatchTogetherAdminControlView.b(this.a);
    WatchTogetherAdminControlView.c(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.3
 * JD-Core Version:    0.7.0.1
 */