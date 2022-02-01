package com.tencent.biz.richframework.preload;

import aadf;
import aadg;
import aadi;
import aadj;
import aadk;
import aadl;
import aadm;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Worker<T>
  implements aadk, aadl<T>, Runnable
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), jdField_a_of_type_JavaUtilConcurrentThreadFactory);
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new aadj();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  aadf<T> jdField_a_of_type_Aadf;
  private volatile aadm<T> jdField_a_of_type_Aadm;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  private T[] jdField_a_of_type_ArrayOfJavaLangObject;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private ExecutorService jdField_b_of_type_JavaUtilConcurrentExecutorService;
  
  public Worker(String paramString, aadf<T> paramaadf, aadm<T> paramaadm, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    a(paramaadf);
    if (paramaadm != null) {
      this.jdField_a_of_type_Aadm = paramaadm;
    }
  }
  
  private void a(aadf<T> paramaadf)
  {
    this.jdField_a_of_type_Aadf = paramaadf;
    a(aadi.jdField_a_of_type_JavaLangString);
  }
  
  private void a(aadm<T> paramaadm, T... paramVarArgs)
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Aadf.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_a_of_type_Aadf.jdField_a_of_type_Long * 1000L))
      {
        aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is expored! mPreloadExpiredTime " + this.jdField_a_of_type_Aadf.jdField_a_of_type_Long);
        paramVarArgs = null;
      }
      while (a())
      {
        aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is in mainThread");
        paramaadm.a(paramVarArgs);
        if (!this.jdField_a_of_type_Aadf.jdField_a_of_type_Boolean) {
          return;
        }
        aadg.a(this.jdField_a_of_type_JavaLangString);
        return;
        aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", preload response is not expored! mPreloadExpiredTime " + this.jdField_a_of_type_Aadf.jdField_a_of_type_Long);
      }
      aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", is not in mainThread");
    }
    catch (Exception paramaadm)
    {
      aadg.a(paramaadm);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new Worker.2(this, paramaadm, paramVarArgs));
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", set state to " + paramString);
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
      a(aadi.jdField_b_of_type_JavaLangString);
      return;
      jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this);
    }
  }
  
  public void a(aadm paramaadm)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.jdField_a_of_type_JavaLangString).append(", seq=").append(this.jdField_a_of_type_Int).append(", setListener listener ");
    if (paramaadm != null) {}
    for (boolean bool = true;; bool = false)
    {
      aadg.b(bool);
      if (paramaadm != null)
      {
        this.jdField_a_of_type_Aadm = paramaadm;
        aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", cur state " + this.jdField_b_of_type_JavaLangString);
        if (aadi.c.equals(this.jdField_b_of_type_JavaLangString)) {
          a(paramaadm, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      return;
    }
  }
  
  public void a(T... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(aadi.c);
    if (this.jdField_a_of_type_Aadm != null)
    {
      a(this.jdField_a_of_type_Aadm, paramVarArgs);
      return;
    }
    aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", done but listener is null");
  }
  
  public void b()
  {
    try
    {
      aadg.b("id=" + this.jdField_a_of_type_JavaLangString + ", seq=" + this.jdField_a_of_type_Int + ", on remove worker");
      this.jdField_a_of_type_Aadf.a();
      return;
    }
    catch (Exception localException)
    {
      aadg.a(localException);
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Aadf.a(this);
      return;
    }
    catch (Exception localException)
    {
      aadg.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.preload.Worker
 * JD-Core Version:    0.7.0.1
 */