package com.tencent.mobileqq.apollo.utils.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "(Ljava/lang/String;JJLcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStatus", "()Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TaskExecutionStatics
{
  private final long jdField_a_of_type_Long;
  @NotNull
  private final TaskExecutionStatics.Status jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<TaskExecutionStatics> jdField_a_of_type_JavaUtilList;
  private final long jdField_b_of_type_Long;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TaskExecutionStatics))
      {
        paramObject = (TaskExecutionStatics)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long != paramObject.jdField_b_of_type_Long) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status, paramObject.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilList, paramObject.jdField_a_of_type_JavaUtilList))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      long l = this.jdField_a_of_type_Long;
      n = (int)(l ^ l >>> 32);
      l = this.jdField_b_of_type_Long;
      i1 = (int)(l ^ l >>> 32);
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.jdField_b_of_type_JavaLangString;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + ((i * 31 + n) * 31 + i1) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label71;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TaskExecutionStatics(name=" + this.jdField_a_of_type_JavaLangString + ", runDurationMs=" + this.jdField_a_of_type_Long + ", totalRunDurationMs=" + this.jdField_b_of_type_Long + ", status=" + this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status + ", message=" + this.jdField_b_of_type_JavaLangString + ", subSteps=" + this.jdField_a_of_type_JavaUtilList + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskExecutionStatics
 * JD-Core Version:    0.7.0.1
 */