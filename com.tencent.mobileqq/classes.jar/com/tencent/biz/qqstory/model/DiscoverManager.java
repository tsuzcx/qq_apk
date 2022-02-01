package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscoverManager
  implements IManager
{
  private String a = "Q.qqstory:DiscoverManager";
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(CardItem paramCardItem)
  {
    EntityManager localEntityManager = c().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      CardEntry localCardEntry1 = paramCardItem.toCardEntry();
      paramCardItem = a(localEntityManager, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getCardIdSelection(), new String[] { paramCardItem.cardId });
      if (paramCardItem == null)
      {
        localEntityManager.getTransaction().end();
        return;
      }
      paramCardItem = paramCardItem.iterator();
      while (paramCardItem.hasNext())
      {
        CardEntry localCardEntry2 = (CardEntry)paramCardItem.next();
        localCardEntry2.PBData = localCardEntry1.PBData;
        localEntityManager.update(localCardEntry2);
        SLog.a(this.a, "update db cardId=%s id=%d", localCardEntry2.cardId, Long.valueOf(localCardEntry2.getId()));
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
      throw paramCardItem;
    }
  }
  
  private QQStoryContext c()
  {
    return QQStoryContext.a();
  }
  
  public DiscoverBannerVideoEntry a(String paramString)
  {
    paramString = a(QQStoryContext.a().d().createEntityManager(), DiscoverBannerVideoEntry.class, DiscoverBannerVideoEntry.class.getSimpleName(), "bannerId=?", new String[] { paramString });
    if ((paramString != null) && (paramString.size() > 0)) {
      return (DiscoverBannerVideoEntry)paramString.get(0);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString, GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse)
  {
    EntityManager localEntityManager = c().d().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      if (paramGetDiscoverBannerVideoResponse.b.size() == paramGetDiscoverBannerVideoResponse.a.size())
      {
        DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = new DiscoverBannerVideoEntry();
        localDiscoverBannerVideoEntry.bannerId = paramString;
        localDiscoverBannerVideoEntry.totalCount = paramGetDiscoverBannerVideoResponse.g;
        paramString = new ArrayList(paramGetDiscoverBannerVideoResponse.b.size());
        int i = 0;
        while (i < paramGetDiscoverBannerVideoResponse.b.size())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = new DiscoverBannerVideoEntry.BannerInfo();
          localBannerInfo.b = ((String)paramGetDiscoverBannerVideoResponse.b.get(i));
          localBannerInfo.a = ((String)paramGetDiscoverBannerVideoResponse.a.get(i));
          paramString.add(localBannerInfo);
          i += 1;
        }
        localDiscoverBannerVideoEntry.bannerInfoList = paramString;
        localDiscoverBannerVideoEntry.nextCookie = paramGetDiscoverBannerVideoResponse.f;
        localEntityManager.persistOrReplace(localDiscoverBannerVideoEntry);
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
      throw paramString;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DiscoverManager
 * JD-Core Version:    0.7.0.1
 */