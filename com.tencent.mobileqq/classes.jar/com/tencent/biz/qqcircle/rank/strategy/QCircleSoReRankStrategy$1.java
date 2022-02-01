package com.tencent.biz.qqcircle.rank.strategy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedSortParams;
import com.tencent.qcircle.rerank.NativeReRank;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class QCircleSoReRankStrategy$1
  implements Runnable
{
  QCircleSoReRankStrategy$1(QCircleSoReRankStrategy paramQCircleSoReRankStrategy, QCircleRawFeedSortParams paramQCircleRawFeedSortParams, String paramString, List[] paramArrayOfList, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new GsonBuilder();
      ((GsonBuilder)localObject1).setPrettyPrinting();
      localObject1 = ((GsonBuilder)localObject1).create().toJson(this.val$params);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("so reRank input jsonString:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n extraParams = ");
      ((StringBuilder)localObject2).append(this.val$extraParams);
      QLog.d("QCircleSoReRankStrategy", 1, ((StringBuilder)localObject2).toString());
      localObject1 = NativeReRank.doReRank((String)localObject1, this.val$extraParams);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("so reRank output jsonString:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QCircleSoReRankStrategy", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new Gson();
      this.val$rawFeedItems[0] = ((List)((Gson)localObject2).fromJson((String)localObject1, new QCircleSoReRankStrategy.1.1(this).getType()));
      this.val$mDownLatch.countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleSoReRankStrategy", 1, localThrowable, new Object[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.strategy.QCircleSoReRankStrategy.1
 * JD-Core Version:    0.7.0.1
 */