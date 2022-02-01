package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentManager
  implements IManager
{
  private EntityManager a;
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<CommentEntry> a()
  {
    Object localObject = QQStoryContext.a().b();
    List localList = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "status<>? and authorUnionId=?", new String[] { String.valueOf(0), localObject });
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    SLog.a("Q.qqstory:CommentManager", "query fail comment's size = %d", Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public List<CommentEntry> a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 3;
    }
    List localList = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    SLog.a("Q.qqstory:CommentManager", "query comment feeds id %s, %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a()
  {
    this.a = a().a().createEntityManager();
  }
  
  public void a(int paramInt)
  {
    Object localObject = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "commentId=?", new String[] { String.valueOf(paramInt) });
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)((Iterator)localObject).next();
      localCommentEntry.setStatus(1001);
      this.a.remove(localCommentEntry);
    }
  }
  
  public void a(@NonNull CommentEntry paramCommentEntry)
  {
    paramCommentEntry.setStatus(1000);
    this.a.persistOrReplace(paramCommentEntry);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      Object localObject1 = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "feedId=? and commentId=?", new String[] { paramString, String.valueOf(paramInt) });
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        int j = 0;
        i = 0;
        for (;;)
        {
          m = j;
          k = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (CommentEntry)((Iterator)localObject1).next();
          if (((CommentEntry)localObject2).type == 3) {
            j = 1;
          } else if (((CommentEntry)localObject2).type == 4) {
            i = 1;
          }
        }
      }
      int m = 0;
      int k = 0;
      int i = this.a.delete(CommentEntry.class.getSimpleName(), "commentId=? and feedId=? and type in (?,?)", new String[] { String.valueOf(paramInt), paramString, String.valueOf(4), String.valueOf(3) });
      localObject1 = (FeedManager)SuperManager.a(11);
      Object localObject2 = (CommentLikeFeedItem)((FeedManager)localObject1).a(paramString);
      if (localObject2 == null) {
        return;
      }
      if (i > 0)
      {
        if (m != 0)
        {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount -= 1;
          if (((CommentLikeFeedItem)localObject2).mFriendCommentCount < 0) {
            ((CommentLikeFeedItem)localObject2).mFriendCommentCount = 0;
          }
        }
        if (k != 0)
        {
          ((CommentLikeFeedItem)localObject2).mFanCommentCount -= 1;
          if (((CommentLikeFeedItem)localObject2).mFanCommentCount < 0) {
            ((CommentLikeFeedItem)localObject2).mFanCommentCount = 0;
          }
        }
      }
      ((CommentLikeFeedItem)localObject2).mCommentCount -= 1;
      if (((CommentLikeFeedItem)localObject2).mCommentCount < 0) {
        ((CommentLikeFeedItem)localObject2).mCommentCount = 0;
      }
      ((FeedManager)localObject1).a((FeedItem)localObject2);
      paramString = new FeedInfoChangeEvent(4, paramString, 2, (CommentLikeFeedItem)localObject2);
      paramString.c = paramInt;
      StoryDispatcher.a().dispatch(paramString);
      return;
    }
    SLog.d("Q.qqstory:CommentManager", "push info invalidate feedId:%s, commentId:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(@NonNull List<CommentEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    } else {
      i = 3;
    }
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean2) {}
    try
    {
      Object localObject1 = a(paramString, paramBoolean1);
      SLog.a("Q.qqstory:CommentManager", "delete comment feeds id %s, %d", paramString, Integer.valueOf(((List)localObject1).size()));
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CommentEntry)((Iterator)localObject1).next();
          ((CommentEntry)localObject2).setStatus(1001);
          if (((CommentEntry)localObject2).status == 0) {
            localEntityManager.remove((Entity)localObject2);
          }
        }
      }
      localObject1 = this.a;
      Object localObject2 = CommentEntry.class.getSimpleName();
      int j = 0;
      localObject1 = a((EntityManager)localObject1, CommentEntry.class, (String)localObject2, "feedId=? and type=? and status<>? ", new String[] { paramString, String.valueOf(i), String.valueOf(0) });
      if (localObject1 != null) {
        j = ((List)localObject1).size();
      }
      SLog.a("Q.qqstory:CommentManager", "fail comment size:%d for feedId:%s", Integer.valueOf(j), paramString);
      localObject2 = new ArrayList(j);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        localCommentEntry.feedId = paramString;
        localCommentEntry.type = i;
        localCommentEntry.setStatus(1000);
        localEntityManager.persistOrReplace(localCommentEntry);
        if (localObject1 != null)
        {
          j = ((List)localObject1).indexOf(localCommentEntry);
          if (j != -1) {
            ((List)localObject2).add(((List)localObject1).get(j));
          }
        }
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localEntityManager.remove((CommentEntry)((Iterator)localObject1).next());
      }
      SLog.a("Q.qqstory:CommentManager", "insert comment feeds id %s, %d", paramString, Integer.valueOf(paramList.size()));
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
  
  public List<CommentEntry> b(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, paramBoolean);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.size())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramString.get(i);
      if (localCommentEntry.status != 0)
      {
        localCommentEntry.status = 2;
        localArrayList.add(localCommentEntry);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.a.close();
  }
  
  public void b(@NonNull CommentEntry paramCommentEntry)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramCommentEntry.type = 3;
      paramCommentEntry.setStatus(1000);
      localEntityManager.persistOrReplace(paramCommentEntry);
      CommentEntry localCommentEntry = new CommentEntry();
      localCommentEntry.copy(paramCommentEntry);
      localCommentEntry.type = 4;
      localCommentEntry.setStatus(1000);
      localEntityManager.persistOrReplace(localCommentEntry);
      localEntityManager.getTransaction().commit();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
  }
  
  public void c(@NonNull CommentEntry paramCommentEntry)
  {
    localEntityManager = a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      localObject1 = this.a;
      localObject2 = CommentEntry.class.getSimpleName();
      int j = paramCommentEntry.commentId;
      i = 0;
      localObject1 = a((EntityManager)localObject1, CommentEntry.class, (String)localObject2, "commentId=? and feedId=?", new String[] { String.valueOf(j), paramCommentEntry.feedId });
      if (localObject1 == null)
      {
        localEntityManager.getTransaction().end();
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        localEntityManager.getTransaction().end();
        for (;;)
        {
          throw paramCommentEntry;
        }
        i += 1;
      }
    }
    if (i < ((List)localObject1).size())
    {
      localObject2 = (CommentEntry)((List)localObject1).get(i);
      if (((CommentEntry)localObject2).type == 3)
      {
        ((CommentEntry)localObject2).copy(paramCommentEntry);
        ((CommentEntry)localObject2).type = 3;
        localEntityManager.update((Entity)localObject2);
      }
      else if (((CommentEntry)localObject2).type == 4)
      {
        ((CommentEntry)localObject2).copy(paramCommentEntry);
        ((CommentEntry)localObject2).type = 4;
        localEntityManager.update((Entity)localObject2);
      }
    }
    else
    {
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
  }
  
  public void d(@NonNull CommentEntry paramCommentEntry)
  {
    paramCommentEntry.setStatus(1001);
    this.a.remove(paramCommentEntry, "commentId=? and feedId=? and type in (?,?)", new String[] { String.valueOf(paramCommentEntry.commentId), paramCommentEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.CommentManager
 * JD-Core Version:    0.7.0.1
 */