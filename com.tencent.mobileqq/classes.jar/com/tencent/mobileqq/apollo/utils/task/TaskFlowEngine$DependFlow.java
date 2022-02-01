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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseTask)((Iterator)localObject).next()).a())
        {
          i = 1;
          break label47;
        }
      }
    }
    int i = 0;
    label47:
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask.c();
    }
  }
  
  public boolean a(BaseTask paramBaseTask)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList != null) && (localList.contains(paramBaseTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.DependFlow
 * JD-Core Version:    0.7.0.1
 */