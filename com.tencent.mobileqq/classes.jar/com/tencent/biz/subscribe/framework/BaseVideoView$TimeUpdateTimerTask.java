package com.tencent.biz.subscribe.framework;

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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (BaseVideoView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((BaseVideoView)localObject).l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.TimeUpdateTimerTask
 * JD-Core Version:    0.7.0.1
 */