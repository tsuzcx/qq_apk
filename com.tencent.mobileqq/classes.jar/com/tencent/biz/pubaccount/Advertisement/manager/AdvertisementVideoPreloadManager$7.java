package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import nji;
import nsb;

public class AdvertisementVideoPreloadManager$7
  implements Runnable
{
  public AdvertisementVideoPreloadManager$7(nji paramnji, String paramString) {}
  
  public void run()
  {
    synchronized (nji.a(this.this$0))
    {
      nji.c("loadLocalConfigTask uin:" + this.a);
      Object localObject2 = nji.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((nsb)localObject2).a(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.a }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          nji.a(this.this$0).clear();
          nji.a(this.this$0).addAll((Collection)localObject2);
          nji.c("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.7.1(this));
        }
      }
      else
      {
        return;
      }
      nji.c("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.7
 * JD-Core Version:    0.7.0.1
 */