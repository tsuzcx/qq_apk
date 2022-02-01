package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WSExposeDataManager
{
  private final CopyOnWriteArrayList<stExposureFeedInfo> a = new CopyOnWriteArrayList();
  private final HashSet<String> b = new HashSet();
  
  public static WSExposeDataManager a()
  {
    return WSExposeDataManager.SingleHolder.a;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;
    if (this.b.contains(paramstSimpleMetaFeed)) {
      return;
    }
    this.b.add(paramstSimpleMetaFeed);
    stExposureFeedInfo localstExposureFeedInfo = new stExposureFeedInfo();
    localstExposureFeedInfo.id = paramstSimpleMetaFeed;
    this.a.add(localstExposureFeedInfo);
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((stSimpleMetaFeed)paramList.next());
      }
    }
  }
  
  public ArrayList<stExposureFeedInfo> b()
  {
    ArrayList localArrayList = new ArrayList(this.a);
    this.a.clear();
    return localArrayList;
  }
  
  public void c()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager
 * JD-Core Version:    0.7.0.1
 */