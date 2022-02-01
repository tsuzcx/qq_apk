package com.tencent.biz.qqcircle.rank.strategy;

import com.tencent.biz.qqcircle.rank.QCircleRawFeedItem;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedSortParams;
import java.util.List;

public abstract interface QCircleReRankStrategy
{
  public abstract List<QCircleRawFeedItem> reRank(QCircleRawFeedSortParams paramQCircleRawFeedSortParams, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.strategy.QCircleReRankStrategy
 * JD-Core Version:    0.7.0.1
 */