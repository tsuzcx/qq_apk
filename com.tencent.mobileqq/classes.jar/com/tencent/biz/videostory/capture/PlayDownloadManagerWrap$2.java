package com.tencent.biz.videostory.capture;

import bgya;
import mqq.util.WeakReference;
import wtt;
import wus;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(wtt paramwtt, bgya parambgya) {}
  
  public void run()
  {
    if (this.a.e == 0) {
      if ((wtt.a(this.this$0) != null) && (wtt.a(this.this$0).get() != null))
      {
        wrn.b = this.a;
        ((wus)wtt.a(this.this$0).get()).a(393218, new Object[] { this.a });
      }
    }
    while (((this.a.e != 4) && (this.a.e != 5) && (this.a.e != 6) && (this.a.e != 7)) || (wtt.a(this.this$0) == null) || (wtt.a(this.this$0).get() == null)) {
      return;
    }
    ((wus)wtt.a(this.this$0).get()).a(655361, new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */