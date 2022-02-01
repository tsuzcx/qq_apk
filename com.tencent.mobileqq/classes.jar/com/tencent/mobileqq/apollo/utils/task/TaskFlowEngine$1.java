package com.tencent.mobileqq.apollo.utils.task;

class TaskFlowEngine$1
  implements Runnable
{
  TaskFlowEngine$1(TaskFlowEngine paramTaskFlowEngine) {}
  
  public void run()
  {
    BaseTask[] arrayOfBaseTask = TaskFlowEngine.a(this.this$0);
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      BaseTask localBaseTask = arrayOfBaseTask[i];
      TaskFlowEngine.a(this.this$0, localBaseTask);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */