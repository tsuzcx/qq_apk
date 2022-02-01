package com.tencent.biz.qqcircle.rank.strategy;

import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedItem;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedSortParams;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class QCircleSoReRankStrategy
  implements QCircleReRankStrategy
{
  private static final int RERANK_TIMEOUT_NUM = 200;
  private static final String TAG = "QCircleSoReRankStrategy";
  
  private List<QCircleRawFeedItem> doRerank(QCircleRawFeedSortParams paramQCircleRawFeedSortParams, String paramString)
  {
    try
    {
      ArrayList[] arrayOfArrayList = new ArrayList[1];
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      RFThreadManager.execute(new QCircleSoReRankStrategy.1(this, paramQCircleRawFeedSortParams, paramString, arrayOfArrayList, localCountDownLatch), RFThreadManager.Normal);
      localCountDownLatch.await(200L, TimeUnit.MILLISECONDS);
      paramQCircleRawFeedSortParams = arrayOfArrayList[0];
      return paramQCircleRawFeedSortParams;
    }
    finally
    {
      paramQCircleRawFeedSortParams = finally;
      throw paramQCircleRawFeedSortParams;
    }
  }
  
  public List<QCircleRawFeedItem> reRank(QCircleRawFeedSortParams paramQCircleRawFeedSortParams, String paramString)
  {
    if (!QCirclePluginInitHelper.getInstance().isRankSoLoaded())
    {
      QLog.e("QCircleSoReRankStrategy", 1, "reRank so not loaded return");
      return null;
    }
    QLog.d("QCircleSoReRankStrategy", 1, "reRank so loaded");
    try
    {
      paramQCircleRawFeedSortParams = doRerank(paramQCircleRawFeedSortParams, paramString);
      return paramQCircleRawFeedSortParams;
    }
    catch (Exception paramQCircleRawFeedSortParams)
    {
      paramString = new StringBuilder();
      paramString.append("native rerank error = ");
      paramString.append(paramQCircleRawFeedSortParams.getMessage());
      QLog.e("QCircleSoReRankStrategy", 1, paramString.toString());
      return null;
    }
    catch (InterruptedException paramQCircleRawFeedSortParams)
    {
      paramString = new StringBuilder();
      paramString.append("native interrupted exception = ");
      paramString.append(paramQCircleRawFeedSortParams.getMessage());
      QLog.e("QCircleSoReRankStrategy", 1, paramString.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.strategy.QCircleSoReRankStrategy
 * JD-Core Version:    0.7.0.1
 */