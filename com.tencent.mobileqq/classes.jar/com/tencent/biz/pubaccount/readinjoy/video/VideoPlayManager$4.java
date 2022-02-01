package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import sdc;
import sdh;
import sdj;
import sdy;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(sdc paramsdc) {}
  
  public void run()
  {
    sdc.a(this.this$0, sdc.a(this.this$0), sdc.a(this.this$0), 7, null);
    if (sdc.a(this.this$0) != null)
    {
      Iterator localIterator = sdc.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        sdh localsdh = (sdh)localIterator.next();
        if (localsdh != null) {
          localsdh.a(sdc.a(this.this$0), sdc.a(this.this$0).a());
        }
      }
    }
    if (sdc.a(this.this$0) != null)
    {
      sdc.a(this.this$0).e = -1;
      sdc.a(this.this$0).d = 0L;
      sdc.a(this.this$0, null);
    }
    if (sdc.a(this.this$0) != null)
    {
      sdc.a(this.this$0).l();
      sdc.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */