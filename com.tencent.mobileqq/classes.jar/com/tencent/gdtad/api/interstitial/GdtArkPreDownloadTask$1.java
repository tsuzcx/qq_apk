package com.tencent.gdtad.api.interstitial;

import acpw;
import acpz;
import acvc;
import android.text.TextUtils;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(acpw paramacpw) {}
  
  public void run()
  {
    acvc.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(acpw.a(this.this$0)) }));
    if (!acpw.a(this.this$0))
    {
      acpw.a(this.this$0, 1);
      acpw.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      acpw.a(this.this$0, 1);
      acpz.a();
      if (TextUtils.isEmpty(acpw.a(this.this$0)))
      {
        acpw.a(this.this$0, 2);
        acpw.a(this.this$0);
      }
      while (acpw.a(this.this$0) >= 0L)
      {
        acpw.a(this.this$0, 13, -2147483648, acpw.a(this.this$0));
        return;
        acpw.a(this.this$0, 3);
        acpw.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */