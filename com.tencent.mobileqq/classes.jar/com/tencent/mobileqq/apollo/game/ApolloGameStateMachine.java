package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ApolloGameStateMachine
  extends Observable
{
  public static ApolloGameStateMachine.HardwareInfo a;
  public static AtomicBoolean b = new AtomicBoolean();
  public static final HashMap<Integer, List<Integer>> c = new ApolloGameStateMachine.3();
  private static ApolloGameStateMachine h;
  private ConcurrentHashMap<Integer, ApolloGameStateMachine.StateTask> d = new ConcurrentHashMap();
  private AtomicLong e = new AtomicLong();
  private Runnable f = new ApolloGameStateMachine.1(this);
  private Observer g = new ApolloGameStateMachine.2(this);
  private AtomicInteger i = new AtomicInteger(0);
  private final Object j = new Object();
  private final Object k = new Object();
  
  public static ApolloGameStateMachine a()
  {
    if (h == null) {
      try
      {
        try
        {
          if (h == null)
          {
            h = new ApolloGameStateMachine();
            h.d();
            if ((h != null) && (h.g != null)) {
              h.addObserver(h.g);
            }
          }
        }
        finally {}
        return h;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]ApolloGameStateMachine", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public static void f()
  {
    ApolloGameStateMachine localApolloGameStateMachine = h;
    if (localApolloGameStateMachine != null)
    {
      localApolloGameStateMachine.deleteObservers();
      h.e();
      h = null;
    }
  }
  
  private void g()
  {
    int m = b();
    ApolloGameStateMachine.StateTask localStateTask = (ApolloGameStateMachine.StateTask)this.d.get(Integer.valueOf(m));
    if (localStateTask != null) {
      synchronized (this.k)
      {
        ThreadManager.post(localStateTask, 5, null, true);
        return;
      }
    }
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, "DEFAULT");
  }
  
  public int a(int paramInt, String paramString)
  {
    ??? = (List)c.get(Integer.valueOf(this.i.get()));
    if ((??? != null) && (((List)???).contains(Integer.valueOf(paramInt)))) {
      synchronized (this.k)
      {
        setChanged();
        Bundle localBundle = new Bundle();
        localBundle.putString("TYPE", "GAME_STATE");
        localBundle.putLong("START_TIME_KEY", this.e.get());
        localBundle.putLong("END_TIME_KEY", System.currentTimeMillis());
        this.e.set(System.currentTimeMillis());
        localBundle.putInt("FROM", this.i.get());
        localBundle.putInt("TO", paramInt);
        localBundle.putString("MESSAGE", paramString);
        notifyObservers(localBundle);
        this.i.set(paramInt);
        g();
        return -1;
      }
    }
    QLog.e("[cmshow]ApolloGameStateMachine", 1, "[changeToState] ill");
    return this.i.get();
  }
  
  public void a(int paramInt, Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if ((paramRunnable instanceof ApolloGameStateMachine.StateTask))
    {
      this.d.put(Integer.valueOf(paramInt), (ApolloGameStateMachine.StateTask)paramRunnable);
      return;
    }
    this.d.put(Integer.valueOf(paramInt), new ApolloGameStateMachine.StateTask(paramInt, paramRunnable, this));
  }
  
  public int b()
  {
    return this.i.get();
  }
  
  public void c()
  {
    a();
    synchronized (this.j)
    {
      this.d.clear();
      this.i.set(0);
      d();
      return;
    }
  }
  
  protected void d()
  {
    a(1, new ApolloGameStateMachine.4(this));
    a(5, new ApolloGameStateMachine.5(this));
    a(6, new ApolloGameStateMachine.6(this));
  }
  
  public void e()
  {
    try
    {
      if (this.f != null)
      {
        ThreadManager.removeJobFromThreadPool(this.f, 16);
        this.f = null;
      }
      this.d.clear();
      this.g = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGameStateMachine", 1, localThrowable, new Object[] { "[destroy]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine
 * JD-Core Version:    0.7.0.1
 */