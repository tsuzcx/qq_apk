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
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final CopyOnWriteArrayList<stExposureFeedInfo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public static WSExposeDataManager a()
  {
    return WSExposeDataManager.SingleHolder.a;
  }
  
  public ArrayList<stExposureFeedInfo> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramstSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(paramstSimpleMetaFeed);
    stExposureFeedInfo localstExposureFeedInfo = new stExposureFeedInfo();
    localstExposureFeedInfo.id = paramstSimpleMetaFeed;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localstExposureFeedInfo);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager
 * JD-Core Version:    0.7.0.1
 */