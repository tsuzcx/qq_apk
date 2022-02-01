package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;

class GdtArkPreDownloadTask$1
  implements Runnable
{
  GdtArkPreDownloadTask$1(GdtArkPreDownloadTask paramGdtArkPreDownloadTask) {}
  
  public void run()
  {
    GdtLog.b("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(GdtArkPreDownloadTask.a(this.this$0)) }));
    if (!GdtArkPreDownloadTask.a(this.this$0))
    {
      GdtArkPreDownloadTask.a(this.this$0, 1);
      GdtArkPreDownloadTask.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      GdtArkPreDownloadTask.a(this.this$0, 1);
      GdtArkUtil.a();
      if (TextUtils.isEmpty(GdtArkPreDownloadTask.a(this.this$0)))
      {
        GdtArkPreDownloadTask.a(this.this$0, 2);
        GdtArkPreDownloadTask.a(this.this$0);
      }
      while (GdtArkPreDownloadTask.a(this.this$0) >= 0L)
      {
        GdtArkPreDownloadTask.a(this.this$0, 13, -2147483648, GdtArkPreDownloadTask.a(this.this$0));
        return;
        GdtArkPreDownloadTask.a(this.this$0, 3);
        GdtArkPreDownloadTask.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */