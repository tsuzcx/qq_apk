package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import qtr;
import qts;
import qtw;
import qty;
import qva;

public class VideoPlayManager$1$4
  implements Runnable
{
  public VideoPlayManager$1$4(qts paramqts) {}
  
  public void run()
  {
    qtr.a(this.a.a, qtr.a(this.a.a), qtr.a(this.a.a), 7, null);
    if (qtr.a(this.a.a) != null)
    {
      Iterator localIterator = qtr.a(this.a.a).iterator();
      while (localIterator.hasNext())
      {
        qtw localqtw = (qtw)localIterator.next();
        if (localqtw != null) {
          localqtw.a(qtr.a(this.a.a), qtr.a(this.a.a).a());
        }
      }
    }
    if (qtr.a(this.a.a) != null)
    {
      qtr.a(this.a.a).e = -1;
      qtr.a(this.a.a).d = 0L;
      qtr.c(this.a.a, null);
    }
    if (qtr.a(this.a.a) != null)
    {
      qtr.a(this.a.a).m();
      qtr.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4
 * JD-Core Version:    0.7.0.1
 */