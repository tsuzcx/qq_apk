package com.tencent.gdtad.api.interstitial;

import acbv;
import acby;
import acho;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(acbv paramacbv) {}
  
  public void run()
  {
    acho.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(acbv.a(this.this$0)) }));
    if (!acbv.a(this.this$0))
    {
      acbv.a(this.this$0, 1);
      acbv.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      acbv.a(this.this$0, 1);
      acby.a();
      if (TextUtils.isEmpty(acbv.a(this.this$0)))
      {
        acbv.a(this.this$0, 2);
        acbv.a(this.this$0);
      }
      while (acbv.a(this.this$0) >= 0L)
      {
        acbv.a(this.this$0, 13, -2147483648, acbv.a(this.this$0));
        return;
        acbv.a(this.this$0, 3);
        acbv.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */