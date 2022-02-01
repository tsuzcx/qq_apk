package com.tencent.mobileqq.activity.recent;

import akho;
import akiz;
import bcgq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class BannerManager$40$1
  implements Runnable
{
  public BannerManager$40$1(akiz paramakiz, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    EntityManager localEntityManager = akho.a(this.jdField_a_of_type_Akiz.a).app.getEntityManagerFactory().createEntityManager();
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
      localObject = (bcgq)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((bcgq)localObject).c != null)
        {
          l1 = l2;
          if (((bcgq)localObject).c.contains("|")) {
            l1 = Long.parseLong(((bcgq)localObject).c.substring(((bcgq)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((bcgq)localObject).a);
        localExpiredPushBanner.md5 = ((bcgq)localObject).m;
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