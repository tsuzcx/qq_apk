package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Locale;

class ReadInJoyLogicEngine$5
  implements Runnable
{
  ReadInJoyLogicEngine$5(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public void run()
  {
    Pair localPair = ReadInJoyHelper.a(ReadInJoyLogicEngine.a(this.this$0));
    if (this.a == 40677) {
      localPair = ReadInJoyHelper.b(ReadInJoyLogicEngine.a(this.this$0));
    }
    for (;;)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L - ((Long)localPair.first).longValue();
      long l3 = ReadInJoyLogicEngine.a() / 1000L;
      Object localObject2 = (Long)ReadInJoyLogicEngine.b().get(Integer.valueOf(this.a));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      if (((BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity)) || ((ReadInJoyHelper.o()) && (RIJAppSetting.b())) || (l1 - ((Long)localObject1).longValue() < ((Long)localPair.first).longValue()) || (l1 - l3 < ReadInJoyPageItemCache.a / 1000) || (l1 - l3 < ((Long)localPair.first).longValue())) {
        return;
      }
      if (ReadInJoyLogicEngine.a(this.this$0) != null) {
        ReadInJoyLogicEngine.a(this.this$0).a().a(this.a, l2, ((Integer)localPair.second).intValue());
      }
      localObject1 = this.this$0.a().createEntityManager();
      localObject2 = String.format(Locale.CHINA, "delete from %s where mRecommendSeq not in ( select mRecommendSeq from %s where mChannelID = %d order by mRecommendSeq desc limit %d ) and mRecommendTime < %d  and mChannelID = %d ", new Object[] { ArticleInfo.TABLE_NAME, ArticleInfo.TABLE_NAME, Integer.valueOf(this.a), localPair.second, Long.valueOf(l2), Integer.valueOf(this.a) });
      if (!((EntityManager)localObject1).execSQL((String)localObject2)) {
        QLog.d("ArticleInfoModule", 2, "delete main outdated article fail !");
      }
      for (;;)
      {
        ReadInJoyLogicEngine.b().put(Integer.valueOf(this.a), Long.valueOf(l1));
        return;
        QLog.d("ArticleInfoModule", 2, "delete outdated article successful ! Sql is : " + (String)localObject2 + ", nowTime : " + l1 + ", interval : " + localPair.first + ", feedsCnt : " + localPair.second);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.5
 * JD-Core Version:    0.7.0.1
 */