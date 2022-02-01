package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

class SubScribeSwipeRefreshLayout$1
  implements TopGestureLayout.InterceptTouchEventListener
{
  SubScribeSwipeRefreshLayout$1(SubScribeSwipeRefreshLayout paramSubScribeSwipeRefreshLayout) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      if (SubScribeSwipeRefreshLayout.a(this.a) != null)
      {
        SubScribeSwipeRefreshLayout.a(this.a).getLocalVisibleRect(SubScribeSwipeRefreshLayout.b(this.a));
        if (SubScribeSwipeRefreshLayout.b(this.a).contains(i, j)) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */