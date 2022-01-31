package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import nzi;
import obg;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(obg paramobg) {}
  
  public void run()
  {
    if ((obg.a(this.this$0) != null) && (obg.b(this.this$0) != null) && (obg.c(this.this$0) != null))
    {
      Pair localPair = nzi.a(obg.a(this.this$0), obg.a(this.this$0).v, obg.b(this.this$0).v, obg.c(this.this$0).ck, obg.b(this.this$0), obg.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!obg.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    nzi.a(10, obg.a(this.this$0), obg.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */