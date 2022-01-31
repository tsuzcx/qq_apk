package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nda;

public class TagManager
  implements IManager
{
  private long jdField_a_of_type_Long;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List a(String paramString)
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    localObject = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((List)localObject).add(new TagItem.TagInfoBase((TagEntry)paramString.next()));
    }
    return localObject;
  }
  
  public List a(String paramString, List paramList)
  {
    try
    {
      paramString = a(paramList, a(paramString));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public List a(List paramList1, List paramList2)
  {
    ArrayList localArrayList;
    HashSet localHashSet;
    try
    {
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      if (paramList1 != null)
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList1.next();
          if ((localStoryVideoItem.mTagInfoBase != null) && (!localHashSet.contains(localStoryVideoItem.mTagInfoBase)))
          {
            localArrayList.add(localStoryVideoItem.mTagInfoBase);
            localHashSet.add(localStoryVideoItem.mTagInfoBase);
          }
        }
      }
      if (paramList2 == null) {
        break label167;
      }
    }
    finally {}
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (TagItem.TagInfoBase)paramList1.next();
      if (!localHashSet.contains(paramList2))
      {
        localArrayList.add(paramList2);
        localHashSet.add(paramList2);
      }
    }
    label167:
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().a().createEntityManager();
  }
  
  public void a(String paramString, List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TagEntry localTagEntry = (TagEntry)((Iterator)localObject).next();
            localTagEntry.setStatus(1001);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTagEntry);
          }
        }
      }
      finally
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().b();
          throw paramString;
        }
        finally {}
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().a();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = ((TagItem.TagInfoBase)paramList.next()).a();
          ((TagEntry)localObject).feedId = paramString;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().c();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().b();
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()) > 60000L) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        SLog.d("Q.qqstory:TagManager", "request still waiting , %s", new Object[] { localArrayList });
      }
      if (paramList.size() == 0) {
        break;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = new GetFeedTagInfoListRequest();
      ((GetFeedTagInfoListRequest)localObject).a = paramList;
      CmdTaskManger.a().a((NetworkRequest)localObject, new nda(this));
      SLog.d("Q.qqstory:TagManager", "request tag list :%s", new Object[] { paramList });
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          localArrayList.add(str);
        } else {
          ((List)localObject).add(str);
        }
      }
      paramList = (List)localObject;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TagManager
 * JD-Core Version:    0.7.0.1
 */