package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LikeManager
  implements IManager
{
  public static final String a = StoryApi.a("StorySvc.do_like_video");
  public static final String b = StoryApi.a("StoryGroupSvc.do_like_video");
  private EntityManager c;
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext c()
  {
    return QQStoryContext.a();
  }
  
  public List<LikeEntry> a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 3;
    }
    List localList = a(this.c, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
    paramString = localList;
    if (localList == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public void a()
  {
    this.c = QQStoryContext.a().d().createEntityManager();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    EntityManager localEntityManager = c().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localEntityManager.persistOrReplace(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localEntityManager.persistOrReplace(localLikeEntry);
      localEntityManager.getTransaction().commit();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
  }
  
  public void a(@NonNull List<LikeEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    } else {
      i = 3;
    }
    EntityManager localEntityManager = c().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean2) {}
    try
    {
      Object localObject = a(paramString, paramBoolean1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = (LikeEntry)((Iterator)localObject).next();
          localLikeEntry.setStatus(1001);
          localEntityManager.remove(localLikeEntry);
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (LikeEntry)paramList.next();
        ((LikeEntry)localObject).feedId = paramString;
        ((LikeEntry)localObject).type = i;
        localEntityManager.persistOrReplace((Entity)localObject);
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
  
  public void b()
  {
    this.c.close();
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.c.remove(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.LikeManager
 * JD-Core Version:    0.7.0.1
 */