package com.tencent.mobileqq.apollo.utils.task;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/TaskSteps;", "", "containerTask", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "subTasks", "", "(Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;Ljava/util/List;)V", "currentStep", "getCurrentStep", "()Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "currentStepIndex", "", "isExecuting", "", "()Z", "executeNextStep", "", "getStepExecutionStatics", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "onStepDone", "task", "start", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TaskSteps
{
  private int a;
  private final BaseTask b;
  private final List<BaseTask> c;
  
  private final void a(BaseTask paramBaseTask)
  {
    if (paramBaseTask.h())
    {
      c();
      return;
    }
    this.a = -1;
    this.b.a(paramBaseTask.e, paramBaseTask.f);
  }
  
  private final void c()
  {
    this.a += 1;
    if (this.a >= this.c.size())
    {
      this.b.j();
      return;
    }
    a().g();
  }
  
  @NotNull
  public final BaseTask a()
  {
    return (BaseTask)this.c.get(this.a);
  }
  
  public final void b()
  {
    if (this.a == -1)
    {
      c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("already executing ");
    localStringBuilder.append(a());
    localStringBuilder.append('!');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskSteps
 * JD-Core Version:    0.7.0.1
 */