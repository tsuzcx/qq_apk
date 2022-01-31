package com.tencent.biz.pubaccount.readinjoy.engine;

import awgf;
import awgg;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Locale;
import ore;
import owy;
import phk;

public class ReadInJoyLogicEngine$6
  implements Runnable
{
  public ReadInJoyLogicEngine$6(owy paramowy, int paramInt) {}
  
  public void run()
  {
    Pair localPair = bkbq.a();
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L - ((Long)localPair.first).longValue();
    long l3 = owy.a() / 1000L;
    Object localObject2 = (Long)owy.b().get(Integer.valueOf(this.a));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    if ((l1 - ((Long)localObject1).longValue() < ((Long)localPair.first).longValue()) || (l1 - l3 < ore.a / 1000) || (l1 - l3 < ((Long)localPair.first).longValue())) {
      return;
    }
    if (owy.a(this.this$0) != null) {
      owy.a(this.this$0).a(this.a, l2, ((Integer)localPair.second).intValue());
    }
    localObject1 = this.this$0.a().createEntityManager();
    localObject2 = String.format(Locale.CHINA, "delete from %s where recommendSeq not in ( select recommendSeq from %s where channelID = %d order by recommendSeq desc limit %d ) and recommendTime < %d  and channelID = %d ", new Object[] { WeiShiVideoArticleInfo.TABLE_NAME, WeiShiVideoArticleInfo.TABLE_NAME, Integer.valueOf(this.a), localPair.second, Long.valueOf(l2), Integer.valueOf(this.a) });
    if (!((awgf)localObject1).b((String)localObject2)) {
      QLog.d("VideoArticleInfo", 2, "delete main outdated article fail !");
    }
    for (;;)
    {
      owy.b().put(Integer.valueOf(this.a), Long.valueOf(l1));
      return;
      QLog.d("VideoArticleInfo", 2, "delete outdated article successful ! Sql is : " + (String)localObject2 + ", nowTime : " + l1 + ", interval : " + localPair.first + ", feedsCnt : " + localPair.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.6
 * JD-Core Version:    0.7.0.1
 */