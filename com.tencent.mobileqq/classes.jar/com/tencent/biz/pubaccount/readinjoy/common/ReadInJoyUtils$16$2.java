package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import pay;
import pbb;

public class ReadInJoyUtils$16$2
  implements Runnable
{
  public ReadInJoyUtils$16$2(pbb parampbb) {}
  
  public void run()
  {
    if (pay.g() >= 2)
    {
      QQToast.a(this.this$0.a, 0, this.this$0.a.getString(2131717351), 0).b(this.this$0.a.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    pay.a(this.this$0.a);
    pay.a("3", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.16.2
 * JD-Core Version:    0.7.0.1
 */