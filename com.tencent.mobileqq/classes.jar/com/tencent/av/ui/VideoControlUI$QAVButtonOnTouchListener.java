package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class VideoControlUI$QAVButtonOnTouchListener
  implements View.OnTouchListener
{
  WeakReference<VideoControlUI> a;
  
  VideoControlUI$QAVButtonOnTouchListener(VideoControlUI paramVideoControlUI)
  {
    this.a = new WeakReference(paramVideoControlUI);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (VideoControlUI)this.a.get();
    if (paramView != null) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      paramView.D(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.QAVButtonOnTouchListener
 * JD-Core Version:    0.7.0.1
 */