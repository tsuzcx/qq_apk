package com.tencent.mobileqq.apollo.utils.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/utils/task/TaskSteps$callback$1", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask$Callback;", "onTaskBegin", "", "task", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "onTaskDone", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TaskSteps$callback$1
  implements BaseTask.Callback
{
  public void a(@NotNull BaseTask paramBaseTask)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTask, "task");
    TaskSteps.a(this.a, paramBaseTask);
  }
  
  public void b(@NotNull BaseTask paramBaseTask)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTask, "task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskSteps.callback.1
 * JD-Core Version:    0.7.0.1
 */