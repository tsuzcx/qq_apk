package com.tencent.mobileqq.apollo.utils.task;

import anmp;
import anms;

public class TaskFlowEngine$1
  implements Runnable
{
  public TaskFlowEngine$1(anms paramanms) {}
  
  public void run()
  {
    anmp[] arrayOfanmp = anms.a(this.this$0);
    int j = arrayOfanmp.length;
    int i = 0;
    while (i < j)
    {
      anmp localanmp = arrayOfanmp[i];
      anms.a(this.this$0, localanmp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */