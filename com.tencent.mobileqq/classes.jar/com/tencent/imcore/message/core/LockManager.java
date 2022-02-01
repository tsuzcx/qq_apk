package com.tencent.imcore.message.core;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

public class LockManager
{
  private final WeakHashMap<Lock, Void> a = new WeakHashMap();
  
  public static LockManager a()
  {
    return LockManager.Holder.a();
  }
  
  public void a(StringBuilder paramStringBuilder)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Lock)localIterator.next();
        try
        {
          localObject = localObject.toString();
          if (!((String)localObject).contains("[Unlocked]"))
          {
            paramStringBuilder.append("\n");
            paramStringBuilder.append((String)localObject);
            paramStringBuilder.append("\n");
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("LockManager", 1, "dump: ", localThrowable);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramStringBuilder;
    }
  }
  
  public void a(Lock paramLock)
  {
    synchronized (this.a)
    {
      if (!this.a.containsKey(paramLock)) {
        this.a.put(paramLock, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.core.LockManager
 * JD-Core Version:    0.7.0.1
 */