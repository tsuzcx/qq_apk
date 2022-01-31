package com.tencent.biz.pubaccount.readinjoy.struct;

import auko;

public class ArticleReadInfo
  extends auko
  implements Cloneable
{
  public static final String TABLE_NAME = ArticleReadInfo.class.getSimpleName();
  public long mArticleID = -1L;
  public boolean mIsRead;
  public long mLastReadTime;
  
  public ArticleReadInfo clone()
  {
    try
    {
      ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)super.clone();
      return localArticleReadInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo
 * JD-Core Version:    0.7.0.1
 */