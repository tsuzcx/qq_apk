package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import tns;
import trg;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(trg paramtrg) {}
  
  public void run()
  {
    if ((trg.a(this.this$0) != null) && (trg.b(this.this$0) != null) && (trg.c(this.this$0) != null))
    {
      Pair localPair = tns.a(trg.a(this.this$0), trg.a(this.this$0).v, trg.b(this.this$0).v, trg.c(this.this$0).ck, trg.b(this.this$0), trg.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!trg.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    tns.a(10, trg.a(this.this$0), trg.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */