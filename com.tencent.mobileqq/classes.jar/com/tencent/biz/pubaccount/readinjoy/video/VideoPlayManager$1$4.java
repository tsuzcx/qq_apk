package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import qhp;
import qhq;
import qhu;
import qhw;
import qiy;

public class VideoPlayManager$1$4
  implements Runnable
{
  public VideoPlayManager$1$4(qhq paramqhq) {}
  
  public void run()
  {
    qhp.a(this.a.a, qhp.a(this.a.a), qhp.a(this.a.a), 7, null);
    if (qhp.a(this.a.a) != null)
    {
      Iterator localIterator = qhp.a(this.a.a).iterator();
      while (localIterator.hasNext())
      {
        qhu localqhu = (qhu)localIterator.next();
        if (localqhu != null) {
          localqhu.a(qhp.a(this.a.a), qhp.a(this.a.a).a());
        }
      }
    }
    if (qhp.a(this.a.a) != null)
    {
      qhp.a(this.a.a).e = -1;
      qhp.a(this.a.a).d = 0L;
      qhp.c(this.a.a, null);
    }
    if (qhp.a(this.a.a) != null)
    {
      qhp.a(this.a.a).m();
      qhp.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4
 * JD-Core Version:    0.7.0.1
 */