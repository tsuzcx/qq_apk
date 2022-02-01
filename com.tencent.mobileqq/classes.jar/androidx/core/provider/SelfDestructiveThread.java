package androidx.core.provider;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread
{
  private static final int MSG_DESTRUCTION = 0;
  private static final int MSG_INVOKE_RUNNABLE = 1;
  private Handler.Callback mCallback = new SelfDestructiveThread.1(this);
  private final int mDestructAfterMillisec;
  @GuardedBy("mLock")
  private int mGeneration;
  @GuardedBy("mLock")
  private Handler mHandler;
  private final Object mLock = new Object();
  private final int mPriority;
  @GuardedBy("mLock")
  private HandlerThread mThread;
  private final String mThreadName;
  
  public SelfDestructiveThread(String paramString, int paramInt1, int paramInt2)
  {
    this.mThreadName = paramString;
    this.mPriority = paramInt1;
    this.mDestructAfterMillisec = paramInt2;
    this.mGeneration = 0;
  }
  
  private void post(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
        this.mGeneration += 1;
      }
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  @VisibleForTesting
  public int getGeneration()
  {
    synchronized (this.mLock)
    {
      int i = this.mGeneration;
      return i;
    }
  }
  
  @VisibleForTesting
  public boolean isRunning()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mThread != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  void onDestruction()
  {
    synchronized (this.mLock)
    {
      if (this.mHandler.hasMessages(1)) {
        return;
      }
      this.mThread.quit();
      this.mThread = null;
      this.mHandler = null;
      return;
    }
  }
  
  void onInvokeRunnable(Runnable arg1)
  {
    ???.run();
    synchronized (this.mLock)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
      return;
    }
  }
  
  public <T> void postAndReply(Callable<T> paramCallable, SelfDestructiveThread.ReplyCallback<T> paramReplyCallback)
  {
    post(new SelfDestructiveThread.2(this, paramCallable, new Handler(), paramReplyCallback));
  }
  
  public <T> T postAndWait(Callable<T> paramCallable, int paramInt)
  {
    localReentrantLock = new ReentrantLock();
    Condition localCondition = localReentrantLock.newCondition();
    AtomicReference localAtomicReference = new AtomicReference();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    post(new SelfDestructiveThread.3(this, localAtomicReference, paramCallable, localReentrantLock, localAtomicBoolean, localCondition));
    localReentrantLock.lock();
    label104:
    do
    {
      try
      {
        if (!localAtomicBoolean.get())
        {
          paramCallable = localAtomicReference.get();
          localReentrantLock.unlock();
          return paramCallable;
        }
        l1 = TimeUnit.MILLISECONDS.toNanos(paramInt);
      }
      finally
      {
        long l1;
        long l2;
        localReentrantLock.unlock();
        for (;;)
        {
          throw paramCallable;
        }
      }
      try
      {
        l2 = localCondition.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException paramCallable)
      {
        break label104;
      }
      if (!localAtomicBoolean.get())
      {
        paramCallable = localAtomicReference.get();
        localReentrantLock.unlock();
        return paramCallable;
      }
    } while (l1 > 0L);
    throw new InterruptedException("timeout");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.SelfDestructiveThread
 * JD-Core Version:    0.7.0.1
 */