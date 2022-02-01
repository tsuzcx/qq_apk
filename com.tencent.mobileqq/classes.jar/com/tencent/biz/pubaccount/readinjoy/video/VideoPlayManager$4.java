package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import seu;
import sez;
import sfb;
import sfq;

public class VideoPlayManager$4
  implements Runnable
{
  public VideoPlayManager$4(seu paramseu) {}
  
  public void run()
  {
    seu.a(this.this$0, seu.a(this.this$0), seu.a(this.this$0), 7, null);
    if (seu.a(this.this$0) != null)
    {
      Iterator localIterator = seu.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        sez localsez = (sez)localIterator.next();
        if (localsez != null) {
          localsez.a(seu.a(this.this$0), seu.a(this.this$0).a());
        }
      }
    }
    if (seu.a(this.this$0) != null)
    {
      seu.a(this.this$0).e = -1;
      seu.a(this.this$0).d = 0L;
      seu.a(this.this$0, null);
    }
    if (seu.a(this.this$0) != null)
    {
      seu.a(this.this$0).l();
      seu.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */