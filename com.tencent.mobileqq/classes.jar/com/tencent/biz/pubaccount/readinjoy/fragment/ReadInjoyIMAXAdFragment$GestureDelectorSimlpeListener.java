package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ReadInjoyIMAXAdFragment$GestureDelectorSimlpeListener
  extends GestureDetector.SimpleOnGestureListener
{
  ReadInjoyIMAXAdFragment$GestureDelectorSimlpeListener(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1.getY() - paramMotionEvent2.getY() > 100.0F) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!ReadInjoyIMAXAdFragment.a(this.a)))
      {
        ReadInjoyIMAXAdFragment.a(this.a, true);
        ReadInjoyIMAXAdFragment.a(this.a);
        ReadInjoyIMAXAdFragment.a(this.a, this.a.getActivity().app, 17);
      }
      return true;
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ReadInjoyIMAXAdFragment.a(this.a)) {
      return true;
    }
    ReadInjoyIMAXAdFragment.a(this.a, true);
    ReadInjoyIMAXAdFragment.a(this.a);
    if (ReadInjoyIMAXAdFragment.a(this.a) != null) {
      ReadInjoyIMAXAdFragment.a(this.a, (int)ReadInjoyIMAXAdFragment.a(this.a).getCurrentPostion());
    }
    ReadInjoyIMAXAdFragment.a(this.a, ReadInjoyIMAXAdFragment.a(this.a), 19);
    ReadInjoyIMAXAdFragment.b(this.a, 2);
    if (ReadInjoyIMAXAdFragment.a(this.a) != null) {
      ReadInjoyIMAXAdFragment.c(this.a, (int)ReadInjoyIMAXAdFragment.a(this.a).getCurrentPostion());
    }
    ReadInjoyIMAXAdFragment.d(this.a, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.GestureDelectorSimlpeListener
 * JD-Core Version:    0.7.0.1
 */