package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.database.SquareBannerEntry;
import com.tencent.biz.qqstory.database.SquareFeedListEntry;
import com.tencent.biz.qqstory.database.TopicInfoEntry;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.square.model.SquareBannerItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ngo;

public class DiscoverManager
  implements IManager
{
  private String a;
  
  public DiscoverManager()
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory:DiscoverManager";
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void b(CardItem paramCardItem)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      CardEntry localCardEntry1 = paramCardItem.toCardEntry();
      paramCardItem = a(localEntityManager, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getCardIdSelection(), new String[] { paramCardItem.cardId });
      if (paramCardItem == null) {
        return;
      }
      paramCardItem = paramCardItem.iterator();
      while (paramCardItem.hasNext())
      {
        CardEntry localCardEntry2 = (CardEntry)paramCardItem.next();
        localCardEntry2.PBData = localCardEntry1.PBData;
        localEntityManager.a(localCardEntry2);
        SLog.a(this.jdField_a_of_type_JavaLangString, "update db cardId=%s id=%d", localCardEntry2.cardId, Long.valueOf(localCardEntry2.getId()));
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public DiscoverBannerVideoEntry a(String paramString)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), DiscoverBannerVideoEntry.class, DiscoverBannerVideoEntry.class.getSimpleName(), "bannerId=?", new String[] { paramString });
    if ((paramString != null) && (paramString.size() > 0)) {
      return (DiscoverBannerVideoEntry)paramString.get(0);
    }
    return null;
  }
  
  public List a()
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = StoryManager.a((EntityManager)localObject, SquareFeedListEntry.class, SquareFeedListEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((SquareFeedListEntry)((Iterator)localObject).next()).feedId);
    }
    return localArrayList;
  }
  
  public List a(int paramInt, long paramLong)
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = a((EntityManager)localObject, CardEntry.class, CardEntry.class.getSimpleName(), CardEntry.getTypeSelection(paramInt, paramLong), null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new CardItem((CardEntry)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    TopicInfoEntry localTopicInfoEntry = new TopicInfoEntry();
    localTopicInfoEntry.topicId = paramLong;
    localTopicInfoEntry.topicPbData = paramArrayOfByte;
    QQStoryContext.a().a().createEntityManager().b(localTopicInfoEntry);
  }
  
  public void a(CardItem paramCardItem)
  {
    Bosses.get().postLightWeightJob(new ngo(this, paramCardItem), 0);
  }
  
  public void a(String paramString, GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      if (paramGetDiscoverBannerVideoResponse.jdField_b_of_type_JavaUtilList.size() == paramGetDiscoverBannerVideoResponse.jdField_a_of_type_JavaUtilList.size())
      {
        DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = new DiscoverBannerVideoEntry();
        localDiscoverBannerVideoEntry.bannerId = paramString;
        localDiscoverBannerVideoEntry.totalCount = paramGetDiscoverBannerVideoResponse.jdField_b_of_type_Int;
        paramString = new ArrayList(paramGetDiscoverBannerVideoResponse.jdField_b_of_type_JavaUtilList.size());
        int i = 0;
        while (i < paramGetDiscoverBannerVideoResponse.jdField_b_of_type_JavaUtilList.size())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = new DiscoverBannerVideoEntry.BannerInfo();
          localBannerInfo.b = ((String)paramGetDiscoverBannerVideoResponse.jdField_b_of_type_JavaUtilList.get(i));
          localBannerInfo.jdField_a_of_type_JavaLangString = ((String)paramGetDiscoverBannerVideoResponse.jdField_a_of_type_JavaUtilList.get(i));
          paramString.add(localBannerInfo);
          i += 1;
        }
        localDiscoverBannerVideoEntry.bannerInfoList = paramString;
        localDiscoverBannerVideoEntry.nextCookie = paramGetDiscoverBannerVideoResponse.jdField_a_of_type_JavaLangString;
        localEntityManager.b(localDiscoverBannerVideoEntry);
      }
      localEntityManager.a().c();
      return;
    }
    finally
    {
      localEntityManager.a().b();
    }
  }
  
  public void a(@NonNull List paramList, int paramInt, long paramLong, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    if (paramBoolean) {}
    try
    {
      CardEntry localCardEntry = new CardEntry();
      localCardEntry.setStatus(1001);
      localEntityManager.a(localCardEntry, CardEntry.getTypeSelection(paramInt, paramLong), null);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localCardEntry = ((CardItem)paramList.next()).toCardEntry();
        localCardEntry.cardListType = paramInt;
        localCardEntry.topicId = paramLong;
        localEntityManager.b(localCardEntry);
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    if (paramBoolean) {}
    try
    {
      localEntityManager.a(SquareFeedListEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        SquareFeedListEntry localSquareFeedListEntry = new SquareFeedListEntry();
        localSquareFeedListEntry.feedId = str;
        localEntityManager.b(localSquareFeedListEntry);
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public byte[] a(long paramLong)
  {
    List localList = a(QQStoryContext.a().a().createEntityManager(), TopicInfoEntry.class, TopicInfoEntry.class.getSimpleName(), "topicId=?", new String[] { String.valueOf(paramLong) });
    if ((localList != null) && (localList.size() > 0)) {
      return ((TopicInfoEntry)localList.get(0)).topicPbData;
    }
    return null;
  }
  
  public List b()
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = StoryManager.a((EntityManager)localObject, SquareBannerEntry.class, SquareBannerEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new SquareBannerItem((SquareBannerEntry)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void b() {}
  
  public void b(List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    if (paramBoolean) {}
    try
    {
      localEntityManager.a(SquareBannerEntry.class);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localEntityManager.b(((SquareBannerItem)paramList.next()).a());
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DiscoverManager
 * JD-Core Version:    0.7.0.1
 */