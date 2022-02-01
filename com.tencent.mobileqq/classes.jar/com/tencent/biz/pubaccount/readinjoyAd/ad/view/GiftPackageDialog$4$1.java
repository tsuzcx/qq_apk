package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;

class GiftPackageDialog$4$1
  implements Runnable
{
  GiftPackageDialog$4$1(GiftPackageDialog.4 param4, Pair paramPair) {}
  
  public void run()
  {
    String str = HardCodeUtil.a(2131903245);
    if (!TextUtils.isEmpty((CharSequence)this.a.second)) {
      str = (String)this.a.second;
    }
    boolean bool = ((Boolean)this.a.first).booleanValue();
    int j = 2;
    int i;
    if ((bool) && (TextUtils.isEmpty((CharSequence)this.a.second)))
    {
      str = HardCodeUtil.a(2131903246);
      i = 0;
    }
    else
    {
      i = 2;
    }
    if (!((Boolean)this.a.first).booleanValue()) {
      j = 1;
    }
    QQToast.makeText(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getApplication(), j, str, 0).show();
    if (this.b.this$0.isShowing()) {
      this.b.this$0.dismiss();
    }
    if (((Boolean)this.a.first).booleanValue())
    {
      str = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
      if (!TextUtils.isEmpty(str))
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGameGift(str, GiftPackageDialog.n(this.b.this$0));
        if (GiftPackageDialog.o(this.b.this$0) != null) {
          GiftPackageDialog.o(this.b.this$0).a(GiftPackageDialog.n(this.b.this$0));
        }
      }
      if (!GiftPackageDialog.p(this.b.this$0)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGetPackage(11, GiftPackageDialog.k(this.b.this$0), GiftPackageDialog.q(this.b.this$0), 30103, 3010305, 301);
      }
    }
    if ((GiftPackageDialog.p(this.b.this$0)) && (GiftPackageDialog.r(this.b.this$0) != null)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGameGiftClick(GiftPackageDialog.r(this.b.this$0), i, GiftPackageDialog.s(this.b.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4.1
 * JD-Core Version:    0.7.0.1
 */