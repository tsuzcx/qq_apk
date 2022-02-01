package com.tencent.biz.qqcircle.rank;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleRawFeedSortParams
{
  private ConcurrentHashMap<String, Long> mBadSampleCounts;
  private ConcurrentHashMap<String, Long> mCategoryItems;
  private ConcurrentHashMap<String, Long> mExpTime;
  private ConcurrentHashMap<String, Long> mMultiActionCounts;
  private ConcurrentHashMap<String, Long> mOneActionCounts;
  private List<QCircleRawFeedItem> mSortList;
  
  public ConcurrentHashMap<String, Long> getBadSampleCounts()
  {
    return this.mBadSampleCounts;
  }
  
  public ConcurrentHashMap<String, Long> getCategoryItems()
  {
    return this.mCategoryItems;
  }
  
  public ConcurrentHashMap<String, Long> getExpTime()
  {
    return this.mExpTime;
  }
  
  public ConcurrentHashMap<String, Long> getMultiActionCounts()
  {
    return this.mMultiActionCounts;
  }
  
  public ConcurrentHashMap<String, Long> getOneActionCounts()
  {
    return this.mOneActionCounts;
  }
  
  public List<QCircleRawFeedItem> getSortList()
  {
    return this.mSortList;
  }
  
  public void setBadSampleCounts(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    this.mBadSampleCounts = paramConcurrentHashMap;
  }
  
  public void setCategoryItems(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    this.mCategoryItems = paramConcurrentHashMap;
  }
  
  public void setExpTime(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    this.mExpTime = paramConcurrentHashMap;
  }
  
  public void setMultiActionCounts(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    this.mMultiActionCounts = paramConcurrentHashMap;
  }
  
  public void setOneActionCounts(ConcurrentHashMap<String, Long> paramConcurrentHashMap)
  {
    this.mOneActionCounts = paramConcurrentHashMap;
  }
  
  public void setSortList(List<QCircleRawFeedItem> paramList)
  {
    this.mSortList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.QCircleRawFeedSortParams
 * JD-Core Version:    0.7.0.1
 */