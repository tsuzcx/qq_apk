package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BasePublishTaskManager<T extends BaseTaskInfo>
  extends BaseManger
  implements OnPublishTaskListener
{
  public BasePublishTask<T> a;
  public ArrayList<T> a;
  public ArrayList<T> b = new ArrayList();
  
  public BasePublishTaskManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)localIterator.next();
        localBaseTaskInfo.jdField_a_of_type_Int = 6;
        localBaseTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
        this.b.add(localBaseTaskInfo);
        a(localBaseTaskInfo);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramErrorMessage;
    }
  }
  
  protected abstract BasePublishTask a(T paramT);
  
  public void a() {}
  
  protected void a(BasePublishTask<T> paramBasePublishTask)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == paramBasePublishTask) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = null;
      }
      return;
    }
    finally
    {
      paramBasePublishTask = finally;
      throw paramBasePublishTask;
    }
  }
  
  public final void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    if (paramBasePublishTask == null)
    {
      SLog.e("Q.qqstory.publish.upload:BasePublishTaskManager", "running publish task is null, when finish publish");
      return;
    }
    BaseTaskInfo localBaseTaskInfo = paramBasePublishTask.a();
    paramBasePublishTask.a().jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((localBaseTaskInfo.jdField_a_of_type_Int == 6) || (localBaseTaskInfo.jdField_a_of_type_Int == 5) || (localBaseTaskInfo.jdField_a_of_type_Int == 3) || (localBaseTaskInfo.jdField_a_of_type_Int == 7))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish task:");
      localStringBuilder.append(paramBasePublishTask);
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", localStringBuilder.toString());
      if (localBaseTaskInfo.jdField_a_of_type_Int != 5)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task fail:");
        localStringBuilder.append(paramBasePublishTask);
        SLog.d("Q.qqstory.publish.upload:BasePublishTaskManager", localStringBuilder.toString());
      }
      if (paramErrorMessage.errorCode == 10406)
      {
        a(paramBasePublishTask);
        a(paramErrorMessage);
      }
      else
      {
        a(paramBasePublishTask);
        d();
      }
      b(localBaseTaskInfo, paramErrorMessage);
    }
    a(localBaseTaskInfo);
  }
  
  protected abstract void a(T paramT);
  
  protected abstract void a(T paramT, ErrorMessage paramErrorMessage);
  
  public void a(List<T> paramList)
  {
    try
    {
      this.b.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    super.b();
    c();
  }
  
  protected void b(T paramT)
  {
    try
    {
      this.b.remove(paramT);
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramT))
      {
        SLog.d("Q.qqstory.publish.upload:BasePublishTaskManager", "the task is already exist ");
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramT);
      return;
    }
    finally {}
  }
  
  protected void b(T paramT, ErrorMessage paramErrorMessage)
  {
    if (b())
    {
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      this.b.add(paramT);
      a(paramT, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void c(T paramT)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramT);
      this.b.remove(paramT);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a().equals(paramT))) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a();
      }
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  protected void d()
  {
    Bosses.get().postLightWeightJob(new BasePublishTaskManager.1(this), 10);
  }
  
  protected void e()
  {
    try
    {
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task waiting list size:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", ((StringBuilder)localObject1).toString());
        return;
      }
      if (b())
      {
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
        return;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject1 = (BaseTaskInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = a((BaseTaskInfo)localObject1);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a(this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start publish task:");
        localStringBuilder.append(localObject1);
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.run();
      }
      else
      {
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "--- no feeds need to post");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager
 * JD-Core Version:    0.7.0.1
 */