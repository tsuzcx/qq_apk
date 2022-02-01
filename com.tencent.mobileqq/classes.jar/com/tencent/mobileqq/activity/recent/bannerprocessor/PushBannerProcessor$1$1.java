package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.struct.PushBanner;
import java.util.List;
import mqq.app.AppRuntime;

class PushBannerProcessor$1$1
  implements Runnable
{
  PushBannerProcessor$1$1(PushBannerProcessor.1 param1, int paramInt, List paramList) {}
  
  public void run()
  {
    EntityManager localEntityManager = PushBannerProcessor.c(this.c.a).getAppRuntime().getEntityManagerFactory().createEntityManager();
    Object localObject = localEntityManager.query(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
    int k = 0;
    int j = k;
    if (localObject != null)
    {
      int m = ((List)localObject).size() + this.a - 10;
      j = k;
      if (m > 0)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localEntityManager.remove((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.b.size())
    {
      localObject = (PushBanner)this.b.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((PushBanner)localObject).c != null)
        {
          l1 = l2;
          if (((PushBanner)localObject).c.contains("|")) {
            l1 = Long.parseLong(((PushBanner)localObject).c.substring(((PushBanner)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((PushBanner)localObject).a);
        localExpiredPushBanner.md5 = ((PushBanner)localObject).o;
        localExpiredPushBanner.endtime = l1;
        localEntityManager.persist(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.1.1
 * JD-Core Version:    0.7.0.1
 */