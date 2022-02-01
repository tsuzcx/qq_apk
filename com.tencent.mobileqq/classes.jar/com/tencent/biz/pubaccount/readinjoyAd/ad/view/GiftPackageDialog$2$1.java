package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import uhw;
import ulx;
import ulz;

public class GiftPackageDialog$2$1
  implements Runnable
{
  public GiftPackageDialog$2$1(ulz paramulz) {}
  
  public void run()
  {
    if ((ulx.a(this.a.a) != null) && (ulx.b(this.a.a) != null))
    {
      ulx.b(this.a.a, uhw.a(ulx.a(this.a.a), ulx.a(this.a.a).v, ulx.b(this.a.a).v, ulx.b(this.a.a).s));
      if ((ulx.c(this.a.a) == null) || (ulx.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageDialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.2.1
 * JD-Core Version:    0.7.0.1
 */