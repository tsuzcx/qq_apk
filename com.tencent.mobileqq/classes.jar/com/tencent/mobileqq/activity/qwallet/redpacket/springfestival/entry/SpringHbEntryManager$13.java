package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry;

import agtk;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.PreviewInfo;

public class SpringHbEntryManager$13
  implements Runnable
{
  public SpringHbEntryManager$13(agtk paramagtk) {}
  
  public void run()
  {
    agtk.f(this.this$0);
    SpringFestivalRedpakcetPreviewConfBean.PreviewInfo localPreviewInfo = this.this$0.a(this.this$0.b());
    if (localPreviewInfo == null) {
      this.this$0.a("", 4002);
    }
    for (;;)
    {
      agtk.g(this.this$0);
      return;
      this.this$0.a(localPreviewInfo.activityId, 4001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.13
 * JD-Core Version:    0.7.0.1
 */