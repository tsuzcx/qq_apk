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
import nex;

public abstract class BasePublishTask
  implements Runnable
{
  public static final Boolean a;
  public int a;
  public BaseTaskInfo a;
  public OnPublishTaskListener a;
  public ArrayList a;
  public AtomicBoolean a;
  public ArrayList b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  public BasePublishTask(BaseTaskInfo paramBaseTaskInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo = paramBaseTaskInfo;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", "stop task in send rich data:" + this);
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
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (UploadObject)localIterator.next();
        localObject2 = Stream.of(new ErrorMessage()).map(new ThreadOffFunction(4)).map((StreamFunction)localObject2);
        ((Stream)localObject2).subscribe(new nex(this, null));
        this.b.add(localObject2);
        SLog.c("Q.qqstory.publish.upload:BasePublishTask", "add task finish");
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
  
  public BaseTaskInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", "user try to stop task" + this);
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
    SLog.c("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:" + this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.publish.upload:BasePublishTask", "mTaskInfo:%s with fail result: %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo, paramErrorMessage });
    }
    if (a()) {
      paramInt = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskOnPublishTaskListener.a(this, paramErrorMessage);
    }
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", "not finish file count:%d, one file finish with result:%s", new Object[] { Integer.valueOf(this.b.size() - this.jdField_a_of_type_JavaUtilArrayList.size()), paramErrorMessage });
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
    SLog.d("Q.qqstory.publish.upload:BasePublishTask", "user try to force stop task" + this);
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
  
  public abstract void c();
  
  public void run()
  {
    d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BasePublishTask{");
    localStringBuilder.append("mTaskInfo=").append(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask
 * JD-Core Version:    0.7.0.1
 */