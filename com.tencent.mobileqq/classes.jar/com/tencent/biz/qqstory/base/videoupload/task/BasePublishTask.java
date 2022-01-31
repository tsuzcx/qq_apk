package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sxa;
import sxd;
import sxf;
import sxg;
import veg;

public abstract class BasePublishTask<T extends sxf>
  implements Runnable
{
  public static final Boolean a;
  public int a;
  public ArrayList<ErrorMessage> a;
  public AtomicBoolean a;
  public T a;
  public sxg a;
  public ArrayList<Stream> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  public BasePublishTask(T paramT)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Sxf = paramT;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      veg.d("Q.qqstory.publish.upload:BasePublishTask", "stop task in send rich data:" + this);
      a(this.jdField_a_of_type_Int, new ErrorMessage());
      return;
    }
    a(1, new ErrorMessage());
    if (this.jdField_a_of_type_Sxf.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      e();
      return;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_Sxf.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (sxa)localIterator.next();
        localObject2 = Stream.of(new ErrorMessage()).map(new ThreadOffFunction("Q.qqstory.publish.upload:BasePublishTask", 4)).map((StreamFunction)localObject2);
        ((Stream)localObject2).subscribe(new sxd(this, null));
        this.b.add(localObject2);
        veg.c("Q.qqstory.publish.upload:BasePublishTask", "add task finish");
      }
    }
    finally {}
  }
  
  private void e()
  {
    if (a())
    {
      a(this.jdField_a_of_type_Int, new ErrorMessage());
      return;
    }
    a(2, new ErrorMessage());
    a(4, new ErrorMessage());
    c();
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Sxf;
  }
  
  public void a()
  {
    veg.d("Q.qqstory.publish.upload:BasePublishTask", "user try to stop task" + this);
    this.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((Stream)localIterator.next()).cancel();
      }
    }
    finally {}
    a(this.jdField_a_of_type_Int, new ErrorMessage());
  }
  
  public void a(int paramInt, ErrorMessage paramErrorMessage)
  {
    veg.c("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:" + this.jdField_a_of_type_Sxf);
    if (paramErrorMessage.isFail()) {
      veg.d("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.jdField_a_of_type_Sxf, paramErrorMessage });
    }
    if (a()) {
      paramInt = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Sxf.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Sxg != null) {
      this.jdField_a_of_type_Sxg.a(this, paramErrorMessage);
    }
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
    veg.d("Q.qqstory.publish.upload:BasePublishTask", "not finish file count:%d, one file finish with result:%s", new Object[] { Integer.valueOf(this.b.size() - this.jdField_a_of_type_JavaUtilArrayList.size()), paramErrorMessage });
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.b.size())
    {
      paramErrorMessage = new ErrorMessage();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ErrorMessage localErrorMessage = (ErrorMessage)localIterator.next();
        if (localErrorMessage.isFail()) {
          paramErrorMessage = localErrorMessage;
        }
      }
    }
    for (;;)
    {
      if (a())
      {
        a(this.jdField_a_of_type_Int, paramErrorMessage);
        return;
      }
      if (paramErrorMessage.isSuccess())
      {
        a(2, paramErrorMessage);
        e();
        return;
      }
      a(3, paramErrorMessage);
      return;
    }
  }
  
  public void a(sxg paramsxg)
  {
    this.jdField_a_of_type_Sxg = paramsxg;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    veg.d("Q.qqstory.publish.upload:BasePublishTask", "user try to force stop task" + this);
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((Stream)localIterator.next()).cancel();
      }
    }
    finally {}
  }
  
  protected abstract void c();
  
  public void run()
  {
    d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=").append(this.jdField_a_of_type_Sxf);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask
 * JD-Core Version:    0.7.0.1
 */