package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import ttp;
import txz;
import tyb;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(tyb paramtyb) {}
  
  public void run()
  {
    if ((txz.a(this.a.a) != null) && (txz.b(this.a.a) != null))
    {
      txz.b(this.a.a, ttp.a(txz.a(this.a.a), txz.a(this.a.a).v, txz.b(this.a.a).v, txz.b(this.a.a).s));
      if ((txz.c(this.a.a) == null) || (txz.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */