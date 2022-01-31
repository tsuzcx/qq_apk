package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import tcq;
import tlv;

public class WeiShiCacheManager$6
  implements Runnable
{
  public WeiShiCacheManager$6(tcq paramtcq, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= tcq.b(this.this$0))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > tcq.b(this.this$0)) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        int j = i - tcq.b(this.this$0);
        while (j < i)
        {
          localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
          j += 1;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > 0) {
          i = tcq.b(this.this$0);
        }
      }
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (tcq.a(this.this$0, localstSimpleGetFeedListRsp, tcq.b(this.this$0), localArrayList.size())) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", tlv.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6
 * JD-Core Version:    0.7.0.1
 */