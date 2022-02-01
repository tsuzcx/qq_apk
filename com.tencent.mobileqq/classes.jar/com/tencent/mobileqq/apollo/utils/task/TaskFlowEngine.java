package com.tencent.mobileqq.apollo.utils.task;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.ARDeviceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine
  implements Handler.Callback, BaseTask.Callback
{
  private TaskThreadPool a;
  private BaseTask[] b;
  private final List<TaskFlowEngine.DependFlow> c = new ArrayList();
  private List<BaseTask> d = new ArrayList();
  
  public TaskFlowEngine()
  {
    for (;;)
    {
      try
      {
        i = ARDeviceInfo.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create thread pool, cpuCores=");
        localStringBuilder.append(i);
        QLog.w("[cmshow]TaskFlow", 1, localStringBuilder.toString());
        if (i > 0)
        {
          i += 1;
          this.a = new TaskThreadPool("TaskFlowEngine", 2, i);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]TaskFlow", 1, "create thread pool error!", localException);
        return;
      }
      int i = 2;
    }
  }
  
  private void d(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    paramBaseTask.a(this);
    if (!this.d.contains(paramBaseTask)) {
      this.d.add(paramBaseTask);
    }
    paramBaseTask = paramBaseTask.d();
    if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
    {
      paramBaseTask = paramBaseTask.iterator();
      while (paramBaseTask.hasNext()) {
        d((BaseTask)paramBaseTask.next());
      }
    }
  }
  
  private void e(BaseTask arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.d();
    if ((localList != null) && (localList.size() > 0))
    {
      int j = 0;
      Object localObject2 = this.c.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (((TaskFlowEngine.DependFlow)((Iterator)localObject2).next()).a != ???);
      int i = 1;
      if (i == 0)
      {
        localObject2 = new TaskFlowEngine.DependFlow(this, ???, localList);
        synchronized (this.c)
        {
          this.c.add(localObject2);
        }
      }
      ??? = localObject1.iterator();
      while (???.hasNext()) {
        e((BaseTask)???.next());
      }
      return;
    }
    ???.g();
  }
  
  public void a(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    if (paramBaseTask.h()) {
      this.a.a(new TaskFlowEngine.2(this, paramBaseTask));
    }
  }
  
  public final void a(BaseTask[] paramArrayOfBaseTask)
  {
    this.c.clear();
    this.d.clear();
    this.b = paramArrayOfBaseTask;
    paramArrayOfBaseTask = this.b;
    if (paramArrayOfBaseTask == null) {
      return;
    }
    int j = paramArrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      d(paramArrayOfBaseTask[i]);
      i += 1;
    }
  }
  
  public void b(BaseTask paramBaseTask) {}
  
  public void c()
  {
    BaseTask[] arrayOfBaseTask = this.b;
    if (arrayOfBaseTask != null)
    {
      if (arrayOfBaseTask.length <= 0) {
        return;
      }
      this.a.a(new TaskFlowEngine.1(this));
    }
  }
  
  protected void c(BaseTask paramBaseTask)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        TaskFlowEngine.DependFlow localDependFlow = (TaskFlowEngine.DependFlow)localIterator.next();
        if (localDependFlow.a(paramBaseTask)) {
          localDependFlow.a();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramBaseTask;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine
 * JD-Core Version:    0.7.0.1
 */