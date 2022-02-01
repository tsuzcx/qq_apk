package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class RIJTabFrameDeliverPopupUtil$1$1
  implements Runnable
{
  RIJTabFrameDeliverPopupUtil$1$1(RIJTabFrameDeliverPopupUtil.1 param1) {}
  
  public void run()
  {
    if (RIJUGCDianDian.a() >= 2)
    {
      QQToast.a(this.this$0.a.a(), 0, this.this$0.a.a().getString(2131718219), 0).b(this.this$0.a.a().getResources().getDimensionPixelSize(2131299166));
      return;
    }
    RIJTabFrameDeliverPopupUtil.a(this.this$0.a.a());
    RIJUGCDianDian.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJTabFrameDeliverPopupUtil.1.1
 * JD-Core Version:    0.7.0.1
 */