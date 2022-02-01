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
  public ArrayList<T> b = new ArrayList();
  public ArrayList<T> c = new ArrayList();
  
  private void a(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)localIterator.next();
        localBaseTaskInfo.a = 6;
        localBaseTaskInfo.f = paramErrorMessage;
        this.c.add(localBaseTaskInfo);
        a(localBaseTaskInfo);
      }
      this.b.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramErrorMessage;
    }
  }
  
  public void a() {}
  
  protected void a(BasePublishTask<T> paramBasePublishTask)
  {
    try
    {
      if (this.a == paramBasePublishTask) {
        this.a = null;
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
    paramBasePublishTask.a().f = paramErrorMessage;
    if ((localBaseTaskInfo.a == 6) || (localBaseTaskInfo.a == 5) || (localBaseTaskInfo.a == 3) || (localBaseTaskInfo.a == 7))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish task:");
      localStringBuilder.append(paramBasePublishTask);
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", localStringBuilder.toString());
      if (localBaseTaskInfo.a != 5)
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
        e();
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
      this.c.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  protected abstract BasePublishTask b(T paramT);
  
  public void b()
  {
    super.b();
    d();
  }
  
  protected void b(T paramT, ErrorMessage paramErrorMessage)
  {
    if (i())
    {
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      this.c.add(paramT);
      a(paramT, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected void c(T paramT)
  {
    try
    {
      this.c.remove(paramT);
      if (this.b.contains(paramT))
      {
        SLog.d("Q.qqstory.publish.upload:BasePublishTaskManager", "the task is already exist ");
        return;
      }
      this.b.add(paramT);
      return;
    }
    finally {}
  }
  
  protected void d()
  {
    try
    {
      if (this.a != null) {
        this.a.c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void d(T paramT)
  {
    try
    {
      this.b.remove(paramT);
      this.c.remove(paramT);
      if ((this.a != null) && (this.a.a().equals(paramT))) {
        this.a.b();
      }
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  protected void e()
  {
    Bosses.get().postLightWeightJob(new BasePublishTaskManager.1(this), 10);
  }
  
  protected void f()
  {
    try
    {
      Object localObject1;
      if (this.a != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task waiting list size:");
        ((StringBuilder)localObject1).append(this.b.size());
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", ((StringBuilder)localObject1).toString());
        return;
      }
      if (i())
      {
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
        return;
      }
      if (this.b.size() > 0)
      {
        localObject1 = (BaseTaskInfo)this.b.remove(0);
        this.a = b((BaseTaskInfo)localObject1);
        this.a.a(this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start publish task:");
        localStringBuilder.append(localObject1);
        SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", localStringBuilder.toString());
        this.a.run();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager
 * JD-Core Version:    0.7.0.1
 */