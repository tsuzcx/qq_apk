package com.tencent.biz.richframework.network.cache;

import java.io.InputStream;
import java.util.ArrayList;
import udo;

public abstract class Cache
{
  protected static ArrayList<String[]> jobs = new ArrayList();
  protected static int threadCount;
  
  public abstract boolean cacheExists(String paramString);
  
  public abstract void clear();
  
  public abstract String get(String paramString);
  
  public String getCacheName(String paramString)
  {
    return udo.c(paramString);
  }
  
  public abstract Cache.CacheInputStream getStream(String paramString);
  
  public void interrupt(String paramString) {}
  
  public void lazySet(String paramString1, String paramString2)
  {
    jobs.add(new String[] { paramString1, paramString2 });
    new Thread(new Cache.1(this)).start();
  }
  
  public abstract void remove(String paramString);
  
  protected void runJob()
  {
    for (;;)
    {
      try
      {
        int i = threadCount;
        if (i >= 1) {
          return;
        }
        threadCount += 1;
        if (jobs.size() > 0)
        {
          String[] arrayOfString = (String[])jobs.remove(0);
          set(arrayOfString[0], arrayOfString[1]);
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        else
        {
          threadCount -= 1;
        }
      }
      finally {}
    }
  }
  
  public abstract boolean set(String paramString1, String paramString2);
  
  public abstract boolean setStream(String paramString, InputStream paramInputStream);
  
  public abstract long size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.Cache
 * JD-Core Version:    0.7.0.1
 */