package com.tencent.mobileqq.apollo.utils.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "(Ljava/lang/String;JJLcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStatus", "()Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
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
    if (this != paramObject) {
      if ((paramObject instanceof TaskExecutionStatics))
      {
        paramObject = (TaskExecutionStatics)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_b_of_type_Long == paramObject.jdField_b_of_type_Long) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status, paramObject.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilList, paramObject.jdField_a_of_type_JavaUtilList))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = this.jdField_a_of_type_Long;
    int n = (int)(l ^ l >>> 32);
    l = this.jdField_b_of_type_Long;
    int i1 = (int)(l ^ l >>> 32);
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.jdField_b_of_type_JavaLangString;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((i * 31 + n) * 31 + i1) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TaskExecutionStatics(name=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", runDurationMs=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", totalRunDurationMs=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskTaskExecutionStatics$Status);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", subSteps=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskExecutionStatics
 * JD-Core Version:    0.7.0.1
 */