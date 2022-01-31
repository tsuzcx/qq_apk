package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HotSortVideoManager
  implements IManager
{
  private EntityManager a()
  {
    return QQStoryContext.a().a().createEntityManager();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List a(String paramString)
  {
    List localList = a(a(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    SLog.a("Q.qqstory:HotSortVideoManager", "query HotSortVideoEntry id: %s, size: %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a() {}
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    EntityManager localEntityManager = a();
    paramHotSortVideoEntry.setStatus(1001);
    localEntityManager.a(paramHotSortVideoEntry);
  }
  
  public void a(List paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localEntityManager.a(localHotSortVideoEntry);
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public void a(List paramList, String paramString, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.a().a();
    Object localObject;
    HotSortVideoEntry localHotSortVideoEntry;
    if (paramBoolean) {
      try
      {
        localObject = a(paramString);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
            localHotSortVideoEntry.setStatus(1001);
            localEntityManager.b(localHotSortVideoEntry);
          }
        }
        localObject = paramList.iterator();
      }
      finally
      {
        localEntityManager.a().b();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
      localHotSortVideoEntry.groupId = paramString;
      localHotSortVideoEntry.setStatus(1000);
      localEntityManager.b(localHotSortVideoEntry);
    }
    SLog.a("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
    localEntityManager.a().c();
    localEntityManager.a().b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.HotSortVideoManager
 * JD-Core Version:    0.7.0.1
 */