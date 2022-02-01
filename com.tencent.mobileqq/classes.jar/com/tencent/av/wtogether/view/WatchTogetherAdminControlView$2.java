package com.tencent.av.wtogether.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class WatchTogetherAdminControlView$2
  implements View.OnTouchListener
{
  WatchTogetherAdminControlView$2(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        paramView.setAlpha(1.0F);
        WatchTogetherAdminControlView.f(this.a);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.2
 * JD-Core Version:    0.7.0.1
 */