package com.tencent.falco.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadCenter$ThreadImpl
{
  private static final String TAG = "threadimpl_log";
  private ConcurrentHashMap<Object, Runnable> delayTasks = new ConcurrentHashMap();
  private boolean isInit = false;
  private ConcurrentHashMap<Integer, Handler> mHandlerMap = new ConcurrentHashMap();
  private int poolSize = 2;
  private ConcurrentHashMap<String, ThreadCenter.CoreHandler> singleHandlers = new ConcurrentHashMap();
  private Handler timerTask;
  private ThreadPoolExecutor workerThread;
  
  public ThreadCenter$ThreadImpl()
  {
    if (this.isInit) {
      return;
    }
    this.isInit = true;
    Object localObject = new HandlerThread("basetimer");
    ((HandlerThread)localObject).start();
    this.timerTask = new Handler(((HandlerThread)localObject).getLooper());
    int i = Runtime.getRuntime().availableProcessors();
    if (i > 0) {
      this.poolSize = i;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("thread pool size ");
    ((StringBuilder)localObject).append(this.poolSize);
    Log.v("threadimpl_log", ((StringBuilder)localObject).toString());
    i = this.poolSize;
    this.workerThread = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
    runIdleCheck();
    Log.v("threadimpl_log", "thread create ok");
  }
  
  private void runIdleCheck()
  {
    this.timerTask.postDelayed(new ThreadCenter.ThreadImpl.2(this), 300000L);
  }
  
  public void clear(ThreadCenter.HandlerKeyable paramHandlerKeyable)
  {
    Handler localHandler = (Handler)this.mHandlerMap.get(Integer.valueOf(paramHandlerKeyable.hashCode()));
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandlerMap.remove(Integer.valueOf(paramHandlerKeyable.hashCode()));
    }
  }
  
  public Handler getHandler(String paramString)
  {
    Object localObject1;
    if (this.singleHandlers.containsKey(paramString)) {
      localObject1 = (ThreadCenter.CoreHandler)this.singleHandlers.get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ThreadCenter.CoreHandler(paramString);
      this.singleHandlers.put(paramString, localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create new thread: ");
      ((StringBuilder)localObject1).append(paramString);
      Log.v("threadimpl_log", ((StringBuilder)localObject1).toString());
    }
    return ((ThreadCenter.CoreHandler)localObject2).getHandler();
  }
  
  public void postLogicTask(Runnable paramRunnable, long paramLong, boolean paramBoolean, String paramString)
  {
    if (paramRunnable == null) {
      return;
    }
    if (paramString == null)
    {
      int i = 10;
      if (paramLong > 0L)
      {
        paramString = new ThreadCenter.ThreadImpl.1(this, paramRunnable, new ThreadCenter.TaskProxy(10, paramRunnable));
        this.delayTasks.put(paramRunnable, paramString);
        this.timerTask.postDelayed(paramString, paramLong);
        return;
      }
      paramString = this.workerThread;
      if (paramBoolean) {
        i = 0;
      }
      paramString.execute(new ThreadCenter.TaskProxy(i, paramRunnable));
      return;
    }
    Object localObject1 = null;
    if (this.singleHandlers.containsKey(paramString)) {
      localObject1 = (ThreadCenter.CoreHandler)this.singleHandlers.get(paramString);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ThreadCenter.CoreHandler(paramString);
      this.singleHandlers.put(paramString, localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create new thread: ");
      ((StringBuilder)localObject1).append(paramString);
      Log.v("threadimpl_log", ((StringBuilder)localObject1).toString());
    }
    if (paramLong > 0L)
    {
      ((ThreadCenter.CoreHandler)localObject2).postDelayed(paramRunnable, paramLong);
      return;
    }
    ((ThreadCenter.CoreHandler)localObject2).post(paramRunnable, paramBoolean);
  }
  
  public void postMainTask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    ThreadCenter.HandlerKeyable localHandlerKeyable = paramHandlerKeyable;
    if (paramHandlerKeyable == null) {
      localHandlerKeyable = ThreadCenter.sDefaultHandlerKey;
    }
    Handler localHandler = (Handler)this.mHandlerMap.get(Integer.valueOf(localHandlerKeyable.hashCode()));
    paramHandlerKeyable = localHandler;
    if (localHandler == null)
    {
      paramHandlerKeyable = new Handler(Looper.getMainLooper());
      this.mHandlerMap.put(Integer.valueOf(localHandlerKeyable.hashCode()), paramHandlerKeyable);
    }
    if (paramLong > 0L)
    {
      paramHandlerKeyable.postDelayed(paramRunnable, paramLong);
      return;
    }
    if (paramBoolean)
    {
      paramHandlerKeyable.postAtFrontOfQueue(paramRunnable);
      return;
    }
    paramHandlerKeyable.post(paramRunnable);
  }
  
  public void removeLogicTask(Runnable paramRunnable, String paramString)
  {
    if (paramRunnable == null) {
      return;
    }
    Object localObject;
    if (paramString == null)
    {
      localObject = this.delayTasks.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramString = ((Iterator)localObject).next();
        if (paramString == paramRunnable)
        {
          paramRunnable = (Runnable)this.delayTasks.get(paramString);
          this.timerTask.removeCallbacks(paramRunnable);
          this.delayTasks.remove(paramString);
          Log.w("threadimpl_log", "remove delay task in thread pool ok!");
          return;
        }
      }
      paramString = this.workerThread.getQueue().iterator();
      while (paramString.hasNext())
      {
        localObject = (Runnable)paramString.next();
        if (((ThreadCenter.TaskProxy)localObject).task == paramRunnable)
        {
          this.workerThread.getQueue().remove(localObject);
          Log.w("threadimpl_log", "remove task in thread pool ok!");
          return;
        }
      }
      Log.e("threadimpl_log", "remove task in thread pool fail, no such task");
      return;
    }
    paramRunnable = (ThreadCenter.CoreHandler)this.singleHandlers.remove(paramString);
    if (paramRunnable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("canceled all suspend task: ");
      ((StringBuilder)localObject).append(paramString);
      Log.i("threadimpl_log", ((StringBuilder)localObject).toString());
      paramRunnable.quitThread();
      paramRunnable.handler.removeCallbacksAndMessages(null);
    }
  }
  
  public void removeUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    paramHandlerKeyable = (Handler)this.mHandlerMap.get(Integer.valueOf(paramHandlerKeyable.hashCode()));
    if (paramHandlerKeyable != null) {
      paramHandlerKeyable.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.ThreadImpl
 * JD-Core Version:    0.7.0.1
 */