package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import ooh;
import oro;
import orq;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(orq paramorq) {}
  
  public void run()
  {
    if ((oro.a(this.a.a) != null) && (oro.b(this.a.a) != null))
    {
      oro.b(this.a.a, ooh.a(oro.a(this.a.a), oro.a(this.a.a).v, oro.b(this.a.a).v, oro.b(this.a.a).s));
      if ((oro.c(this.a.a) == null) || (oro.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */