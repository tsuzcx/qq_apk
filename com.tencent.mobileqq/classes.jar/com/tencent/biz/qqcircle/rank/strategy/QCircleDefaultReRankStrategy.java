package com.tencent.biz.qqcircle.rank.strategy;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedItem;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedSortParams;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleDefaultReRankStrategy
  implements QCircleReRankStrategy
{
  public BigDecimal calculateScore(double paramDouble1, double paramDouble2, double paramDouble3, Long paramLong, BigDecimal paramBigDecimal)
  {
    paramDouble2 = paramDouble1 / 1000.0D + paramDouble2 + paramDouble3;
    paramDouble1 = paramDouble2;
    if (paramDouble2 - 0.0D < 1.E-005D) {
      paramDouble1 = 1.0D;
    }
    return BigDecimal.valueOf((2.0D / (Math.exp(-1.0D * paramDouble1) + 1.0D) - 1.0D) * (paramDouble1 / (Math.pow(2.0D, paramLong.longValue()) + paramDouble1 - 1.0D)) * paramBigDecimal.doubleValue());
  }
  
  public List<QCircleRawFeedItem> reRank(QCircleRawFeedSortParams paramQCircleRawFeedSortParams, String paramString)
  {
    paramString = paramQCircleRawFeedSortParams.getSortList();
    ConcurrentHashMap localConcurrentHashMap1 = paramQCircleRawFeedSortParams.getExpTime();
    ConcurrentHashMap localConcurrentHashMap2 = paramQCircleRawFeedSortParams.getOneActionCounts();
    ConcurrentHashMap localConcurrentHashMap3 = paramQCircleRawFeedSortParams.getMultiActionCounts();
    paramQCircleRawFeedSortParams = paramQCircleRawFeedSortParams.getBadSampleCounts();
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      QCircleRawFeedItem localQCircleRawFeedItem = (QCircleRawFeedItem)localIterator.next();
      Object localObject = localQCircleRawFeedItem.getCateId();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Long localLong = (Long)localConcurrentHashMap1.get(localObject);
        double d3 = 0.0D;
        double d1;
        if (localLong != null)
        {
          d1 = localLong.longValue();
          Double.isNaN(d1);
          d1 = d1 * 1.0D / 1000.0D;
        }
        else
        {
          d1 = 0.0D;
        }
        localLong = (Long)localConcurrentHashMap2.get(localObject);
        double d2;
        if (localLong != null)
        {
          d2 = localLong.longValue();
          Double.isNaN(d2);
          d2 *= 1.0D;
        }
        else
        {
          d2 = 0.0D;
        }
        localLong = (Long)localConcurrentHashMap3.get(localObject);
        if (localLong != null)
        {
          d3 = localLong.longValue();
          Double.isNaN(d3);
          d3 *= 2.0D;
        }
        localObject = (Long)paramQCircleRawFeedSortParams.get(localObject);
        long l;
        if (localObject != null) {
          l = ((Long)localObject).longValue();
        } else {
          l = 0L;
        }
        localQCircleRawFeedItem.setReRankScore(calculateScore(d1, d2, d3, Long.valueOf(l), localQCircleRawFeedItem.getPreRecommendScore()));
      }
      else
      {
        localQCircleRawFeedItem.setReRankScore(localQCircleRawFeedItem.getPreRecommendScore());
      }
    }
    Collections.sort(paramString, new QCircleDefaultReRankStrategy.1(this));
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.strategy.QCircleDefaultReRankStrategy
 * JD-Core Version:    0.7.0.1
 */