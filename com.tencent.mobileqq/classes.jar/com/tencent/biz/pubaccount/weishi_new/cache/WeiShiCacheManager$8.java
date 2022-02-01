package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

class WeiShiCacheManager$8
  implements Runnable
{
  WeiShiCacheManager$8(WeiShiCacheManager paramWeiShiCacheManager, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= WeiShiCacheManager.b(this.this$0))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > WeiShiCacheManager.b(this.this$0)) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int;
      } else if (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int > 0) {
        i = WeiShiCacheManager.b(this.this$0);
      }
      int j = i - WeiShiCacheManager.b(this.this$0);
      while (j < i)
      {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
        j += 1;
      }
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    WeiShiCacheManager localWeiShiCacheManager = this.this$0;
    if (WeiShiCacheManager.a(localWeiShiCacheManager, localstSimpleGetFeedListRsp, WeiShiCacheManager.b(localWeiShiCacheManager), localArrayList.size())) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */