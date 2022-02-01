package com.tencent.mobileqq.apollo.utils.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "(Ljava/lang/String;JJLcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStatus", "()Lcom/tencent/mobileqq/apollo/utils/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TaskExecutionStatics
{
  @NotNull
  private final String a;
  private final long b;
  private final long c;
  @NotNull
  private final TaskExecutionStatics.Status d;
  @NotNull
  private final String e;
  @NotNull
  private final List<TaskExecutionStatics> f;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TaskExecutionStatics))
      {
        paramObject = (TaskExecutionStatics)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f))) {}
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
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = this.b;
    int n = (int)(l ^ l >>> 32);
    l = this.c;
    int i1 = (int)(l ^ l >>> 32);
    localObject = this.d;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.e;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.f;
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", runDurationMs=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalRunDurationMs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", subSteps=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskExecutionStatics
 * JD-Core Version:    0.7.0.1
 */