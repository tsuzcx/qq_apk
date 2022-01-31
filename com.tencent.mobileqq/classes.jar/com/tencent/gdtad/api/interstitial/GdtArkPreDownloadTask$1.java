package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import yud;
import yug;
import yxp;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(yud paramyud) {}
  
  public void run()
  {
    yxp.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(yud.a(this.this$0)) }));
    if (!yud.a(this.this$0))
    {
      yud.a(this.this$0, 1);
      yud.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      yud.a(this.this$0, 1);
      yug.a();
      if (TextUtils.isEmpty(yud.a(this.this$0)))
      {
        yud.a(this.this$0, 2);
        yud.a(this.this$0);
      }
      while (yud.a(this.this$0) >= 0L)
      {
        yud.a(this.this$0, 13, -2147483648, yud.a(this.this$0));
        return;
        yud.a(this.this$0, 3);
        yud.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */