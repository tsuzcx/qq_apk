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
    HandlerThread localHandlerThread = new HandlerThread("basetimer");
    localHandlerThread.start();
    this.timerTask = new Handler(localHandlerThread.getLooper());
    int i = Runtime.getRuntime().availableProcessors();
    if (i > 0) {
      this.poolSize = i;
    }
    Log.v("threadimpl_log", "thread pool size " + this.poolSize);
    this.workerThread = new ThreadPoolExecutor(this.poolSize, this.poolSize, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
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
    ThreadCenter.CoreHandler localCoreHandler1 = null;
    if (this.singleHandlers.containsKey(paramString)) {
      localCoreHandler1 = (ThreadCenter.CoreHandler)this.singleHandlers.get(paramString);
    }
    ThreadCenter.CoreHandler localCoreHandler2 = localCoreHandler1;
    if (localCoreHandler1 == null)
    {
      localCoreHandler2 = new ThreadCenter.CoreHandler(paramString);
      this.singleHandlers.put(paramString, localCoreHandler2);
      Log.v("threadimpl_log", "create new thread: " + paramString);
    }
    return localCoreHandler2.getHandler();
  }
  
  public void postLogicTask(Runnable paramRunnable, long paramLong, boolean paramBoolean, String paramString)
  {
    int i = 10;
    if (paramRunnable == null) {
      return;
    }
    if (paramString == null)
    {
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
    ThreadCenter.CoreHandler localCoreHandler1 = null;
    if (this.singleHandlers.containsKey(paramString)) {
      localCoreHandler1 = (ThreadCenter.CoreHandler)this.singleHandlers.get(paramString);
    }
    ThreadCenter.CoreHandler localCoreHandler2 = localCoreHandler1;
    if (localCoreHandler1 == null)
    {
      localCoreHandler2 = new ThreadCenter.CoreHandler(paramString);
      this.singleHandlers.put(paramString, localCoreHandler2);
      Log.v("threadimpl_log", "create new thread: " + paramString);
    }
    if (paramLong > 0L)
    {
      localCoreHandler2.postDelayed(paramRunnable, paramLong);
      return;
    }
    localCoreHandler2.post(paramRunnable, paramBoolean);
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
    if (paramRunnable == null) {}
    do
    {
      return;
      if (paramString == null)
      {
        Object localObject = this.delayTasks.keySet().iterator();
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
    } while (paramRunnable == null);
    Log.i("threadimpl_log", "canceled all suspend task: " + paramString);
    paramRunnable.handler.removeCallbacksAndMessages(null);
  }
  
  public void removeUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    do
    {
      return;
      paramHandlerKeyable = (Handler)this.mHandlerMap.get(Integer.valueOf(paramHandlerKeyable.hashCode()));
    } while (paramHandlerKeyable == null);
    paramHandlerKeyable.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.ThreadImpl
 * JD-Core Version:    0.7.0.1
 */