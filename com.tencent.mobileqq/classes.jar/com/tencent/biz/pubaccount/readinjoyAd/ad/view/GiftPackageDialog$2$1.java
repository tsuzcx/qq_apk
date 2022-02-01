package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import mqq.os.MqqHandler;

class GiftPackageDialog$2$1
  implements Runnable
{
  GiftPackageDialog$2$1(GiftPackageDialog.2 param2) {}
  
  public void run()
  {
    if ((GiftPackageDialog.i(this.a.a) != null) && (GiftPackageDialog.j(this.a.a) != null))
    {
      GiftPackageDialog.b(this.a.a, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).requestRole(GiftPackageDialog.k(this.a.a), GiftPackageDialog.i(this.a.a).v, GiftPackageDialog.j(this.a.a).v, GiftPackageDialog.j(this.a.a).s));
      if ((GiftPackageDialog.h(this.a.a) == null) || (GiftPackageDialog.h(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageDialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.2.1
 * JD-Core Version:    0.7.0.1
 */