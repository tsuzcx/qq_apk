package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeedListPageLoaderBase$FeedIdListCache
{
  private static FeedIdListSeqInfo.HomeComp d = new FeedIdListSeqInfo.HomeComp();
  public List<FeedIdListSeqInfo> a = new ArrayList();
  public boolean b;
  public int c = 0;
  private String e = "";
  private int f = 0;
  
  public FeedListPageLoaderBase$FeedIdListCache() {}
  
  public FeedListPageLoaderBase$FeedIdListCache(FeedIdListCache paramFeedIdListCache)
  {
    this.a.addAll(paramFeedIdListCache.a);
    this.e = paramFeedIdListCache.e;
    this.b = paramFeedIdListCache.b;
    this.c = paramFeedIdListCache.c;
    this.f = paramFeedIdListCache.f;
  }
  
  private boolean e()
  {
    return this.b;
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
    localGetFeedIdListResult.b = bool;
    if (this.a.size() > paramInt1)
    {
      i = paramInt2;
      if (paramInt1 + paramInt2 > this.a.size()) {
        i = this.a.size() - paramInt1;
      }
      paramInt2 = i + paramInt1;
      if ((paramInt2 >= this.a.size()) && (e())) {
        localGetFeedIdListResult.c = true;
      }
      localArrayList = new ArrayList(this.a);
      localGetFeedIdListResult.a = localArrayList.subList(paramInt1, paramInt2);
      if (paramInt2 < this.a.size())
      {
        localFeedIdListSeqInfo1 = (FeedIdListSeqInfo)this.a.get(paramInt2);
        localIterator = localGetFeedIdListResult.a.iterator();
        if (localFeedIdListSeqInfo1.g)
        {
          while (localIterator.hasNext())
          {
            FeedIdListSeqInfo localFeedIdListSeqInfo2 = (FeedIdListSeqInfo)localIterator.next();
            if ((localFeedIdListSeqInfo2.g) && (localFeedIdListSeqInfo2.d.equals(localFeedIdListSeqInfo1.d)))
            {
              localIterator.remove();
              SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "remove one fail info:%s", new Object[] { localFeedIdListSeqInfo2 });
            }
          }
          if (localGetFeedIdListResult.a.isEmpty())
          {
            localGetFeedIdListResult.a = localArrayList.subList(paramInt1, paramInt2);
            SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "bad luck for you have too much fail %s", new Object[] { localGetFeedIdListResult.a });
          }
        }
      }
    }
    else
    {
      localGetFeedIdListResult.c = e();
    }
    this.f = (paramInt1 + localGetFeedIdListResult.a.size());
    return localGetFeedIdListResult;
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      this.e = "";
      this.b = false;
      this.c = 0;
      this.f = 0;
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
      this.a.addAll(paramList);
      this.e = paramString;
      this.b = paramBoolean;
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
      this.c = this.f;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void d()
  {
    try
    {
      if (SLog.a()) {
        SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "before sort curpos:%d -- %s", Integer.valueOf(this.c), this.a);
      }
      Collections.sort(this.a, d);
      if (SLog.a()) {
        SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "after* sort curpos:%d -- %s", Integer.valueOf(this.c), this.a);
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
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", mFeedIdNextCookie='");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append('\'');
      ((StringBuilder)localObject1).append(", mIsEnd=");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(", mCurFeedIdPosition=");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(", mTempFeedIdPosition=");
      ((StringBuilder)localObject1).append(this.f);
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