package com.tencent.component.network.utils.http.pool;

public abstract interface FutureCallback<T>
{
  public abstract void cancelled();
  
  public abstract void completed(T paramT);
  
  public abstract void failed(Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.FutureCallback
 * JD-Core Version:    0.7.0.1
 */