package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import tns;
import trg;
import tri;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(tri paramtri) {}
  
  public void run()
  {
    if ((trg.a(this.a.a) != null) && (trg.b(this.a.a) != null))
    {
      trg.b(this.a.a, tns.a(trg.a(this.a.a), trg.a(this.a.a).v, trg.b(this.a.a).v, trg.b(this.a.a).s));
      if ((trg.c(this.a.a) == null) || (trg.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */