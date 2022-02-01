package com.jeremyliao.liveeventbus.core;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import java.util.logging.Level;

class LiveEventBusCore$ObserverWrapper<T>
  implements Observer<T>
{
  @NonNull
  private final Observer<T> observer;
  private boolean preventNextEvent = false;
  
  LiveEventBusCore$ObserverWrapper(Observer<T> paramObserver)
  {
    Object localObject;
    this.observer = localObject;
  }
  
  public void onChanged(@Nullable T paramT)
  {
    if (this.preventNextEvent)
    {
      this.preventNextEvent = false;
      return;
    }
    LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "message received: " + paramT);
    try
    {
      this.observer.onChanged(paramT);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      LiveEventBusCore.access$1000(this.this$0).log(Level.WARNING, "class cast error on message received: " + paramT, localClassCastException);
      return;
    }
    catch (Exception localException)
    {
      LiveEventBusCore.access$1000(this.this$0).log(Level.WARNING, "error on message received: " + paramT, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */