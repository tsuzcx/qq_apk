package com.tencent.image.api;

public abstract interface ICache
{
  public abstract void evictAll();
  
  public abstract Object get(String paramString);
  
  public abstract byte getNormalPriority();
  
  public abstract Object put(String paramString, Object paramObject, byte paramByte);
  
  public abstract void remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.api.ICache
 * JD-Core Version:    0.7.0.1
 */