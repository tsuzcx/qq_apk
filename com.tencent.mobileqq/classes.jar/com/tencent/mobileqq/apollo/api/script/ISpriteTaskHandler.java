package com.tencent.mobileqq.apollo.api.script;

import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/script/ISpriteTaskHandler;", "", "addTask", "", "task", "Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "addTaskCallback", "callback", "Lcom/tencent/mobileqq/apollo/script/callback/ISpriteTaskStatusCallback;", "clear", "execSpriteTask", "", "findTask", "taskId", "", "frontTask", "getTaskListSize", "incrementAndGetTaskId", "isActionRunning", "msgId", "", "isAnyTaskRunning", "removeTask", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteTaskHandler
{
  public abstract int a();
  
  @Nullable
  public abstract SpriteTaskParam a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void a(@Nullable SpriteTaskParam paramSpriteTaskParam);
  
  public abstract void a(@Nullable ISpriteTaskStatusCallback paramISpriteTaskStatusCallback);
  
  public abstract boolean a();
  
  public abstract boolean a(long paramLong);
  
  public abstract boolean a(@Nullable SpriteTaskParam paramSpriteTaskParam);
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */