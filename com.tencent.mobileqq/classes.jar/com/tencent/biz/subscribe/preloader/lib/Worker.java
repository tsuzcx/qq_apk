package com.tencent.biz.subscribe.preloader.lib;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import yka;
import ykb;
import ykd;
import yke;
import ykf;
import ykg;
import ykh;

public class Worker<T>
  implements Runnable, ykf, ykg<T>
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new yke();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  yka<T> jdField_a_of_type_Yka;
  private volatile ykh<T> jdField_a_of_type_Ykh;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, yka<T> paramyka, ykh<T> paramykh, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a(paramyka);
    if (paramykh != null) {
      this.jdField_a_of_type_Ykh = paramykh;
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", set state to " + paramString);
  }
  
  private void a(yka<T> paramyka)
  {
    this.jdField_a_of_type_Yka = paramyka;
    a(ykd.jdField_a_of_type_JavaLangString);
  }
  
  private void a(ykh<T> paramykh, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Yka.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Yka.jdField_a_of_type_Long * 1000L))
      {
        ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is expored! mPreloadExpiredTime " + this.jdField_a_of_type_Yka.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is in mainThread");
        paramykh.a(paramVarArgs);
        if (!this.jdField_a_of_type_Yka.jdField_a_of_type_Boolean) {
          return;
        }
        ykb.a(this.jdField_a_of_type_JavaLangString);
        return;
        ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is not expored! mPreloadExpiredTime " + this.jdField_a_of_type_Yka.jdField_a_of_type_Long);
      }
      ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is not in mainThread");
    }
    catch (Exception paramykh)
    {
      ykb.a(paramykh);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramykh, paramVarArgs));
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
      a(ykd.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(ykh paramykh)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.jdField_a_of_type_JavaLangString).append(", seq=").append(this.jdField_a_of_type_Int).append(", setListener listener ");
    if (paramykh != null) {}
    for (boolean bool = true;; bool = false)
    {
      ykb.b(bool);
      if (paramykh != null)
      {
        this.jdField_a_of_type_Ykh = paramykh;
        ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", cur state " + this.jdField_b_of_type_JavaLangString);
        if (ykd.c.equals(this.jdField_b_of_type_JavaLangString)) {
          a(paramykh, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      return;
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(ykd.c);
    if (this.jdField_a_of_type_Ykh != null)
    {
      a(this.jdField_a_of_type_Ykh, paramVarArgs);
      return;
    }
    ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", done but listener is null");
  }
  
  public void b()
  {
    try
    {
      ykb.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", on remove worker");
      this.jdField_a_of_type_Yka.a();
      return;
    }
    catch (Exception localException)
    {
      ykb.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Yka.a(this);
      return;
    }
    catch (Exception localException)
    {
      ykb.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.lib.Worker
 * JD-Core Version:    0.7.0.1
 */