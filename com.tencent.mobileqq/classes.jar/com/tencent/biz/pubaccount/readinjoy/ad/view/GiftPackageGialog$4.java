package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import nzf;
import obd;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(obd paramobd) {}
  
  public void run()
  {
    if ((obd.a(this.this$0) != null) && (obd.b(this.this$0) != null) && (obd.c(this.this$0) != null))
    {
      Pair localPair = nzf.a(obd.a(this.this$0), obd.a(this.this$0).v, obd.b(this.this$0).v, obd.c(this.this$0).ck, obd.b(this.this$0), obd.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!obd.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    nzf.a(10, obd.a(this.this$0), obd.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */