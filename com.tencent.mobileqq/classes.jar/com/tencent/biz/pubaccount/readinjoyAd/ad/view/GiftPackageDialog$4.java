package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import uhw;
import ulx;

public class GiftPackageDialog$4
  implements Runnable
{
  public GiftPackageDialog$4(ulx paramulx) {}
  
  public void run()
  {
    if ((ulx.a(this.this$0) != null) && (ulx.b(this.this$0) != null) && (ulx.c(this.this$0) != null))
    {
      Pair localPair = uhw.a(ulx.a(this.this$0), ulx.a(this.this$0).v, ulx.b(this.this$0).v, ulx.c(this.this$0).ck, ulx.b(this.this$0), ulx.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageDialog.4.1(this, localPair));
      if (!ulx.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    uhw.a(10, ulx.a(this.this$0), ulx.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.4
 * JD-Core Version:    0.7.0.1
 */