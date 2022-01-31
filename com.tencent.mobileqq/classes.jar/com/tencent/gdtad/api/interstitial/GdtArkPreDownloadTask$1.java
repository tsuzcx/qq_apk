package com.tencent.gdtad.api.interstitial;

import aaju;
import aajx;
import aanp;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(aaju paramaaju) {}
  
  public void run()
  {
    aanp.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(aaju.a(this.this$0)) }));
    if (!aaju.a(this.this$0))
    {
      aaju.a(this.this$0, 1);
      aaju.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      aaju.a(this.this$0, 1);
      aajx.a();
      if (TextUtils.isEmpty(aaju.a(this.this$0)))
      {
        aaju.a(this.this$0, 2);
        aaju.a(this.this$0);
      }
      while (aaju.a(this.this$0) >= 0L)
      {
        aaju.a(this.this$0, 13, -2147483648, aaju.a(this.this$0));
        return;
        aaju.a(this.this$0, 3);
        aaju.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */