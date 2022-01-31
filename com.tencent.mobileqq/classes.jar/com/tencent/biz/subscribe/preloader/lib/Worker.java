package com.tencent.biz.subscribe.preloader.lib;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import wqx;
import wqy;
import wra;
import wrb;
import wrc;
import wrd;
import wre;

public class Worker<T>
  implements Runnable, wrc, wrd<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new wrb();
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  wqx<T> jdField_a_of_type_Wqx;
  private wre<T> jdField_a_of_type_Wre;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, wqx<T> paramwqx, wre<T> paramwre)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramwqx);
    if (paramwre != null) {
      this.jdField_a_of_type_Wre = paramwre;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    wqy.b("set state to:" + paramString);
  }
  
  private void a(wqx<T> paramwqx)
  {
    this.jdField_a_of_type_Wqx = paramwqx;
    a(wra.jdField_a_of_type_JavaLangString);
  }
  
  private void a(wre<T> paramwre, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Wqx.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Wqx.jdField_a_of_type_Long * 1000L))
      {
        wqy.b("preload response is expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Wqx.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        paramwre.a(paramVarArgs);
        if (!this.jdField_a_of_type_Wqx.jdField_a_of_type_Boolean) {
          return;
        }
        wqy.a(this.jdField_a_of_type_JavaLangString);
        return;
        wqy.b("preload response is not expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Wqx.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramwre, paramVarArgs));
    }
    catch (Exception paramwre)
    {
      wqy.a(paramwre);
      return;
    }
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
      a(wra.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(wre paramwre)
  {
    if (paramwre != null)
    {
      this.jdField_a_of_type_Wre = paramwre;
      if (wra.c.equals(this.jdField_b_of_type_JavaLangString)) {
        a(paramwre, this.jdField_a_of_type_ArrayOfJavaLangObject);
      }
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(wra.c);
    if (this.jdField_a_of_type_Wre != null) {
      a(this.jdField_a_of_type_Wre, paramVarArgs);
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Wqx.a();
      return;
    }
    catch (Exception localException)
    {
      wqy.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Wqx.a(this);
      return;
    }
    catch (Exception localException)
    {
      wqy.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.lib.Worker
 * JD-Core Version:    0.7.0.1
 */