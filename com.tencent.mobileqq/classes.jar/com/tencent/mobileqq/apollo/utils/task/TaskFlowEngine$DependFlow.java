package com.tencent.mobileqq.apollo.utils.task;

import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine$DependFlow
{
  BaseTask jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask;
  List<BaseTask> jdField_a_of_type_JavaUtilList;
  
  TaskFlowEngine$DependFlow(BaseTask paramBaseTask, List<BaseTask> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask = paramList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((BaseTask)localIterator.next()).a());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask.c();
      }
      return;
    }
  }
  
  public boolean a(BaseTask paramBaseTask)
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramBaseTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.DependFlow
 * JD-Core Version:    0.7.0.1
 */