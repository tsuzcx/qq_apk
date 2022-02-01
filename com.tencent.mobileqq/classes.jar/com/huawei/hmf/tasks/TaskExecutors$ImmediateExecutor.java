package com.huawei.hmf.tasks;

import java.util.concurrent.Executor;

final class TaskExecutors$ImmediateExecutor
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.TaskExecutors.ImmediateExecutor
 * JD-Core Version:    0.7.0.1
 */