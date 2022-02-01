package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import pqq;
import pqr;

public class RIJUGCDianDian$1$2
  implements Runnable
{
  public RIJUGCDianDian$1$2(pqr parampqr) {}
  
  public void run()
  {
    if (pqq.a() >= 2)
    {
      QQToast.a(this.this$0.a, 0, this.this$0.a.getString(2131717717), 0).b(this.this$0.a.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    pqq.a(this.this$0.a);
    pqq.a("3", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian.1.2
 * JD-Core Version:    0.7.0.1
 */