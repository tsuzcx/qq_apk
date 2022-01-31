package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import nmb;
import nvl;

public class AdvertisementVideoPreloadManager$7
  implements Runnable
{
  public AdvertisementVideoPreloadManager$7(nmb paramnmb, String paramString) {}
  
  public void run()
  {
    synchronized (nmb.a(this.this$0))
    {
      nmb.c("loadLocalConfigTask uin:" + this.a);
      Object localObject2 = nmb.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((nvl)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.a }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          nmb.a(this.this$0).clear();
          nmb.a(this.this$0).addAll((Collection)localObject2);
          nmb.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7.1(this));
        }
      }
      else
      {
        return;
      }
      nmb.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7
 * JD-Core Version:    0.7.0.1
 */