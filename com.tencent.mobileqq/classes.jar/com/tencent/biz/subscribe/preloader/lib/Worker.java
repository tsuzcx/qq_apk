package com.tencent.biz.subscribe.preloader.lib;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import wra;
import wrb;
import wrd;
import wre;
import wrf;
import wrg;
import wrh;

public class Worker<T>
  implements Runnable, wrf, wrg<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new wre();
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  wra<T> jdField_a_of_type_Wra;
  private wrh<T> jdField_a_of_type_Wrh;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, wra<T> paramwra, wrh<T> paramwrh)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramwra);
    if (paramwrh != null) {
      this.jdField_a_of_type_Wrh = paramwrh;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    wrb.b("set state to:" + paramString);
  }
  
  private void a(wra<T> paramwra)
  {
    this.jdField_a_of_type_Wra = paramwra;
    a(wrd.jdField_a_of_type_JavaLangString);
  }
  
  private void a(wrh<T> paramwrh, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Wra.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Wra.jdField_a_of_type_Long * 1000L))
      {
        wrb.b("preload response is expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Wra.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        paramwrh.a(paramVarArgs);
        if (!this.jdField_a_of_type_Wra.jdField_a_of_type_Boolean) {
          return;
        }
        wrb.a(this.jdField_a_of_type_JavaLangString);
        return;
        wrb.b("preload response is not expored! mPreloadExpiredTime :" + this.jdField_a_of_type_Wra.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramwrh, paramVarArgs));
    }
    catch (Exception paramwrh)
    {
      wrb.a(paramwrh);
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
      a(wrd.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(wrh paramwrh)
  {
    if (paramwrh != null)
    {
      this.jdField_a_of_type_Wrh = paramwrh;
      if (wrd.c.equals(this.jdField_b_of_type_JavaLangString)) {
        a(paramwrh, this.jdField_a_of_type_ArrayOfJavaLangObject);
      }
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(wrd.c);
    if (this.jdField_a_of_type_Wrh != null) {
      a(this.jdField_a_of_type_Wrh, paramVarArgs);
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Wra.a();
      return;
    }
    catch (Exception localException)
    {
      wrb.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Wra.a(this);
      return;
    }
    catch (Exception localException)
    {
      wrb.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.lib.Worker
 * JD-Core Version:    0.7.0.1
 */