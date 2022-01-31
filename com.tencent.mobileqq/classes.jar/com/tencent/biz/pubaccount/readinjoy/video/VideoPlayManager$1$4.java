package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import qtu;
import qtv;
import qtz;
import qub;
import qvd;

public class VideoPlayManager$1$4
  implements Runnable
{
  public VideoPlayManager$1$4(qtv paramqtv) {}
  
  public void run()
  {
    qtu.a(this.a.a, qtu.a(this.a.a), qtu.a(this.a.a), 7, null);
    if (qtu.a(this.a.a) != null)
    {
      Iterator localIterator = qtu.a(this.a.a).iterator();
      while (localIterator.hasNext())
      {
        qtz localqtz = (qtz)localIterator.next();
        if (localqtz != null) {
          localqtz.a(qtu.a(this.a.a), qtu.a(this.a.a).a());
        }
      }
    }
    if (qtu.a(this.a.a) != null)
    {
      qtu.a(this.a.a).e = -1;
      qtu.a(this.a.a).d = 0L;
      qtu.c(this.a.a, null);
    }
    if (qtu.a(this.a.a) != null)
    {
      qtu.a(this.a.a).m();
      qtu.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4
 * JD-Core Version:    0.7.0.1
 */