package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ofd;
import opx;

public class AdvertisementVideoPreloadManager$7
  implements Runnable
{
  public AdvertisementVideoPreloadManager$7(ofd paramofd, String paramString) {}
  
  public void run()
  {
    synchronized (ofd.a(this.this$0))
    {
      ofd.c("loadLocalConfigTask uin:" + this.a);
      Object localObject2 = ofd.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((opx)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.a }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          ofd.a(this.this$0).clear();
          ofd.a(this.this$0).addAll((Collection)localObject2);
          ofd.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7.1(this));
        }
      }
      else
      {
        return;
      }
      ofd.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7
 * JD-Core Version:    0.7.0.1
 */