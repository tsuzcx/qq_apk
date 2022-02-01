package com.tencent.gdtad.api.interstitial;

import abmf;
import abmi;
import abrl;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(abmf paramabmf) {}
  
  public void run()
  {
    abrl.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(abmf.a(this.this$0)) }));
    if (!abmf.a(this.this$0))
    {
      abmf.a(this.this$0, 1);
      abmf.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      abmf.a(this.this$0, 1);
      abmi.a();
      if (TextUtils.isEmpty(abmf.a(this.this$0)))
      {
        abmf.a(this.this$0, 2);
        abmf.a(this.this$0);
      }
      while (abmf.a(this.this$0) >= 0L)
      {
        abmf.a(this.this$0, 13, -2147483648, abmf.a(this.this$0));
        return;
        abmf.a(this.this$0, 3);
        abmf.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */