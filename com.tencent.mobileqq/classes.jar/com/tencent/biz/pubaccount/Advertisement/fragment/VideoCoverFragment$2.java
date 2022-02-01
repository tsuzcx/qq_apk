package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

class VideoCoverFragment$2
  implements View.OnTouchListener
{
  VideoCoverFragment$2(VideoCoverFragment paramVideoCoverFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      VideoCoverFragment.b(this.a).b();
      if (!this.a.a())
      {
        if (VideoCoverFragment.c(this.a))
        {
          this.a.a(false);
          return false;
        }
        this.a.a(true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.2
 * JD-Core Version:    0.7.0.1
 */