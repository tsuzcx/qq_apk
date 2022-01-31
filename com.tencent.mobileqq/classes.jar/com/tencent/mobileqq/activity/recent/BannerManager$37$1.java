package com.tencent.mobileqq.activity.recent;

import ahkf;
import ahlm;
import aukn;
import auko;
import axuh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import java.util.List;

public class BannerManager$37$1
  implements Runnable
{
  public BannerManager$37$1(ahlm paramahlm, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    aukn localaukn = ahkf.a(this.jdField_a_of_type_Ahlm.a).app.getEntityManagerFactory().createEntityManager();
    Object localObject = localaukn.a(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
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
          localaukn.b((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (axuh)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((axuh)localObject).c != null)
        {
          l1 = l2;
          if (((axuh)localObject).c.contains("|")) {
            l1 = Long.parseLong(((axuh)localObject).c.substring(((axuh)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((axuh)localObject).a);
        localExpiredPushBanner.md5 = ((axuh)localObject).m;
        localExpiredPushBanner.endtime = l1;
        localaukn.a(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.37.1
 * JD-Core Version:    0.7.0.1
 */