package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import ocp;
import oev;
import oex;

public class GiftPackageGialog$2$1
  implements Runnable
{
  public GiftPackageGialog$2$1(oex paramoex) {}
  
  public void run()
  {
    if ((oev.a(this.a.a) != null) && (oev.b(this.a.a) != null))
    {
      oev.b(this.a.a, ocp.a(oev.a(this.a.a), oev.a(this.a.a).v, oev.b(this.a.a).v, oev.b(this.a.a).s));
      if ((oev.c(this.a.a) == null) || (oev.c(this.a.a).size() <= 0)) {
        ThreadManager.getUIHandler().post(new GiftPackageGialog.2.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.2.1
 * JD-Core Version:    0.7.0.1
 */