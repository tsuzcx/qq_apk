package com.tencent.mobileqq.apollo.utils.task;

import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine$DependFlow
{
  BaseTask a;
  List<BaseTask> b;
  
  TaskFlowEngine$DependFlow(BaseTask paramBaseTask, List<BaseTask> paramList)
  {
    this.a = paramList;
    Object localObject;
    this.b = localObject;
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseTask)((Iterator)localObject).next()).e())
        {
          i = 1;
          break label47;
        }
      }
    }
    int i = 0;
    label47:
    if (i == 0) {
      this.a.g();
    }
  }
  
  public boolean a(BaseTask paramBaseTask)
  {
    List localList = this.b;
    return (localList != null) && (localList.contains(paramBaseTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.DependFlow
 * JD-Core Version:    0.7.0.1
 */