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
  public static final Boolean a;
  public int a;
  public T a;
  public OnPublishTaskListener a;
  public ArrayList<ErrorMessage> a;
  public AtomicBoolean a;
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
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo = paramT;
  }
  
  private void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stop task in send rich data:");
      ((StringBuilder)localObject1).append(this);
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
      a(this.jdField_a_of_type_Int, new ErrorMessage());
      return;
    }
    a(1, new ErrorMessage());
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      e();
      return;
    }
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (UploadObject)((Iterator)localObject1).next();
        localObject3 = Stream.of(new ErrorMessage()).map(new ThreadOffFunction("Q.qqstory.publish.upload:BasePublishTask", 4)).map((StreamFunction)localObject3);
        ((Stream)localObject3).subscribe(new BasePublishTask.UploadResult(this, null));
        this.b.add(localObject3);
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
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo;
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("user try to stop task");
    ((StringBuilder)localObject1).append(this);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    try
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Stream)((Iterator)localObject1).next()).cancel();
      }
      a(this.jdField_a_of_type_Int, new ErrorMessage());
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void a(int paramInt, ErrorMessage paramErrorMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mTaskInfo:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    SLog.c("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject).toString());
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo, paramErrorMessage });
    }
    if (a()) {
      paramInt = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int = paramInt;
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener;
    if (localObject != null) {
      ((OnPublishTaskListener)localObject).a(this, paramErrorMessage);
    }
  }
  
  protected void a(ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", "not finish file count:%d, one file finish with result:%s", new Object[] { Integer.valueOf(this.b.size() - this.jdField_a_of_type_JavaUtilArrayList.size()), paramErrorMessage });
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.b.size())
    {
      ErrorMessage localErrorMessage = new ErrorMessage();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        paramErrorMessage = localErrorMessage;
        if (!localIterator.hasNext()) {
          break;
        }
        paramErrorMessage = (ErrorMessage)localIterator.next();
      } while (!paramErrorMessage.isFail());
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
    }
  }
  
  public void a(OnPublishTaskListener paramOnPublishTaskListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener = paramOnPublishTaskListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("user try to force stop task");
    ((StringBuilder)localObject1).append(this);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    try
    {
      localObject1 = this.b.iterator();
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
  
  protected abstract void c();
  
  public void run()
  {
    d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask
 * JD-Core Version:    0.7.0.1
 */