package com.tencent.imcore.message.basic;

public abstract interface MapClassGenerator<K, V>
{
  public abstract V a(K paramK);
  
  public abstract void a(K paramK, Class<? extends V> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.basic.MapClassGenerator
 * JD-Core Version:    0.7.0.1
 */