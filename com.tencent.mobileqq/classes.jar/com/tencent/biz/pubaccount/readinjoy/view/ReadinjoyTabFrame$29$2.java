package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import ors;
import rwx;

public class ReadinjoyTabFrame$29$2
  implements Runnable
{
  public ReadinjoyTabFrame$29$2(rwx paramrwx) {}
  
  public void run()
  {
    if (ors.g() >= 2)
    {
      QQToast.a(this.a.a, 0, this.a.a.getString(2131718857), 0).b(this.a.a.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    ReadinjoyTabFrame.a(this.a.a);
    ors.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.29.2
 * JD-Core Version:    0.7.0.1
 */