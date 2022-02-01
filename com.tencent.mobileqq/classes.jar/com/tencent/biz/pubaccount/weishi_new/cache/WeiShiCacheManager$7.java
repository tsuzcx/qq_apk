package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.mobileqq.utils.FileUtils;

class WeiShiCacheManager$7
  implements Runnable
{
  WeiShiCacheManager$7(WeiShiCacheManager paramWeiShiCacheManager) {}
  
  public void run()
  {
    FileUtils.delete(WeiShiCacheManager.b(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.7
 * JD-Core Version:    0.7.0.1
 */