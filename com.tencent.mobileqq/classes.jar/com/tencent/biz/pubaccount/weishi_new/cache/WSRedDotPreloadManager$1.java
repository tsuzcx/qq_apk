package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;

class WSRedDotPreloadManager$1
  implements Runnable
{
  WSRedDotPreloadManager$1(WSRedDotPreloadManager paramWSRedDotPreloadManager, WSPushVideoModel paramWSPushVideoModel) {}
  
  public void run()
  {
    WSPicLoader.a().a(this.a.b, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */