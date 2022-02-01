package com.jeremyliao.liveeventbus.core;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class LiveEventBusCore$LiveEvent$PostLifeValueTask
  implements Runnable
{
  private Object newValue;
  private LifecycleOwner owner;
  
  public LiveEventBusCore$LiveEvent$PostLifeValueTask(LiveEventBusCore.LiveEvent paramLiveEvent, @NonNull Object paramObject, @Nullable LifecycleOwner paramLifecycleOwner)
  {
    this.newValue = paramObject;
    this.owner = paramLifecycleOwner;
  }
  
  public void run()
  {
    if ((this.owner != null) && (this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))) {
      LiveEventBusCore.LiveEvent.access$1800(this.this$1, this.newValue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.PostLifeValueTask
 * JD-Core Version:    0.7.0.1
 */