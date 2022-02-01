package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ReadInjoyIMAXAdFragment$GestureDelectorSimlpeListener
  extends GestureDetector.SimpleOnGestureListener
{
  ReadInjoyIMAXAdFragment$GestureDelectorSimlpeListener(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i;
    if (paramMotionEvent1.getY() - paramMotionEvent2.getY() > 100.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!ReadInjoyIMAXAdFragment.a(this.a)))
    {
      ReadInjoyIMAXAdFragment.a(this.a, true);
      ReadInjoyIMAXAdFragment.b(this.a);
      paramMotionEvent1 = this.a;
      ReadInjoyIMAXAdFragment.a(paramMotionEvent1, paramMotionEvent1.getBaseActivity().app, 17);
    }
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ReadInjoyIMAXAdFragment.a(this.a)) {
      return true;
    }
    ReadInjoyIMAXAdFragment.a(this.a, true);
    ReadInjoyIMAXAdFragment.b(this.a);
    if (ReadInjoyIMAXAdFragment.c(this.a) != null)
    {
      paramMotionEvent = this.a;
      ReadInjoyIMAXAdFragment.a(paramMotionEvent, (int)ReadInjoyIMAXAdFragment.c(paramMotionEvent).getCurrentPostion());
    }
    paramMotionEvent = this.a;
    ReadInjoyIMAXAdFragment.a(paramMotionEvent, ReadInjoyIMAXAdFragment.d(paramMotionEvent), 19);
    ReadInjoyIMAXAdFragment.b(this.a, 2);
    if (ReadInjoyIMAXAdFragment.c(this.a) != null)
    {
      paramMotionEvent = this.a;
      ReadInjoyIMAXAdFragment.c(paramMotionEvent, (int)ReadInjoyIMAXAdFragment.c(paramMotionEvent).getCurrentPostion());
    }
    ReadInjoyIMAXAdFragment.d(this.a, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.GestureDelectorSimlpeListener
 * JD-Core Version:    0.7.0.1
 */