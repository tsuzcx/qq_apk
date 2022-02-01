package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class GiftPackageDialog$2$1
  implements Runnable
{
  GiftPackageDialog$2$1(GiftPackageDialog.2 param2) {}
  
  public void run()
  {
    if ((GiftPackageDialog.a(this.a.a) != null) && (GiftPackageDialog.b(this.a.a) != null))
    {
      GiftPackageDialog.b(this.a.a, GiftPackageManager.a(GiftPackageDialog.a(this.a.a), GiftPackageDialog.a(this.a.a).v, GiftPackageDialog.b(this.a.a).v, GiftPackageDialog.b(this.a.a).s));
      if ((GiftPackageDialog.c(this.a.a) == null) || (GiftPackageDialog.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageDialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.2.1
 * JD-Core Version:    0.7.0.1
 */