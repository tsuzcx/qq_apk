package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class AppletAccountCache
  extends FullCache
{
  public AppletAccountCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, AppletsAccountInfo.class);
  }
  
  public AppletsAccountInfo a(String paramString)
  {
    return (AppletsAccountInfo)findCache(paramString);
  }
  
  public void a()
  {
    Object localObject = this.a.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).query(AppletsAccountInfo.class);
    ((EntityManager)localObject).close();
    if (localList != null)
    {
      b();
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)((Iterator)localObject).next();
        this.cacheMap.put(String.valueOf(localAppletsAccountInfo.uin), localAppletsAccountInfo);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInit size = ");
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("AppletAccountCache", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveAppletsAccount AppletsAccount = ");
      localStringBuilder.append(paramAppletsAccountInfo);
      QLog.d("AppletAccountCache", 2, localStringBuilder.toString());
    }
    addCache(paramAppletsAccountInfo);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void b()
  {
    this.cacheMap.clear();
  }
  
  protected void destroy() {}
  
  protected String getKey(Entity paramEntity)
  {
    return ((AppletsAccountInfo)paramEntity).uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.AppletAccountCache
 * JD-Core Version:    0.7.0.1
 */