package com.tencent.component.network.utils.http.pool;

import java.util.concurrent.Future;

public abstract interface ConnPool<T, E>
{
  public abstract Future<E> lease(T paramT, Object paramObject, FutureCallback<E> paramFutureCallback);
  
  public abstract void release(E paramE, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.ConnPool
 * JD-Core Version:    0.7.0.1
 */