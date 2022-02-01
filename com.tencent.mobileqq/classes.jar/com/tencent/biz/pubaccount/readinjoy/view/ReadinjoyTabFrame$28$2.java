package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import ozs;
import slv;

public class ReadinjoyTabFrame$28$2
  implements Runnable
{
  public ReadinjoyTabFrame$28$2(slv paramslv) {}
  
  public void run()
  {
    if (ozs.g() >= 2)
    {
      QQToast.a(this.a.a, 0, this.a.a.getString(2131717114), 0).b(this.a.a.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    ReadinjoyTabFrame.a(this.a.a);
    ozs.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.2
 * JD-Core Version:    0.7.0.1
 */