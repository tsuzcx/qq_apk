package com.tencent.beacon.core.network.volley;

public abstract interface Cache
{
  public abstract void clear();
  
  public abstract Cache.Entry get(String paramString);
  
  public abstract void initialize();
  
  public abstract void invalidate(String paramString, boolean paramBoolean);
  
  public abstract void put(String paramString, Cache.Entry paramEntry);
  
  public abstract void remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Cache
 * JD-Core Version:    0.7.0.1
 */