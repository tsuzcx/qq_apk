package com.tencent.biz.richframework.preload;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import zpq;
import zpr;
import zpt;
import zpu;
import zpv;
import zpw;
import zpx;

public class Worker<T>
  implements Runnable, zpv, zpw<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new zpu();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  zpq<T> jdField_a_of_type_Zpq;
  private volatile zpx<T> jdField_a_of_type_Zpx;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, zpq<T> paramzpq, zpx<T> paramzpx, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a(paramzpq);
    if (paramzpx != null) {
      this.jdField_a_of_type_Zpx = paramzpx;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", set state to " + paramString);
  }
  
  private void a(zpq<T> paramzpq)
  {
    this.jdField_a_of_type_Zpq = paramzpq;
    a(zpt.jdField_a_of_type_JavaLangString);
  }
  
  private void a(zpx<T> paramzpx, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Zpq.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Zpq.jdField_a_of_type_Long * 1000L))
      {
        zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is expored! mPreloadExpiredTime " + this.jdField_a_of_type_Zpq.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is in mainThread");
        paramzpx.a(paramVarArgs);
        if (!this.jdField_a_of_type_Zpq.jdField_a_of_type_Boolean) {
          return;
        }
        zpr.a(this.jdField_a_of_type_JavaLangString);
        return;
        zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is not expored! mPreloadExpiredTime " + this.jdField_a_of_type_Zpq.jdField_a_of_type_Long);
      }
      zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is not in mainThread");
    }
    catch (Exception paramzpx)
    {
      zpr.a(paramzpx);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramzpx, paramVarArgs));
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
      a(zpt.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(zpx paramzpx)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.jdField_a_of_type_JavaLangString).append(", seq=").append(this.jdField_a_of_type_Int).append(", setListener listener ");
    if (paramzpx != null) {}
    for (boolean bool = true;; bool = false)
    {
      zpr.b(bool);
      if (paramzpx != null)
      {
        this.jdField_a_of_type_Zpx = paramzpx;
        zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", cur state " + this.jdField_b_of_type_JavaLangString);
        if (zpt.c.equals(this.jdField_b_of_type_JavaLangString)) {
          a(paramzpx, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      return;
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(zpt.c);
    if (this.jdField_a_of_type_Zpx != null)
    {
      a(this.jdField_a_of_type_Zpx, paramVarArgs);
      return;
    }
    zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", done but listener is null");
  }
  
  public void b()
  {
    try
    {
      zpr.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", on remove worker");
      this.jdField_a_of_type_Zpq.a();
      return;
    }
    catch (Exception localException)
    {
      zpr.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Zpq.a(this);
      return;
    }
    catch (Exception localException)
    {
      zpr.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.preload.Worker
 * JD-Core Version:    0.7.0.1
 */