package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HotSortVideoManager
  implements IManager
{
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private EntityManager c()
  {
    return QQStoryContext.a().d().createEntityManager();
  }
  
  public List<HotSortVideoEntry> a(String paramString)
  {
    List localList = a(c(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
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
    EntityManager localEntityManager = c();
    paramHotSortVideoEntry.setStatus(1001);
    localEntityManager.update(paramHotSortVideoEntry);
  }
  
  public void a(List<HotSortVideoEntry> paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localEntityManager.update(localHotSortVideoEntry);
      }
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<HotSortVideoEntry> paramList, String paramString, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    try
    {
      Object localObject = a(paramString);
      HotSortVideoEntry localHotSortVideoEntry;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
          localHotSortVideoEntry.setStatus(1001);
          localEntityManager.remove(localHotSortVideoEntry);
        }
      }
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
        localHotSortVideoEntry.groupId = paramString;
        localHotSortVideoEntry.setStatus(1000);
        localEntityManager.persistOrReplace(localHotSortVideoEntry);
      }
      SLog.a("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.HotSortVideoManager
 * JD-Core Version:    0.7.0.1
 */