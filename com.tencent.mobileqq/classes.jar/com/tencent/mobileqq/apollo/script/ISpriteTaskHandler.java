package com.tencent.mobileqq.apollo.script;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/script/ISpriteTaskHandler;", "", "addTask", "", "task", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "addTaskCallback", "callback", "Lcom/tencent/mobileqq/apollo/script/ISpriteTaskStatusCallback;", "clear", "execSpriteTask", "", "findTask", "taskId", "", "frontTask", "getTaskListSize", "incrementAndGetTaskId", "isActionRunning", "msgId", "", "isAnyTaskRunning", "removeTask", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteTaskHandler
{
  public abstract int a();
  
  @Nullable
  public abstract SpriteTaskParam a(int paramInt);
  
  public abstract void a(@Nullable ISpriteTaskStatusCallback paramISpriteTaskStatusCallback);
  
  public abstract boolean a(long paramLong);
  
  public abstract boolean a(@Nullable SpriteTaskParam paramSpriteTaskParam);
  
  @Nullable
  public abstract SpriteTaskParam b();
  
  public abstract void b(@Nullable SpriteTaskParam paramSpriteTaskParam);
  
  public abstract boolean c();
  
  public abstract int d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.ISpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */