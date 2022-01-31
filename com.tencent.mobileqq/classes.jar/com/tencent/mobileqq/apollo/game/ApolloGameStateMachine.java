package com.tencent.mobileqq.apollo.game;

import aiyd;
import aiye;
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
  public static aiye a;
  private static ApolloGameStateMachine jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine;
  public static final HashMap<Integer, List<Integer>> a;
  public static AtomicBoolean a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloGameStateMachine.1(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new aiyd(this);
  private ConcurrentHashMap<Integer, ApolloGameStateMachine.StateTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
  private final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    jdField_a_of_type_JavaUtilHashMap = new ApolloGameStateMachine.3();
  }
  
  public static ApolloGameStateMachine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine == null) {}
    for (;;)
    {
      try {}catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameStateMachine", 1, localThrowable, new Object[0]);
        continue;
      }
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine == null)
        {
          jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine = new ApolloGameStateMachine();
          jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.b();
          if ((jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine != null) && (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.jdField_a_of_type_JavaUtilObserver != null)) {
            jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.addObserver(jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.jdField_a_of_type_JavaUtilObserver);
          }
        }
        return jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine;
      }
      finally {}
    }
  }
  
  public static void d()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine != null)
    {
      jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.deleteObservers();
      jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine.c();
      jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine = null;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int i = a();
      ApolloGameStateMachine.StateTask localStateTask = (ApolloGameStateMachine.StateTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
      if (localStateTask != null) {
        synchronized (this.b)
        {
          ThreadManager.post(localStateTask, 5, null, true);
          return;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, "DEFAULT");
  }
  
  public int a(int paramInt, String paramString)
  {
    ??? = (List)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    if ((??? != null) && (((List)???).contains(Integer.valueOf(paramInt)))) {
      synchronized (this.b)
      {
        setChanged();
        Bundle localBundle = new Bundle();
        localBundle.putString("TYPE", "GAME_STATE");
        localBundle.putLong("START_TIME_KEY", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
        localBundle.putLong("END_TIME_KEY", System.currentTimeMillis());
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
        localBundle.putInt("FROM", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        localBundle.putInt("TO", paramInt);
        localBundle.putString("MESSAGE", paramString);
        notifyObservers(localBundle);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        e();
        return -1;
      }
    }
    QLog.e("ApolloGameStateMachine", 1, "[changeToState] ill");
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a()
  {
    a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        b();
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
  }
  
  public void a(int paramInt, Runnable paramRunnable)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramRunnable != null))
    {
      if ((paramRunnable instanceof ApolloGameStateMachine.StateTask))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (ApolloGameStateMachine.StateTask)paramRunnable);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new ApolloGameStateMachine.StateTask(paramInt, paramRunnable, this));
      return;
    }
    QLog.e("ApolloGameStateMachine", 1, "[setTask] taskList is null rebuild");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  protected void b()
  {
    a(1, new ApolloGameStateMachine.4(this));
    a(5, new ApolloGameStateMachine.5(this));
    a(6, new ApolloGameStateMachine.6(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      this.jdField_a_of_type_JavaUtilObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameStateMachine", 1, localThrowable, new Object[] { "[destory]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine
 * JD-Core Version:    0.7.0.1
 */