package com.tencent.gdtad.api.interstitial;

import aclu;
import aclx;
import acqy;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(aclu paramaclu) {}
  
  public void run()
  {
    acqy.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(aclu.a(this.this$0)) }));
    if (!aclu.a(this.this$0))
    {
      aclu.a(this.this$0, 1);
      aclu.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      aclu.a(this.this$0, 1);
      aclx.a();
      if (TextUtils.isEmpty(aclu.a(this.this$0)))
      {
        aclu.a(this.this$0, 2);
        aclu.a(this.this$0);
      }
      while (aclu.a(this.this$0) >= 0L)
      {
        aclu.a(this.this$0, 13, -2147483648, aclu.a(this.this$0));
        return;
        aclu.a(this.this$0, 3);
        aclu.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */