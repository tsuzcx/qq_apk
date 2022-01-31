package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import nnx;
import npv;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(npv paramnpv) {}
  
  public void run()
  {
    if ((npv.a(this.this$0) != null) && (npv.b(this.this$0) != null) && (npv.c(this.this$0) != null))
    {
      Pair localPair = nnx.a(npv.a(this.this$0), npv.a(this.this$0).v, npv.b(this.this$0).v, npv.c(this.this$0).ck, npv.b(this.this$0), npv.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!npv.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    nnx.a(10, npv.a(this.this$0), npv.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */