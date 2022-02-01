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
import java.util.List<Ljava.lang.String;>;
import java.util.Set;

public class TagManager
  implements IManager
{
  private EntityManager a;
  private Set<String> b = Collections.synchronizedSet(new HashSet());
  private long c;
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext c()
  {
    return QQStoryContext.a();
  }
  
  public List<TagItem.TagInfoBase> a(String paramString)
  {
    Object localObject = a(this.a, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
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
  
  public List<TagItem.TagInfoBase> a(String paramString, List<StoryVideoItem> paramList)
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
  
  public List<TagItem.TagInfoBase> a(List<StoryVideoItem> paramList, List<TagItem.TagInfoBase> paramList1)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
          if ((localStoryVideoItem.mTagInfoBase != null) && (!localHashSet.contains(localStoryVideoItem.mTagInfoBase)))
          {
            localArrayList.add(localStoryVideoItem.mTagInfoBase);
            localHashSet.add(localStoryVideoItem.mTagInfoBase);
          }
        }
      }
      if (paramList1 != null)
      {
        paramList = paramList1.iterator();
        while (paramList.hasNext())
        {
          paramList1 = (TagItem.TagInfoBase)paramList.next();
          if (!localHashSet.contains(paramList1))
          {
            localArrayList.add(paramList1);
            localHashSet.add(paramList1);
          }
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a()
  {
    this.a = c().d().createEntityManager();
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (Math.abs(this.c - System.currentTimeMillis()) > 60000L)
    {
      this.b.clear();
    }
    else
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (this.b.contains(str)) {
          localArrayList.add(str);
        } else {
          ((List)localObject).add(str);
        }
      }
      paramList = (List<String>)localObject;
    }
    if (localArrayList.size() > 0) {
      SLog.d("Q.qqstory:TagManager", "request still waiting , %s", new Object[] { localArrayList });
    }
    if (paramList.size() == 0) {
      return;
    }
    this.c = System.currentTimeMillis();
    localObject = new GetFeedTagInfoListRequest();
    ((GetFeedTagInfoListRequest)localObject).e = paramList;
    CmdTaskManger.a().a((NetworkRequest)localObject, new TagManager.1(this));
    SLog.d("Q.qqstory:TagManager", "request tag list :%s", new Object[] { paramList });
  }
  
  public void b()
  {
    this.a.close();
  }
  
  public void b(String paramString, List<TagItem.TagInfoBase> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      Object localObject = a(this.a, TagEntry.class, TagEntry.class.getSimpleName(), "feedId=?", new String[] { paramString });
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagEntry localTagEntry = (TagEntry)((Iterator)localObject).next();
          localTagEntry.setStatus(1001);
          this.a.remove(localTagEntry);
        }
      }
      this.a.getTransaction().begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((TagItem.TagInfoBase)paramList.next()).a();
        ((TagEntry)localObject).feedId = paramString;
        this.a.persistOrReplace((Entity)localObject);
      }
      this.a.getTransaction().commit();
      throw paramString;
    }
    finally
    {
      try
      {
        this.a.getTransaction().end();
        return;
      }
      finally
      {
        break label185;
      }
      paramString = finally;
      this.a.getTransaction().end();
    }
    label185:
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TagManager
 * JD-Core Version:    0.7.0.1
 */