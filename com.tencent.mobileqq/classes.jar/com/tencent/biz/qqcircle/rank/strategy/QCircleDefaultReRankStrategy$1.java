package com.tencent.biz.qqcircle.rank.strategy;

import com.tencent.biz.qqcircle.rank.QCircleRawFeedItem;
import java.math.BigDecimal;
import java.util.Comparator;

class QCircleDefaultReRankStrategy$1
  implements Comparator<QCircleRawFeedItem>
{
  QCircleDefaultReRankStrategy$1(QCircleDefaultReRankStrategy paramQCircleDefaultReRankStrategy) {}
  
  public int compare(QCircleRawFeedItem paramQCircleRawFeedItem1, QCircleRawFeedItem paramQCircleRawFeedItem2)
  {
    return paramQCircleRawFeedItem2.getReRankScore().compareTo(paramQCircleRawFeedItem1.getReRankScore());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.strategy.QCircleDefaultReRankStrategy.1
 * JD-Core Version:    0.7.0.1
 */