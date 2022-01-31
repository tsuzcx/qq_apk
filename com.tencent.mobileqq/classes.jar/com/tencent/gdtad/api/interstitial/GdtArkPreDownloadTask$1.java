package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import yug;
import yuj;
import yxs;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(yug paramyug) {}
  
  public void run()
  {
    yxs.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(yug.a(this.this$0)) }));
    if (!yug.a(this.this$0))
    {
      yug.a(this.this$0, 1);
      yug.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      yug.a(this.this$0, 1);
      yuj.a();
      if (TextUtils.isEmpty(yug.a(this.this$0)))
      {
        yug.a(this.this$0, 2);
        yug.a(this.this$0);
      }
      while (yug.a(this.this$0) >= 0L)
      {
        yug.a(this.this$0, 13, -2147483648, yug.a(this.this$0));
        return;
        yug.a(this.this$0, 3);
        yug.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */