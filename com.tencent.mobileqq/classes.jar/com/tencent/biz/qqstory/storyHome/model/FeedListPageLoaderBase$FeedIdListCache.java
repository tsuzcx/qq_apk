package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeedListPageLoaderBase$FeedIdListCache
{
  private static FeedIdListSeqInfo.HomeComp jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedIdListSeqInfo$HomeComp = new FeedIdListSeqInfo.HomeComp();
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public FeedListPageLoaderBase$FeedIdListCache() {}
  
  public FeedListPageLoaderBase$FeedIdListCache(FeedIdListCache paramFeedIdListCache)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramFeedIdListCache.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = paramFeedIdListCache.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramFeedIdListCache.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramFeedIdListCache.jdField_a_of_type_Int;
    this.b = paramFeedIdListCache.b;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public FeedListPageLoaderBase.GetFeedIdListResult a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i;
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        FeedListPageLoaderBase.GetFeedIdListResult localGetFeedIdListResult1 = new FeedListPageLoaderBase.GetFeedIdListResult();
        if (paramInt1 == 0)
        {
          localGetFeedIdListResult1.jdField_a_of_type_Boolean = bool;
          if (this.jdField_a_of_type_JavaUtilList.size() <= paramInt1) {
            break label330;
          }
          i = paramInt2;
          if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
            i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
          }
          if ((paramInt1 + i >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
            localGetFeedIdListResult1.b = true;
          }
          localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          localGetFeedIdListResult1.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
          paramInt2 = paramInt1 + i;
          if (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label309;
          }
          FeedIdListSeqInfo localFeedIdListSeqInfo1 = (FeedIdListSeqInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          Iterator localIterator = localGetFeedIdListResult1.jdField_a_of_type_JavaUtilList.iterator();
          if (!localFeedIdListSeqInfo1.jdField_a_of_type_Boolean) {
            break label309;
          }
          if (!localIterator.hasNext()) {
            break;
          }
          FeedIdListSeqInfo localFeedIdListSeqInfo2 = (FeedIdListSeqInfo)localIterator.next();
          if ((!localFeedIdListSeqInfo2.jdField_a_of_type_Boolean) || (!localFeedIdListSeqInfo2.c.equals(localFeedIdListSeqInfo1.c))) {
            continue;
          }
          localIterator.remove();
          SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localFeedIdListSeqInfo2 });
          continue;
        }
        bool = false;
      }
      finally {}
    }
    if (localGetFeedIdListResult2.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localGetFeedIdListResult2.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt1 + i);
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localGetFeedIdListResult2.jdField_a_of_type_JavaUtilList });
    }
    for (;;)
    {
      label309:
      this.b = (localGetFeedIdListResult2.jdField_a_of_type_JavaUtilList.size() + paramInt1);
      return localGetFeedIdListResult2;
      label330:
      localGetFeedIdListResult2.b = a();
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List paramList, String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId list:set next cookie data count:%d, cookie:%s, isEnd:%b", new Object[] { Integer.valueOf(paramList.size()), paramString, Boolean.valueOf(paramBoolean) });
      SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "add feed list:%s", paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Int = this.b;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      if (SLog.a()) {
        SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedIdListSeqInfo$HomeComp);
      if (SLog.a()) {
        SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilList);
      }
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    try
    {
      String str = "FeedIdListCache{mFeedIdListSeqInfoList=" + this.jdField_a_of_type_JavaUtilList + ", mFeedIdNextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mIsEnd=" + this.jdField_a_of_type_Boolean + ", mCurFeedIdPosition=" + this.jdField_a_of_type_Int + ", mTempFeedIdPosition=" + this.b + '}';
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache
 * JD-Core Version:    0.7.0.1
 */