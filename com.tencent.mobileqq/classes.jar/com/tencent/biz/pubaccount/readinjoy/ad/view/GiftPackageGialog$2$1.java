package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import nnx;
import npv;
import npx;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(npx paramnpx) {}
  
  public void run()
  {
    if ((npv.a(this.a.a) != null) && (npv.b(this.a.a) != null))
    {
      npv.b(this.a.a, nnx.a(npv.a(this.a.a), npv.a(this.a.a).v, npv.b(this.a.a).v, npv.b(this.a.a).s));
      if ((npv.c(this.a.a) == null) || (npv.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */