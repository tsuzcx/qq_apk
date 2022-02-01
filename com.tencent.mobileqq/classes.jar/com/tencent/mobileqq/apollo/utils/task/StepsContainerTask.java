package com.tencent.mobileqq.apollo.utils.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/StepsContainerTask;", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "context", "Landroid/content/Context;", "subSteps", "", "(Landroid/content/Context;Ljava/util/List;)V", "steps", "Lcom/tencent/mobileqq/apollo/utils/task/TaskSteps;", "getSteps", "()Lcom/tencent/mobileqq/apollo/utils/task/TaskSteps;", "execute", "", "getSubTaskExecutionStatics", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "getTotalRunDurationMs", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class StepsContainerTask
  extends BaseTask
{
  @NotNull
  private final TaskSteps a;
  
  protected void c()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.StepsContainerTask
 * JD-Core Version:    0.7.0.1
 */