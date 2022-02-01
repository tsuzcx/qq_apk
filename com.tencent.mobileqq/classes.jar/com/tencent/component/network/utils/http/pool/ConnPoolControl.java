package com.tencent.component.network.utils.http.pool;

public abstract interface ConnPoolControl<T>
{
  public abstract int getDefaultMaxPerRoute();
  
  public abstract int getMaxPerRoute(T paramT);
  
  public abstract int getMaxTotal();
  
  public abstract PoolStats getStats(T paramT);
  
  public abstract PoolStats getTotalStats();
  
  public abstract void setDefaultMaxPerRoute(int paramInt);
  
  public abstract void setMaxPerRoute(T paramT, int paramInt);
  
  public abstract void setMaxTotal(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.ConnPoolControl
 * JD-Core Version:    0.7.0.1
 */