package com.tencent.component.network.utils.http.pool;

public abstract interface ConnFactory<T, C>
{
  public abstract C create(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.ConnFactory
 * JD-Core Version:    0.7.0.1
 */