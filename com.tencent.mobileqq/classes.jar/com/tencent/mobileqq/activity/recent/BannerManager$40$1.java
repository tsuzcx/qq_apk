package com.tencent.mobileqq.activity.recent;

import akyh;
import akzs;
import bcvm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class BannerManager$40$1
  implements Runnable
{
  public BannerManager$40$1(akzs paramakzs, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    EntityManager localEntityManager = akyh.a(this.jdField_a_of_type_Akzs.a).app.a().createEntityManager();
    Object localObject = localEntityManager.query(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
    int j = k;
    if (localObject != null)
    {
      int m = ((List)localObject).size() + this.jdField_a_of_type_Int - 10;
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
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (bcvm)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((bcvm)localObject).c != null)
        {
          l1 = l2;
          if (((bcvm)localObject).c.contains("|")) {
            l1 = Long.parseLong(((bcvm)localObject).c.substring(((bcvm)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((bcvm)localObject).a);
        localExpiredPushBanner.md5 = ((bcvm)localObject).m;
        localExpiredPushBanner.endtime = l1;
        localEntityManager.persist(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.40.1
 * JD-Core Version:    0.7.0.1
 */