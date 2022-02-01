package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.PlayerTouchEvent;

class AVPreloadPlayerModule$4
  implements View.OnTouchListener
{
  AVPreloadPlayerModule$4(AVPreloadPlayerModule paramAVPreloadPlayerModule) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = new PlayerTouchEvent();
    paramView.motionEvent = paramMotionEvent;
    this.a.getEvent().syncPost(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.4
 * JD-Core Version:    0.7.0.1
 */