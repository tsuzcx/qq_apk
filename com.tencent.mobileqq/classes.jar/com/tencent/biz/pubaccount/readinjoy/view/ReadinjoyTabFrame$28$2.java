package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import pay;
import spw;

public class ReadinjoyTabFrame$28$2
  implements Runnable
{
  public ReadinjoyTabFrame$28$2(spw paramspw) {}
  
  public void run()
  {
    if (pay.g() >= 2)
    {
      QQToast.a(this.a.a, 0, this.a.a.getString(2131717351), 0).b(this.a.a.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    ReadinjoyTabFrame.a(this.a.a);
    pay.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.2
 * JD-Core Version:    0.7.0.1
 */