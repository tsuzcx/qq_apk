package com.jeremyliao.liveeventbus.core;

import android.arch.lifecycle.ExternalLiveData;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import java.util.Map;
import java.util.logging.Level;

class LiveEventBusCore$LiveEvent$LifecycleLiveData<T>
  extends ExternalLiveData<T>
{
  private LiveEventBusCore$LiveEvent$LifecycleLiveData(LiveEventBusCore.LiveEvent paramLiveEvent) {}
  
  public Lifecycle.State observerActiveLevel()
  {
    if (LiveEventBusCore.access$1300(this.this$1.this$0)) {
      return Lifecycle.State.CREATED;
    }
    return Lifecycle.State.STARTED;
  }
  
  public void removeObserver(@NonNull Observer<T> paramObserver)
  {
    super.removeObserver(paramObserver);
    if ((LiveEventBusCore.access$1400(this.this$1.this$0)) && (!LiveEventBusCore.LiveEvent.access$1500(this.this$1).hasObservers())) {
      LiveEventBusCore.access$1700(LiveEventBusCore.get()).remove(LiveEventBusCore.LiveEvent.access$1600(this.this$1));
    }
    LiveEventBusCore.access$1000(this.this$1.this$0).log(Level.INFO, "observer removed: " + paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.LifecycleLiveData
 * JD-Core Version:    0.7.0.1
 */