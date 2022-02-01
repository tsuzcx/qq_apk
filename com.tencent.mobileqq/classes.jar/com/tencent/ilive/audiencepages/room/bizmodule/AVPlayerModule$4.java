package com.tencent.ilive.audiencepages.room.bizmodule;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.PlayerTouchEvent;

class AVPlayerModule$4
  implements View.OnTouchListener
{
  AVPlayerModule$4(AVPlayerModule paramAVPlayerModule) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = new PlayerTouchEvent();
    paramView.motionEvent = paramMotionEvent;
    this.this$0.getEvent().syncPost(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.4
 * JD-Core Version:    0.7.0.1
 */