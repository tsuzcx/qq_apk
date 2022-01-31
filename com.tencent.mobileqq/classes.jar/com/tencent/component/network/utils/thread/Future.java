package com.tencent.component.network.utils.thread;

public abstract interface Future
{
  public abstract void cancel();
  
  public abstract Object get();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isDone();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.Future
 * JD-Core Version:    0.7.0.1
 */