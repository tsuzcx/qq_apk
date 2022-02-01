package com.tencent.biz.richframework.preload;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import zal;
import zam;
import zao;
import zap;
import zaq;
import zar;
import zas;

public class Worker<T>
  implements Runnable, zaq, zar<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new zap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  zal<T> jdField_a_of_type_Zal;
  private volatile zas<T> jdField_a_of_type_Zas;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, zal<T> paramzal, zas<T> paramzas, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a(paramzal);
    if (paramzas != null) {
      this.jdField_a_of_type_Zas = paramzas;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", set state to " + paramString);
  }
  
  private void a(zal<T> paramzal)
  {
    this.jdField_a_of_type_Zal = paramzal;
    a(zao.jdField_a_of_type_JavaLangString);
  }
  
  private void a(zas<T> paramzas, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Zal.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Zal.jdField_a_of_type_Long * 1000L))
      {
        zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is expored! mPreloadExpiredTime " + this.jdField_a_of_type_Zal.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is in mainThread");
        paramzas.a(paramVarArgs);
        if (!this.jdField_a_of_type_Zal.jdField_a_of_type_Boolean) {
          return;
        }
        zam.a(this.jdField_a_of_type_JavaLangString);
        return;
        zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is not expored! mPreloadExpiredTime " + this.jdField_a_of_type_Zal.jdField_a_of_type_Long);
      }
      zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is not in mainThread");
    }
    catch (Exception paramzas)
    {
      zam.a(paramzas);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramzas, paramVarArgs));
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
      a(zao.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(zas paramzas)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.jdField_a_of_type_JavaLangString).append(", seq=").append(this.jdField_a_of_type_Int).append(", setListener listener ");
    if (paramzas != null) {}
    for (boolean bool = true;; bool = false)
    {
      zam.b(bool);
      if (paramzas != null)
      {
        this.jdField_a_of_type_Zas = paramzas;
        zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", cur state " + this.jdField_b_of_type_JavaLangString);
        if (zao.c.equals(this.jdField_b_of_type_JavaLangString)) {
          a(paramzas, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      return;
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(zao.c);
    if (this.jdField_a_of_type_Zas != null)
    {
      a(this.jdField_a_of_type_Zas, paramVarArgs);
      return;
    }
    zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", done but listener is null");
  }
  
  public void b()
  {
    try
    {
      zam.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", on remove worker");
      this.jdField_a_of_type_Zal.a();
      return;
    }
    catch (Exception localException)
    {
      zam.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Zal.a(this);
      return;
    }
    catch (Exception localException)
    {
      zam.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.preload.Worker
 * JD-Core Version:    0.7.0.1
 */