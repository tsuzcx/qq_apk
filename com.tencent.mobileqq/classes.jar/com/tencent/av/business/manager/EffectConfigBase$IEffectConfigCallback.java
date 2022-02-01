package com.tencent.av.business.manager;

public abstract interface EffectConfigBase$IEffectConfigCallback<T>
{
  public abstract void onDownloadFinish(long paramLong, T paramT, boolean paramBoolean);
  
  public abstract void onItemSelectedChanged(long paramLong, T paramT);
  
  public abstract void onProgressUpdate(T paramT, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback
 * JD-Core Version:    0.7.0.1
 */