package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import pne;
import pnh;
import pnn;
import ppg;
import uhx;
import ukg;

public class RIJOnScrollListener$1
  implements Runnable
{
  public RIJOnScrollListener$1(ppg paramppg) {}
  
  public void run()
  {
    if ((((uhx)pnn.b().getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(this.this$0.a.a().a(), (Activity)this.this$0.a.a().a())) && (this.this$0.a.a().a() != null)) {
      this.this$0.a.a().a().a(this.this$0.a.a().a(), (Activity)this.this$0.a.a().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.1
 * JD-Core Version:    0.7.0.1
 */