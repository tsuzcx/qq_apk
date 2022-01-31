package com.tencent.mobileqq.activity.recent;

import agxq;
import agyx;
import atmp;
import atmq;
import awuf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import java.util.List;

public class BannerManager$37$1
  implements Runnable
{
  public BannerManager$37$1(agyx paramagyx, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    atmp localatmp = agxq.a(this.jdField_a_of_type_Agyx.a).app.getEntityManagerFactory().createEntityManager();
    Object localObject = localatmp.a(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
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
          localatmp.b((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (awuf)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((awuf)localObject).c != null)
        {
          l1 = l2;
          if (((awuf)localObject).c.contains("|")) {
            l1 = Long.parseLong(((awuf)localObject).c.substring(((awuf)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((awuf)localObject).a);
        localExpiredPushBanner.md5 = ((awuf)localObject).m;
        localExpiredPushBanner.endtime = l1;
        localatmp.a(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.37.1
 * JD-Core Version:    0.7.0.1
 */