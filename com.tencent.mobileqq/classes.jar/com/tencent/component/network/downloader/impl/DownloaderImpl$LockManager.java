package com.tencent.component.network.downloader.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DownloaderImpl$LockManager
{
  private Object Lock = new Object();
  private Map<String, Object> mActiveLocks = new HashMap();
  private List<Object> mIdleLockObjects = new ArrayList();
  
  private DownloaderImpl$LockManager(DownloaderImpl paramDownloaderImpl) {}
  
  public Object obtaionLock(String paramString)
  {
    for (;;)
    {
      synchronized (this.Lock)
      {
        if (this.mActiveLocks.containsKey(paramString))
        {
          paramString = this.mActiveLocks.get(paramString);
          return paramString;
        }
        if (this.mIdleLockObjects.size() > 0)
        {
          localObject1 = this.mIdleLockObjects.remove(0);
          this.mActiveLocks.put(paramString, localObject1);
          return localObject1;
        }
      }
      Object localObject1 = new Object();
    }
  }
  
  public void releaseLock(String paramString)
  {
    synchronized (this.Lock)
    {
      if (!this.mActiveLocks.containsKey(paramString)) {
        return;
      }
      paramString = this.mActiveLocks.remove(paramString);
      if ((paramString != null) && (!this.mIdleLockObjects.contains(paramString))) {
        this.mIdleLockObjects.add(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl.LockManager
 * JD-Core Version:    0.7.0.1
 */