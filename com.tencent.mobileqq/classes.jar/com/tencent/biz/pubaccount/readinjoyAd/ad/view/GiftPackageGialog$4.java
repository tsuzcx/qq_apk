package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import ttp;
import txz;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(txz paramtxz) {}
  
  public void run()
  {
    if ((txz.a(this.this$0) != null) && (txz.b(this.this$0) != null) && (txz.c(this.this$0) != null))
    {
      Pair localPair = ttp.a(txz.a(this.this$0), txz.a(this.this$0).v, txz.b(this.this$0).v, txz.c(this.this$0).ck, txz.b(this.this$0), txz.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!txz.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    ttp.a(10, txz.a(this.this$0), txz.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */