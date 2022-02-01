package com.tencent.mobileqq.apollo.script.callback;

import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;

public abstract interface ISpriteTaskStatusCallback
{
  public abstract void onTaskComplete(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt);
  
  public abstract void onTaskStart(SpriteTaskParam paramSpriteTaskParam, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback
 * JD-Core Version:    0.7.0.1
 */