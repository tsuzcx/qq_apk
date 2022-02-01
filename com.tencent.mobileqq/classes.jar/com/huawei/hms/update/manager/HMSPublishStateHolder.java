package com.huawei.hms.update.manager;

public class HMSPublishStateHolder
{
  public static final int NOT_CHECKED = 0;
  public static final int NOT_PUBLISHED_YET = 2;
  public static final int PUBLISHED = 1;
  private static int a = 0;
  private static final Object b = new Object();
  
  public static int getPublishState()
  {
    synchronized (b)
    {
      int i = a;
      return i;
    }
  }
  
  public static void setPublishState(int paramInt)
  {
    synchronized (b)
    {
      a = paramInt;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.manager.HMSPublishStateHolder
 * JD-Core Version:    0.7.0.1
 */