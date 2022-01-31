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
  public static final String a;
  public static final String b = StoryApi.a("StoryGroupSvc.do_like_video");
  private EntityManager a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.do_like_video");
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QQStoryContext.a().a().createEntityManager();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localEntityManager.b(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localEntityManager.b(localLikeEntry);
      localEntityManager.a().c();
      return;
    }
    finally
    {
      localEntityManager.a().b();
    }
  }
  
  public void a(@NonNull List paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    EntityManager localEntityManager;
    Object localObject;
    for (;;)
    {
      localEntityManager = a().a().createEntityManager();
      localEntityManager.a().a();
      if (!paramBoolean2) {
        break;
      }
      try
      {
        localObject = a(paramString, paramBoolean1);
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = (LikeEntry)((Iterator)localObject).next();
          localLikeEntry.setStatus(1001);
          localEntityManager.b(localLikeEntry);
        }
        i = 3;
      }
      finally
      {
        localEntityManager.a().b();
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LikeEntry)paramList.next();
      ((LikeEntry)localObject).feedId = paramString;
      ((LikeEntry)localObject).type = i;
      localEntityManager.b((Entity)localObject);
    }
    localEntityManager.a().c();
    localEntityManager.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.LikeManager
 * JD-Core Version:    0.7.0.1
 */