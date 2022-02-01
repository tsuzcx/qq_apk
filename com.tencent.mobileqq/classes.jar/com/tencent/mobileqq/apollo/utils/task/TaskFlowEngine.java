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
  private TaskThreadPool jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskThreadPool;
  private final List<TaskFlowEngine.DependFlow> jdField_a_of_type_JavaUtilList = new ArrayList();
  private BaseTask[] jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask;
  private List<BaseTask> b = new ArrayList();
  
  public TaskFlowEngine()
  {
    try
    {
      int j = ARDeviceInfo.b();
      QLog.w("TaskFlow", 1, "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskThreadPool = new TaskThreadPool("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TaskFlow", 1, "create thread pool error!", localException);
    }
  }
  
  private void d(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
      paramBaseTask.a(this);
      if (!this.b.contains(paramBaseTask)) {
        this.b.add(paramBaseTask);
      }
      paramBaseTask = paramBaseTask.a();
      if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
      {
        paramBaseTask = paramBaseTask.iterator();
        while (paramBaseTask.hasNext()) {
          d((BaseTask)paramBaseTask.next());
        }
      }
    }
  }
  
  private void e(BaseTask arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.a();
    if ((localList == null) || (localList.size() <= 0))
    {
      ???.c();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (((TaskFlowEngine.DependFlow)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new TaskFlowEngine.DependFlow(this, ???, localList);
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          e((BaseTask)???.next());
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask.length <= 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskThreadPool.a(new TaskFlowEngine.1(this));
  }
  
  public void a(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    while (!paramBaseTask.b()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskThreadPool.a(new TaskFlowEngine.2(this, paramBaseTask));
  }
  
  public final void a(BaseTask[] paramArrayOfBaseTask)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask = paramArrayOfBaseTask;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask == null) {}
    for (;;)
    {
      return;
      paramArrayOfBaseTask = this.jdField_a_of_type_ArrayOfComTencentMobileqqApolloUtilsTaskBaseTask;
      int j = paramArrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        d(paramArrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  public void b(BaseTask paramBaseTask) {}
  
  protected void c(BaseTask paramBaseTask)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TaskFlowEngine.DependFlow localDependFlow = (TaskFlowEngine.DependFlow)localIterator.next();
        if (localDependFlow.a(paramBaseTask)) {
          localDependFlow.a();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine
 * JD-Core Version:    0.7.0.1
 */