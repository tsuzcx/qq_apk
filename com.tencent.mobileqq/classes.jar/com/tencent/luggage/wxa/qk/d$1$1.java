package com.tencent.luggage.wxa.qk;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.r;

class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - d.1.a(this.a) > 10000L)
    {
      d.1.a(this.a, System.currentTimeMillis());
      Toast.makeText(r.a(), r.a().getString(2131892039), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.d.1.1
 * JD-Core Version:    0.7.0.1
 */