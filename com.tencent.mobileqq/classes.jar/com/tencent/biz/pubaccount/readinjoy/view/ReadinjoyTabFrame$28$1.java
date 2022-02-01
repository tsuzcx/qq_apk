package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import pqq;
import tdh;

public class ReadinjoyTabFrame$28$1
  implements Runnable
{
  public ReadinjoyTabFrame$28$1(tdh paramtdh) {}
  
  public void run()
  {
    if (pqq.a() >= 2)
    {
      QQToast.a(this.a.a, 0, this.a.a.getString(2131717717), 0).b(this.a.a.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    ReadinjoyTabFrame.a(this.a.a);
    pqq.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.1
 * JD-Core Version:    0.7.0.1
 */