package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.component.network.module.base.Config;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SmartThreadExecutor
  implements Handler.Callback, Executor
{
  private static final long CHECK_PERIOD = TimeUnit.SECONDS.toMillis(30L);
  private static final int FIRST_ANTI_JITTER_TEMP_WORKER_SIZE = 2;
  private static final long FIRST_CHECK_PERIOD = TimeUnit.SECONDS.toMillis(2L);
  private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
  private static final int MAX_TEMP_THREAD_CNT = 2;
  private static final int MSG_WHAT_CHK_BASE = 7500;
  private static final String MTA_REPORT_EVENT = "qzone_downloader_smart_thread_event_temp_thread";
  private static final String MTA_REPORT_TYPE_START = "start";
  private static final String MTA_REPORT_TYPE_TOTAL = "total";
  private static final String MTA_REPORT_TYPE_VALID = "valid";
  private static final String TAG = "SmartThreadExecutor";
  private static final int TEMP_THREAD_VALID_REPORT_TIME_IN_SEC = 2;
  private static volatile int sAliveCnt = 0;
  private static volatile HandlerThread sChkThread;
  private int antiJitterTempWorkerSize;
  private final SmartThreadExecutor.SmartThreadFactory factory = new SmartThreadExecutor.SmartThreadFactory(null);
  private final Handler handler;
  private final int id = ID_GENERATOR.getAndIncrement();
  private volatile boolean isAlive = true;
  private final AtomicBoolean isNeedTempWorker = new AtomicBoolean(false);
  private String lastTaskId;
  private final int msgWhat = this.id + 7500;
  private final Executor normExecutor;
  private final LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
  private final List<SmartThreadExecutor.TempTask> tempThreads = new LinkedList();
  
  public SmartThreadExecutor(Executor paramExecutor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SmartThreadExecutor: ");
    localStringBuilder.append(this.id);
    Log.i("SmartThreadExecutor", localStringBuilder.toString());
    this.normExecutor = paramExecutor;
    try
    {
      if (sChkThread == null)
      {
        sChkThread = new HandlerThread("smart-check-thread", 10);
        sChkThread.start();
      }
      sAliveCnt += 1;
      for (;;)
      {
        paramExecutor = sChkThread.getLooper();
        if (paramExecutor != null) {
          break;
        }
        Thread.yield();
      }
      this.handler = new Handler(paramExecutor, this);
      this.handler.sendEmptyMessageDelayed(this.msgWhat, FIRST_CHECK_PERIOD);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramExecutor;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (!this.isAlive) {
      return;
    }
    this.normExecutor.execute(new SmartThreadExecutor.IdTask(paramRunnable, null));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j = this.msgWhat;
    boolean bool = false;
    if (i != j) {
      return false;
    }
    if (!this.isAlive) {
      return true;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage: start check ");
    paramMessage.append(this.id);
    Log.i("SmartThreadExecutor", paramMessage.toString());
    paramMessage = (Runnable)this.taskQueue.peek();
    if ((paramMessage instanceof SmartThreadExecutor.IdTask)) {
      paramMessage = SmartThreadExecutor.IdTask.access$300((SmartThreadExecutor.IdTask)paramMessage);
    } else {
      paramMessage = null;
    }
    if ((this.isAlive) && (paramMessage != null) && (paramMessage.equals(this.lastTaskId)))
    {
      this.isNeedTempWorker.set(true);
      this.antiJitterTempWorkerSize = 2;
      synchronized (this.tempThreads)
      {
        if ((this.isAlive) && (this.tempThreads.size() < 2))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleMessage: start temp task ");
          ((StringBuilder)localObject2).append(this.id);
          Log.i("SmartThreadExecutor", ((StringBuilder)localObject2).toString());
          localObject2 = new SmartThreadExecutor.TempTask(this, null);
          this.factory.newThread((Runnable)localObject2).start();
          this.tempThreads.add(localObject2);
          localObject2 = new Properties();
          ((Properties)localObject2).put("start", Integer.valueOf(1));
          Config.reportToMta("qzone_downloader_smart_thread_event_temp_thread", (Properties)localObject2);
        }
      }
    }
    ??? = this.isNeedTempWorker;
    i = this.antiJitterTempWorkerSize - 1;
    this.antiJitterTempWorkerSize = i;
    if (i > 0) {
      bool = true;
    }
    ((AtomicBoolean)???).compareAndSet(true, bool);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("handleMessage: check end ");
    ((StringBuilder)???).append(this.id);
    ((StringBuilder)???).append(" ");
    ((StringBuilder)???).append(this.antiJitterTempWorkerSize);
    ((StringBuilder)???).append(" ");
    ((StringBuilder)???).append(this.isNeedTempWorker.get());
    Log.i("SmartThreadExecutor", ((StringBuilder)???).toString());
    this.lastTaskId = paramMessage;
    if (this.isAlive) {
      this.handler.sendEmptyMessageDelayed(this.msgWhat, CHECK_PERIOD);
    }
    return true;
  }
  
  public void shutdown()
  {
    this.isAlive = false;
    ??? = this.normExecutor;
    if ((??? instanceof ExecutorService)) {
      ((ExecutorService)???).shutdownNow();
    }
    this.handler.removeMessages(this.msgWhat);
    synchronized (this.tempThreads)
    {
      Iterator localIterator = this.tempThreads.iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = SmartThreadExecutor.TempTask.access$200((SmartThreadExecutor.TempTask)localIterator.next());
        if (localThread != null) {
          localThread.interrupt();
        }
      }
      this.tempThreads.clear();
      try
      {
        int i = sAliveCnt - 1;
        sAliveCnt = i;
        if (i < 1) {
          sChkThread.quit();
        }
        return;
      }
      finally {}
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor
 * JD-Core Version:    0.7.0.1
 */