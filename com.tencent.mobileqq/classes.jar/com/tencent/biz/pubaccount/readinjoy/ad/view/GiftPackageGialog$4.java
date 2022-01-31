package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import ocp;
import oev;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(oev paramoev) {}
  
  public void run()
  {
    if ((oev.a(this.this$0) != null) && (oev.b(this.this$0) != null) && (oev.c(this.this$0) != null))
    {
      Pair localPair = ocp.a(oev.a(this.this$0), oev.a(this.this$0).v, oev.b(this.this$0).v, oev.c(this.this$0).ck, oev.b(this.this$0), oev.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!oev.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    ocp.a(10, oev.a(this.this$0), oev.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */