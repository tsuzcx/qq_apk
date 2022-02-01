package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class AdvertisementVideoPreloadManager$7
  implements Runnable
{
  AdvertisementVideoPreloadManager$7(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager, String paramString) {}
  
  public void run()
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.this$0))
    {
      AdvertisementVideoPreloadManager.c("loadLocalConfigTask uin:" + this.a);
      Object localObject2 = AdvertisementVideoPreloadManager.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((PublicAccountEntityHelper)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.a }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          AdvertisementVideoPreloadManager.a(this.this$0).clear();
          AdvertisementVideoPreloadManager.a(this.this$0).addAll((Collection)localObject2);
          AdvertisementVideoPreloadManager.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7.1(this));
        }
      }
      else
      {
        return;
      }
      AdvertisementVideoPreloadManager.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7
 * JD-Core Version:    0.7.0.1
 */