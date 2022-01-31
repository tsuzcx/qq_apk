package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import rjg;
import rjh;
import rjl;
import rjn;
import rkp;

public class VideoPlayManager$1$4
  implements Runnable
{
  public VideoPlayManager$1$4(rjh paramrjh) {}
  
  public void run()
  {
    rjg.a(this.a.a, rjg.a(this.a.a), rjg.a(this.a.a), 7, null);
    if (rjg.a(this.a.a) != null)
    {
      Iterator localIterator = rjg.a(this.a.a).iterator();
      while (localIterator.hasNext())
      {
        rjl localrjl = (rjl)localIterator.next();
        if (localrjl != null) {
          localrjl.a(rjg.a(this.a.a), rjg.a(this.a.a).a());
        }
      }
    }
    if (rjg.a(this.a.a) != null)
    {
      rjg.a(this.a.a).e = -1;
      rjg.a(this.a.a).d = 0L;
      rjg.c(this.a.a, null);
    }
    if (rjg.a(this.a.a) != null)
    {
      rjg.a(this.a.a).m();
      rjg.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4
 * JD-Core Version:    0.7.0.1
 */