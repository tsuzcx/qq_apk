package com.tencent.imcore.message.core;

import android.os.Process;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class MsgLock
  extends ReentrantLock
{
  private volatile long mLatestLockTime;
  private MsgLock.Listener mListener;
  private long mLockDuration;
  private volatile int myOwnerTid;
  private final String tag;
  
  public MsgLock(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgLock_");
    localStringBuilder.append(paramString);
    this.tag = localStringBuilder.toString();
    LockManager.a().a(this);
  }
  
  private void a()
  {
    MsgLock.Listener localListener = this.mListener;
    if (localListener != null) {
      localListener.a(this);
    }
  }
  
  private void a(Thread paramThread, StringBuilder paramStringBuilder)
  {
    paramThread = paramThread.getStackTrace();
    int j = paramThread.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramThread[i]);
      paramStringBuilder.append("\n");
      i += 1;
    }
  }
  
  private void b()
  {
    int i = Process.myTid();
    if (i != this.myOwnerTid)
    {
      this.myOwnerTid = i;
      this.mLatestLockTime = System.currentTimeMillis();
    }
    MsgLock.Listener localListener = this.mListener;
    if (localListener != null) {
      localListener.b(this);
    }
  }
  
  private void c()
  {
    this.mLockDuration = (System.currentTimeMillis() - this.mLatestLockTime);
    this.myOwnerTid = -1;
    MsgLock.Listener localListener = this.mListener;
    if (localListener != null) {
      localListener.c(this);
    }
  }
  
  private void d()
  {
    MsgLock.Listener localListener = this.mListener;
    if (localListener != null) {
      localListener.d(this);
    }
  }
  
  public void lock()
  {
    a();
    super.lock();
    b();
  }
  
  public void setListener(MsgLock.Listener paramListener)
  {
    this.mListener = paramListener;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Thread localThread = getOwner();
    localStringBuilder.append(this.tag);
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (localThread == null)
    {
      localStringBuilder.append("[Unlocked] st=");
      localStringBuilder.append(this.mLatestLockTime);
      localStringBuilder.append(", duration=");
      localStringBuilder.append(this.mLockDuration);
    }
    else
    {
      Collection localCollection = getQueuedThreads();
      localStringBuilder.append("[Locked by thread ");
      localStringBuilder.append(localThread.getName());
      localStringBuilder.append(", st=");
      localStringBuilder.append(this.mLatestLockTime);
      localStringBuilder.append(", duration=");
      localStringBuilder.append(System.currentTimeMillis() - this.mLatestLockTime);
      localStringBuilder.append(", myPid=");
      localStringBuilder.append(this.myOwnerTid);
      localStringBuilder.append(", tid=");
      localStringBuilder.append(localThread.getId());
      if ((localCollection != null) && (!localCollection.isEmpty()))
      {
        localStringBuilder.append(", queuedThreads=");
        localStringBuilder.append(localCollection);
      }
      localStringBuilder.append(", stackTrace of owner=");
      a(localThread, localStringBuilder);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  public void unlock()
  {
    c();
    super.unlock();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.core.MsgLock
 * JD-Core Version:    0.7.0.1
 */