package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BasePublishTask<T extends BaseTaskInfo>
  implements Runnable
{
  public static final Boolean a = Boolean.valueOf(false);
  public T b;
  public AtomicBoolean c = new AtomicBoolean(false);
  public int d = 7;
  public OnPublishTaskListener e;
  public ArrayList<ErrorMessage> f = new ArrayList();
  public ArrayList<Stream> g = new ArrayList();
  
  public BasePublishTask(T paramT)
  {
    this.b = paramT;
  }
  
  private void f()
  {
    Object localObject1;
    if (this.c.get())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stop task in send rich data:");
      ((StringBuilder)localObject1).append(this);
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
      a(this.d, new ErrorMessage());
      return;
    }
    a(1, new ErrorMessage());
    if (this.b.b.size() == 0)
    {
      g();
      return;
    }
    try
    {
      localObject1 = this.b.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (UploadObject)((Iterator)localObject1).next();
        localObject3 = Stream.of(new ErrorMessage()).map(new ThreadOffFunction("Q.qqstory.publish.upload:BasePublishTask", 4)).map((StreamFunction)localObject3);
        ((Stream)localObject3).subscribe(new BasePublishTask.UploadResult(this, null));
        this.g.add(localObject3);
        SLog.c("Q.qqstory.publish.upload:BasePublishTask", "add task finish");
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void g()
  {
    if (d())
    {
      a(this.d, new ErrorMessage());
      return;
    }
    a(2, new ErrorMessage());
    a(4, new ErrorMessage());
    e();
  }
  
  public T a()
  {
    return this.b;
  }
  
  protected void a(int paramInt, ErrorMessage paramErrorMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mTaskInfo:");
    ((StringBuilder)localObject).append(this.b);
    SLog.c("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject).toString());
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.b, paramErrorMessage });
    }
    if (d()) {
      paramInt = this.d;
    }
    this.b.a = paramInt;
    localObject = this.e;
    if (localObject != null) {
      ((OnPublishTaskListener)localObject).a(this, paramErrorMessage);
    }
  }
  
  protected void a(ErrorMessage paramErrorMessage)
  {
    this.f.add(paramErrorMessage);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", "not finish file count:%d, one file finish with result:%s", new Object[] { Integer.valueOf(this.g.size() - this.f.size()), paramErrorMessage });
    if (this.f.size() >= this.g.size())
    {
      ErrorMessage localErrorMessage = new ErrorMessage();
      Iterator localIterator = this.f.iterator();
      do
      {
        paramErrorMessage = localErrorMessage;
        if (!localIterator.hasNext()) {
          break;
        }
        paramErrorMessage = (ErrorMessage)localIterator.next();
      } while (!paramErrorMessage.isFail());
      if (d())
      {
        a(this.d, paramErrorMessage);
        return;
      }
      if (paramErrorMessage.isSuccess())
      {
        a(2, paramErrorMessage);
        g();
        return;
      }
      a(3, paramErrorMessage);
    }
  }
  
  public void a(OnPublishTaskListener paramOnPublishTaskListener)
  {
    this.e = paramOnPublishTaskListener;
  }
  
  public void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("user try to stop task");
    ((StringBuilder)localObject1).append(this);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
    this.d = 7;
    this.c.set(true);
    try
    {
      localObject1 = this.g.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Stream)((Iterator)localObject1).next()).cancel();
      }
      a(this.d, new ErrorMessage());
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("user try to force stop task");
    ((StringBuilder)localObject1).append(this);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
    this.d = 3;
    this.c.set(true);
    try
    {
      localObject1 = this.g.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Stream)((Iterator)localObject1).next()).cancel();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean d()
  {
    return this.c.get();
  }
  
  protected abstract void e();
  
  public void run()
  {
    f();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask
 * JD-Core Version:    0.7.0.1
 */