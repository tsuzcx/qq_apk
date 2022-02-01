package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

class GiftPackageDialog$4
  implements Runnable
{
  GiftPackageDialog$4(GiftPackageDialog paramGiftPackageDialog) {}
  
  public void run()
  {
    if ((GiftPackageDialog.i(this.this$0) != null) && (GiftPackageDialog.j(this.this$0) != null) && (GiftPackageDialog.l(this.this$0) != null))
    {
      Pair localPair = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).sendGiftPackage(GiftPackageDialog.k(this.this$0), GiftPackageDialog.i(this.this$0).v, GiftPackageDialog.j(this.this$0).v, GiftPackageDialog.l(this.this$0).ck, GiftPackageDialog.m(this.this$0), GiftPackageDialog.j(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageDialog.4.1(this, localPair));
      if (GiftPackageDialog.p(this.this$0)) {
        return;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGetPackage(10, GiftPackageDialog.k(this.this$0), GiftPackageDialog.q(this.this$0), 30103, 3010305, 301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4
 * JD-Core Version:    0.7.0.1
 */