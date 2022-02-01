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
    if ((GiftPackageDialog.a(this.this$0) != null) && (GiftPackageDialog.b(this.this$0) != null) && (GiftPackageDialog.c(this.this$0) != null))
    {
      Pair localPair = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).sendGiftPackage(GiftPackageDialog.a(this.this$0), GiftPackageDialog.a(this.this$0).v, GiftPackageDialog.b(this.this$0).v, GiftPackageDialog.c(this.this$0).ck, GiftPackageDialog.b(this.this$0), GiftPackageDialog.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageDialog.4.1(this, localPair));
      if (GiftPackageDialog.b(this.this$0)) {
        return;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGetPackage(10, GiftPackageDialog.a(this.this$0), GiftPackageDialog.c(this.this$0), 30103, 3010305, 301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4
 * JD-Core Version:    0.7.0.1
 */