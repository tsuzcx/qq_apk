package com.tencent.hippy.qq.tuwen.callback;

public abstract interface ITKDTuWenHippyObservable
  extends ITKDTuWenHippyCallback
{
  public abstract void forbidScroll(boolean paramBoolean);
  
  public abstract void onHippyLoadStatusChanged(int paramInt);
  
  public abstract void register(ITKDTuWenHippyObserver paramITKDTuWenHippyObserver);
  
  public abstract void scrollToNew();
  
  public abstract void unregister(ITKDTuWenHippyObserver paramITKDTuWenHippyObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable
 * JD-Core Version:    0.7.0.1
 */