package com.tencent.mobileqq.activity.richmedia.p2veffect.listener;

public abstract interface IControllerPrepareListener
{
  public abstract void onCompleted(int[] paramArrayOfInt);
  
  public abstract void onDurationGot(long paramLong);
  
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onStartPrepare();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerPrepareListener
 * JD-Core Version:    0.7.0.1
 */