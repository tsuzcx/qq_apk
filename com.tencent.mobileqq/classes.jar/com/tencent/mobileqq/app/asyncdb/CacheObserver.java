package com.tencent.mobileqq.app.asyncdb;

public class CacheObserver
{
  public static final int EVENT_CACHE_INIT = 0;
  
  public void notifyEvent(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    onInit();
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.CacheObserver
 * JD-Core Version:    0.7.0.1
 */