package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;
import ooh;
import oro;

public class GiftPackageGialog$4
  implements Runnable
{
  public GiftPackageGialog$4(oro paramoro) {}
  
  public void run()
  {
    if ((oro.a(this.this$0) != null) && (oro.b(this.this$0) != null) && (oro.c(this.this$0) != null))
    {
      Pair localPair = ooh.a(oro.a(this.this$0), oro.a(this.this$0).v, oro.b(this.this$0).v, oro.c(this.this$0).ck, oro.b(this.this$0), oro.b(this.this$0).s);
      ThreadManager.getUIHandler().post(new GiftPackageGialog.4.1(this, localPair));
      if (!oro.b(this.this$0)) {}
    }
    else
    {
      return;
    }
    ooh.a(10, oro.a(this.this$0), oro.c(this.this$0), 30103, 3010305, 301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4
 * JD-Core Version:    0.7.0.1
 */