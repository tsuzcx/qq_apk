package com.tencent.biz.qqcircle.widgets;

import java.util.TimerTask;
import mqq.util.WeakReference;

class BaseVideoView$TimeUpdateTimerTask
  extends TimerTask
{
  private WeakReference<BaseVideoView> a;
  
  BaseVideoView$TimeUpdateTimerTask(BaseVideoView paramBaseVideoView)
  {
    this.a = new WeakReference(paramBaseVideoView);
  }
  
  public void run()
  {
    if (this.a != null)
    {
      BaseVideoView localBaseVideoView = (BaseVideoView)this.a.get();
      if (localBaseVideoView != null) {
        localBaseVideoView.j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.BaseVideoView.TimeUpdateTimerTask
 * JD-Core Version:    0.7.0.1
 */