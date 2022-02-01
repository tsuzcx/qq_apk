package com.eclipsesource.mmv8;

public class V8Locker
{
  private boolean released = false;
  private V8 runtime;
  private Thread thread = null;
  
  V8Locker(V8 paramV8)
  {
    this.runtime = paramV8;
    acquire();
  }
  
  public void acquire()
  {
    try
    {
      if ((this.thread != null) && (this.thread != Thread.currentThread()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid V8 thread access: current thread is ");
        ((StringBuilder)localObject1).append(Thread.currentThread());
        ((StringBuilder)localObject1).append(" while the locker has thread ");
        ((StringBuilder)localObject1).append(this.thread);
        throw new Error(((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.thread;
      Thread localThread = Thread.currentThread();
      if (localObject1 == localThread) {
        return;
      }
      this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
      this.thread = Thread.currentThread();
      this.released = false;
      return;
    }
    finally {}
  }
  
  public void checkThread()
  {
    if ((this.released) && (this.thread == null)) {
      throw new Error("Invalid V8 thread access: the locker has been released!");
    }
    if (this.thread == Thread.currentThread()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid V8 thread access: current thread is ");
    localStringBuilder.append(Thread.currentThread());
    localStringBuilder.append(" while the locker has thread ");
    localStringBuilder.append(this.thread);
    throw new Error(localStringBuilder.toString());
  }
  
  public Thread getThread()
  {
    return this.thread;
  }
  
  public boolean hasLock()
  {
    return this.thread == Thread.currentThread();
  }
  
  public void release()
  {
    try
    {
      if ((!this.released) || (this.thread != null))
      {
        boolean bool = this.runtime.isReleased();
        if (!bool) {}
      }
      else
      {
        return;
      }
      checkThread();
      this.runtime.releaseLock(this.runtime.getV8RuntimePtr());
      this.thread = null;
      this.released = true;
      return;
    }
    finally {}
  }
  
  public boolean tryAcquire()
  {
    try
    {
      if (this.thread != null)
      {
        localThread1 = this.thread;
        localThread2 = Thread.currentThread();
        if (localThread1 != localThread2) {
          return false;
        }
      }
      Thread localThread1 = this.thread;
      Thread localThread2 = Thread.currentThread();
      if (localThread1 == localThread2) {
        return true;
      }
      this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
      this.thread = Thread.currentThread();
      this.released = false;
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8Locker
 * JD-Core Version:    0.7.0.1
 */