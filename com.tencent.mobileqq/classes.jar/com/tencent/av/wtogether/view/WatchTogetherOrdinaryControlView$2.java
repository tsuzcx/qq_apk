package com.tencent.av.wtogether.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class WatchTogetherOrdinaryControlView$2
  implements View.OnTouchListener
{
  WatchTogetherOrdinaryControlView$2(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        paramView.setAlpha(1.0F);
        WatchTogetherOrdinaryControlView.a(this.a);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.2
 * JD-Core Version:    0.7.0.1
 */