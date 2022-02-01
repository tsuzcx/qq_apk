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
  public List<FeedIdListSeqInfo> a;
  public boolean a;
  private int b = 0;
  
  public FeedListPageLoaderBase$FeedIdListCache()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
  }
  
  public FeedListPageLoaderBase$FeedIdListCache(FeedIdListCache paramFeedIdListCache)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
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
    try
    {
      localGetFeedIdListResult = new FeedListPageLoaderBase.GetFeedIdListResult();
      if (paramInt1 != 0) {
        break label339;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        FeedListPageLoaderBase.GetFeedIdListResult localGetFeedIdListResult;
        int i;
        ArrayList localArrayList;
        FeedIdListSeqInfo localFeedIdListSeqInfo1;
        Iterator localIterator;
        for (;;)
        {
          throw localObject;
        }
        label339:
        boolean bool = false;
      }
    }
    localGetFeedIdListResult.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_JavaUtilList.size() > paramInt1)
    {
      i = paramInt2;
      if (paramInt1 + paramInt2 > this.jdField_a_of_type_JavaUtilList.size()) {
        i = this.jdField_a_of_type_JavaUtilList.size() - paramInt1;
      }
      paramInt2 = i + paramInt1;
      if ((paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()) && (a())) {
        localGetFeedIdListResult.b = true;
      }
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      localGetFeedIdListResult.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt2);
      if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        localFeedIdListSeqInfo1 = (FeedIdListSeqInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
        localIterator = localGetFeedIdListResult.jdField_a_of_type_JavaUtilList.iterator();
        if (localFeedIdListSeqInfo1.b)
        {
          while (localIterator.hasNext())
          {
            FeedIdListSeqInfo localFeedIdListSeqInfo2 = (FeedIdListSeqInfo)localIterator.next();
            if ((localFeedIdListSeqInfo2.b) && (localFeedIdListSeqInfo2.c.equals(localFeedIdListSeqInfo1.c)))
            {
              localIterator.remove();
              SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localFeedIdListSeqInfo2 });
            }
          }
          if (localGetFeedIdListResult.jdField_a_of_type_JavaUtilList.isEmpty())
          {
            localGetFeedIdListResult.jdField_a_of_type_JavaUtilList = localArrayList.subList(paramInt1, paramInt2);
            SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localGetFeedIdListResult.jdField_a_of_type_JavaUtilList });
          }
        }
      }
    }
    else
    {
      localGetFeedIdListResult.b = a();
    }
    this.b = (paramInt1 + localGetFeedIdListResult.jdField_a_of_type_JavaUtilList.size());
    return localGetFeedIdListResult;
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
  
  public void a(List<FeedIdListSeqInfo> paramList, String paramString, boolean paramBoolean)
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FeedIdListCache{mFeedIdListCache=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList);
      ((StringBuilder)localObject1).append(", mFeedIdNextCookie='");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append(", mIsEnd=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(", mCurFeedIdPosition=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(", mTempFeedIdPosition=");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append('}');
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache
 * JD-Core Version:    0.7.0.1
 */