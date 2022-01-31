package com.tencent.gdtad.api.interstitial;

import aaoj;
import aaom;
import aase;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(aaoj paramaaoj) {}
  
  public void run()
  {
    aase.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(aaoj.a(this.this$0)) }));
    if (!aaoj.a(this.this$0))
    {
      aaoj.a(this.this$0, 1);
      aaoj.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      aaoj.a(this.this$0, 1);
      aaom.a();
      if (TextUtils.isEmpty(aaoj.a(this.this$0)))
      {
        aaoj.a(this.this$0, 2);
        aaoj.a(this.this$0);
      }
      while (aaoj.a(this.this$0) >= 0L)
      {
        aaoj.a(this.this$0, 13, -2147483648, aaoj.a(this.this$0));
        return;
        aaoj.a(this.this$0, 3);
        aaoj.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */