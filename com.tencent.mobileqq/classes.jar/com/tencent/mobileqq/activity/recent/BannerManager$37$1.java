package com.tencent.mobileqq.activity.recent;

import ajgb;
import ajhi;
import awgf;
import awgg;
import azum;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import java.util.List;

public class BannerManager$37$1
  implements Runnable
{
  public BannerManager$37$1(ajhi paramajhi, int paramInt, List paramList) {}
  
  public void run()
  {
    int k = 0;
    awgf localawgf = ajgb.a(this.jdField_a_of_type_Ajhi.a).app.getEntityManagerFactory().createEntityManager();
    Object localObject = localawgf.a(ExpiredPushBanner.class, false, null, null, null, null, "endtime", null);
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
          localawgf.b((ExpiredPushBanner)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (azum)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localObject != null)
      {
        long l2 = 0L;
        long l1 = l2;
        if (((azum)localObject).c != null)
        {
          l1 = l2;
          if (((azum)localObject).c.contains("|")) {
            l1 = Long.parseLong(((azum)localObject).c.substring(((azum)localObject).c.indexOf("|") + 1));
          }
        }
        ExpiredPushBanner localExpiredPushBanner = new ExpiredPushBanner();
        localExpiredPushBanner.cid = Long.parseLong(((azum)localObject).a);
        localExpiredPushBanner.md5 = ((azum)localObject).m;
        localExpiredPushBanner.endtime = l1;
        localawgf.a(localExpiredPushBanner);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager.37.1
 * JD-Core Version:    0.7.0.1
 */