package com.tencent.biz.qqcircle.immersive.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;

class QFSFullScreenVideoPresenter$3
  implements View.OnTouchListener
{
  QFSFullScreenVideoPresenter$3(QFSFullScreenVideoPresenter paramQFSFullScreenVideoPresenter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((QFSFullScreenVideoPresenter.g(this.a) != null) && (QFSFullScreenVideoPresenter.e(this.a) != null))
    {
      QFSFullScreenVideoPresenter.g(this.a).requestDisallowInterceptTouchEvent(true);
      QFSFullScreenVideoPresenter.e(this.a).onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.3
 * JD-Core Version:    0.7.0.1
 */