package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import spg;
import spl;
import spn;
import sqd;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(spg paramspg) {}
  
  public void run()
  {
    spg.a(this.this$0, spg.a(this.this$0), spg.a(this.this$0), 7, null);
    if (spg.a(this.this$0) != null)
    {
      Iterator localIterator = spg.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        spl localspl = (spl)localIterator.next();
        if (localspl != null) {
          localspl.a(spg.a(this.this$0), spg.a(this.this$0).a());
        }
      }
    }
    if (spg.a(this.this$0) != null)
    {
      spg.a(this.this$0).e = -1;
      spg.a(this.this$0).d = 0L;
      spg.a(this.this$0, null);
    }
    if (spg.a(this.this$0) != null)
    {
      spg.a(this.this$0).l();
      spg.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */