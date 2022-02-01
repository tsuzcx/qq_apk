package com.jeremyliao.liveeventbus.core;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import com.jeremyliao.liveeventbus.ipc.encode.IEncoder;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

class LiveEventBusCore$LiveEvent<T>
  implements Observable<T>
{
  @NonNull
  private final String key;
  private final LiveEvent<T>.LifecycleLiveData<T> liveData;
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  private final Map<Observer, LiveEventBusCore.ObserverWrapper<T>> observerMap = new HashMap();
  
  LiveEventBusCore$LiveEvent(LiveEventBusCore paramLiveEventBusCore, @NonNull String paramString)
  {
    this.key = paramString;
    this.liveData = new LiveEventBusCore.LiveEvent.LifecycleLiveData(this, null);
  }
  
  @MainThread
  private void broadcastInternal(T paramT, boolean paramBoolean)
  {
    LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "broadcast: " + paramT + " foreground: " + paramBoolean + " with key: " + this.key);
    Intent localIntent = new Intent("intent.action.ACTION_LEB_IPC");
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 16)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("leb_ipc_key", this.key);
    try
    {
      LiveEventBusCore.access$1100(this.this$0).encode(localIntent, paramT);
      LiveEventBusCore.access$300(this.this$0).sendBroadcast(localIntent);
      return;
    }
    catch (Exception paramT)
    {
      paramT.printStackTrace();
    }
  }
  
  @MainThread
  private void observeForeverInternal(@NonNull Observer<T> paramObserver)
  {
    LiveEventBusCore.ObserverWrapper localObserverWrapper = new LiveEventBusCore.ObserverWrapper(this.this$0, paramObserver);
    if (this.liveData.getVersion() > -1) {}
    for (boolean bool = true;; bool = false)
    {
      LiveEventBusCore.ObserverWrapper.access$1202(localObserverWrapper, bool);
      this.observerMap.put(paramObserver, localObserverWrapper);
      this.liveData.observeForever(localObserverWrapper);
      LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "observe forever observer: " + localObserverWrapper + "(" + paramObserver + ") with key: " + this.key);
      return;
    }
  }
  
  @MainThread
  private void observeInternal(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    LiveEventBusCore.ObserverWrapper localObserverWrapper = new LiveEventBusCore.ObserverWrapper(this.this$0, paramObserver);
    if (this.liveData.getVersion() > -1) {}
    for (boolean bool = true;; bool = false)
    {
      LiveEventBusCore.ObserverWrapper.access$1202(localObserverWrapper, bool);
      this.liveData.observe(paramLifecycleOwner, localObserverWrapper);
      LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "observe observer: " + localObserverWrapper + "(" + paramObserver + ") on owner: " + paramLifecycleOwner + " with key: " + this.key);
      return;
    }
  }
  
  @MainThread
  private void observeStickyForeverInternal(@NonNull Observer<T> paramObserver)
  {
    LiveEventBusCore.ObserverWrapper localObserverWrapper = new LiveEventBusCore.ObserverWrapper(this.this$0, paramObserver);
    this.observerMap.put(paramObserver, localObserverWrapper);
    this.liveData.observeForever(localObserverWrapper);
    LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "observe sticky forever observer: " + localObserverWrapper + "(" + paramObserver + ") with key: " + this.key);
  }
  
  @MainThread
  private void observeStickyInternal(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    LiveEventBusCore.ObserverWrapper localObserverWrapper = new LiveEventBusCore.ObserverWrapper(this.this$0, paramObserver);
    this.liveData.observe(paramLifecycleOwner, localObserverWrapper);
    LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "observe sticky observer: " + localObserverWrapper + "(" + paramObserver + ") on owner: " + paramLifecycleOwner + " with key: " + this.key);
  }
  
  @MainThread
  private void postInternal(T paramT)
  {
    LiveEventBusCore.access$1000(this.this$0).log(Level.INFO, "post: " + paramT + " with key: " + this.key);
    this.liveData.setValue(paramT);
  }
  
  @MainThread
  private void removeObserverInternal(@NonNull Observer<T> paramObserver)
  {
    if (this.observerMap.containsKey(paramObserver)) {
      paramObserver = (Observer)this.observerMap.remove(paramObserver);
    }
    for (;;)
    {
      this.liveData.removeObserver(paramObserver);
      return;
    }
  }
  
  public void broadcast(T paramT)
  {
    broadcast(paramT, false);
  }
  
  public void broadcast(T paramT, boolean paramBoolean)
  {
    if (LiveEventBusCore.access$300(this.this$0) != null)
    {
      if (ThreadUtils.isMainThread())
      {
        broadcastInternal(paramT, paramBoolean);
        return;
      }
      this.mainHandler.post(new LiveEventBusCore.LiveEvent.1(this, paramT, paramBoolean));
      return;
    }
    post(paramT);
  }
  
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    if (ThreadUtils.isMainThread())
    {
      observeInternal(paramLifecycleOwner, paramObserver);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.2(this, paramLifecycleOwner, paramObserver));
  }
  
  public void observeForever(@NonNull Observer<T> paramObserver)
  {
    if (ThreadUtils.isMainThread())
    {
      observeForeverInternal(paramObserver);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.4(this, paramObserver));
  }
  
  public void observeSticky(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    if (ThreadUtils.isMainThread())
    {
      observeStickyInternal(paramLifecycleOwner, paramObserver);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.3(this, paramLifecycleOwner, paramObserver));
  }
  
  public void observeStickyForever(@NonNull Observer<T> paramObserver)
  {
    if (ThreadUtils.isMainThread())
    {
      observeStickyForeverInternal(paramObserver);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.5(this, paramObserver));
  }
  
  public void post(T paramT)
  {
    if (ThreadUtils.isMainThread())
    {
      postInternal(paramT);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.PostValueTask(this, paramT));
  }
  
  public void postDelay(LifecycleOwner paramLifecycleOwner, T paramT, long paramLong)
  {
    this.mainHandler.postDelayed(new LiveEventBusCore.LiveEvent.PostLifeValueTask(this, paramT, paramLifecycleOwner), paramLong);
  }
  
  public void postDelay(T paramT, long paramLong)
  {
    this.mainHandler.postDelayed(new LiveEventBusCore.LiveEvent.PostValueTask(this, paramT), paramLong);
  }
  
  public void postOrderly(T paramT)
  {
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.PostValueTask(this, paramT));
  }
  
  public void removeObserver(@NonNull Observer<T> paramObserver)
  {
    if (ThreadUtils.isMainThread())
    {
      removeObserverInternal(paramObserver);
      return;
    }
    this.mainHandler.post(new LiveEventBusCore.LiveEvent.6(this, paramObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent
 * JD-Core Version:    0.7.0.1
 */