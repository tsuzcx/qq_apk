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
    if (!WatchTogetherAdminControlView.g(this.a)) {
      return false;
    }
    paramView = SessionMgr.a().b();
    if ((WatchTogetherAdminControlView.g(this.a)) && (paramView != null) && (paramView.af)) {
      return false;
    }
    WatchTogetherAdminControlView.h(this.a);
    WatchTogetherAdminControlView.i(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.3
 * JD-Core Version:    0.7.0.1
 */