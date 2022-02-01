package com.tencent.mobileqq.apollo.utils.task;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/TaskSteps;", "", "containerTask", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "subTasks", "", "(Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;Ljava/util/List;)V", "currentStep", "getCurrentStep", "()Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "currentStepIndex", "", "isExecuting", "", "()Z", "executeNextStep", "", "getStepExecutionStatics", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "onStepDone", "task", "start", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TaskSteps
{
  private int jdField_a_of_type_Int;
  private final BaseTask jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask;
  private final List<BaseTask> jdField_a_of_type_JavaUtilList;
  
  private final void a(BaseTask paramBaseTask)
  {
    if (paramBaseTask.b())
    {
      b();
      return;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask.a(paramBaseTask.jdField_a_of_type_Int, paramBaseTask.b);
  }
  
  private final void b()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask.e();
      return;
    }
    a().c();
  }
  
  @NotNull
  public final BaseTask a()
  {
    return (BaseTask)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      b();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("already executing ");
    localStringBuilder.append(a());
    localStringBuilder.append('!');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskSteps
 * JD-Core Version:    0.7.0.1
 */