package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import njf;
import nry;

public class AdvertisementVideoPreloadManager$7
  implements Runnable
{
  public AdvertisementVideoPreloadManager$7(njf paramnjf, String paramString) {}
  
  public void run()
  {
    synchronized (njf.a(this.this$0))
    {
      njf.c("loadLocalConfigTask uin:" + this.a);
      Object localObject2 = njf.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((nry)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.a }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          njf.a(this.this$0).clear();
          njf.a(this.this$0).addAll((Collection)localObject2);
          njf.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7.1(this));
        }
      }
      else
      {
        return;
      }
      njf.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7
 * JD-Core Version:    0.7.0.1
 */