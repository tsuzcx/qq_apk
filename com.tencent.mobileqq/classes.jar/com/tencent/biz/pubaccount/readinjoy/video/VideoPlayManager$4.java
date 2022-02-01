package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import rvy;
import rwd;
import rwf;
import rwu;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(rvy paramrvy) {}
  
  public void run()
  {
    rvy.a(this.this$0, rvy.a(this.this$0), rvy.a(this.this$0), 7, null);
    if (rvy.a(this.this$0) != null)
    {
      Iterator localIterator = rvy.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        rwd localrwd = (rwd)localIterator.next();
        if (localrwd != null) {
          localrwd.a(rvy.a(this.this$0), rvy.a(this.this$0).a());
        }
      }
    }
    if (rvy.a(this.this$0) != null)
    {
      rvy.a(this.this$0).e = -1;
      rvy.a(this.this$0).d = 0L;
      rvy.a(this.this$0, null);
    }
    if (rvy.a(this.this$0) != null)
    {
      rvy.a(this.this$0).l();
      rvy.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */