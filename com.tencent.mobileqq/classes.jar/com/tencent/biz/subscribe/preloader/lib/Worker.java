package com.tencent.biz.subscribe.preloader.lib;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import yfn;
import yfo;
import yfq;
import yfr;
import yfs;
import yft;
import yfu;

public class Worker<T>
  implements Runnable, yfs, yft<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new yfr();
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  yfn<T> jdField_a_of_type_Yfn;
  private volatile yfu<T> jdField_a_of_type_Yfu;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, yfn<T> paramyfn, yfu<T> paramyfu)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramyfn);
    if (paramyfu != null) {
      this.jdField_a_of_type_Yfu = paramyfu;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    yfo.b("set state to:" + paramString);
  }
  
  private void a(yfn<T> paramyfn)
  {
    this.jdField_a_of_type_Yfn = paramyfn;
    a(yfq.jdField_a_of_type_JavaLangString);
  }
  
  private void a(yfu<T> paramyfu, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Yfn.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Yfn.jdField_a_of_type_Long * 1000L))
      {
        yfo.b("preload response is expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Yfn.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        yfo.b("is in mainThread");
        paramyfu.a(paramVarArgs);
        if (!this.jdField_a_of_type_Yfn.jdField_a_of_type_Boolean) {
          return;
        }
        yfo.a(this.jdField_a_of_type_JavaLangString);
        return;
        yfo.b("preload response is not expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Yfn.jdField_a_of_type_Long);
      }
      yfo.b("is not in mainThread");
    }
    catch (Exception paramyfu)
    {
      yfo.a(paramyfu);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramyfu, paramVarArgs));
  }
  
  private boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_b_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
    for (;;)
    {
      a(yfq.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(yfu paramyfu)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setListener listener");
    if (paramyfu != null) {}
    for (boolean bool = true;; bool = false)
    {
      yfo.b(bool);
      if (paramyfu != null)
      {
        this.jdField_a_of_type_Yfu = paramyfu;
        yfo.b("mState" + this.jdField_b_of_type_JavaLangString);
        if (yfq.c.equals(this.jdField_b_of_type_JavaLangString)) {
          a(paramyfu, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      return;
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(yfq.c);
    if (this.jdField_a_of_type_Yfu != null)
    {
      a(this.jdField_a_of_type_Yfu, paramVarArgs);
      return;
    }
    yfo.b("done but listener is null");
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Yfn.a();
      return;
    }
    catch (Exception localException)
    {
      yfo.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Yfn.a(this);
      return;
    }
    catch (Exception localException)
    {
      yfo.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.lib.Worker
 * JD-Core Version:    0.7.0.1
 */