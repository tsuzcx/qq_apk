package com.tencent.biz.richframework.network.cache;

import com.tencent.biz.richframework.network.util.Encrypt;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class Cache
{
  protected static ArrayList<String[]> jobs = new ArrayList();
  protected static int threadCount = 0;
  
  public abstract boolean cacheExists(String paramString);
  
  public abstract void clear();
  
  public abstract String get(String paramString);
  
  public String getCacheName(String paramString)
  {
    return Encrypt.md5(paramString);
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
    try
    {
      int i = threadCount;
      if (i >= 1) {
        return;
      }
      threadCount += 1;
      while (jobs.size() > 0)
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
      threadCount -= 1;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public abstract boolean set(String paramString1, String paramString2);
  
  public abstract boolean setStream(String paramString, InputStream paramInputStream);
  
  public abstract long size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.Cache
 * JD-Core Version:    0.7.0.1
 */