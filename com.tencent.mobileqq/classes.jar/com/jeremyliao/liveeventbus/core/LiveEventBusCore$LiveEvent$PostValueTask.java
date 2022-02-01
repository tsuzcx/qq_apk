package com.jeremyliao.liveeventbus.core;

import android.support.annotation.NonNull;

class LiveEventBusCore$LiveEvent$PostValueTask
  implements Runnable
{
  private Object newValue;
  
  public LiveEventBusCore$LiveEvent$PostValueTask(LiveEventBusCore.LiveEvent paramLiveEvent, @NonNull Object paramObject)
  {
    this.newValue = paramObject;
  }
  
  public void run()
  {
    LiveEventBusCore.LiveEvent.access$1800(this.this$1, this.newValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.PostValueTask
 * JD-Core Version:    0.7.0.1
 */