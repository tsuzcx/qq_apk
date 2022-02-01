package com.tencent.biz.qqcircle.immersive.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;

class QFSFeedChildVideoPresenter$2
  implements View.OnTouchListener
{
  QFSFeedChildVideoPresenter$2(QFSFeedChildVideoPresenter paramQFSFeedChildVideoPresenter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QFSFeedChildVideoPresenter.b(this.a).requestDisallowInterceptTouchEvent(true);
    QFSFeedChildVideoPresenter.c(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.2
 * JD-Core Version:    0.7.0.1
 */