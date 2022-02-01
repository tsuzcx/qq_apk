package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.mobileqq.utils.FileUtils;
import uzf;

public class WeiShiCacheManager$5
  implements Runnable
{
  public WeiShiCacheManager$5(uzf paramuzf) {}
  
  public void run()
  {
    FileUtils.delete(uzf.b(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5
 * JD-Core Version:    0.7.0.1
 */