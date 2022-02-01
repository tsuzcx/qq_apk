package com.tencent.biz.pubaccount.readinjoy.common;

import java.util.Comparator;

public class ArticleInfoHelper$RecommendSeqComparator
  implements Comparator<Long>
{
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.longValue() > paramLong2.longValue()) {
      return -1;
    }
    if (paramLong1.longValue() < paramLong2.longValue()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper.RecommendSeqComparator
 * JD-Core Version:    0.7.0.1
 */