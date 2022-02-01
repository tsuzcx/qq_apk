package com.tencent.av.wtogether.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;

class WatchTogetherOrdinaryControlView$3
  implements View.OnTouchListener
{
  WatchTogetherOrdinaryControlView$3(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!WatchTogetherOrdinaryControlView.a(this.a)) {}
    do
    {
      return false;
      paramView = SessionMgr.a().a();
    } while ((WatchTogetherOrdinaryControlView.a(this.a)) && (paramView != null) && (paramView.x));
    WatchTogetherOrdinaryControlView.b(this.a);
    WatchTogetherOrdinaryControlView.c(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.3
 * JD-Core Version:    0.7.0.1
 */