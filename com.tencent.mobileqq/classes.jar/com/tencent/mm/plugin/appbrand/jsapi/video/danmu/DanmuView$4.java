package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.Deque;
import java.util.List;

class DanmuView$4
  implements Runnable
{
  DanmuView$4(DanmuView paramDanmuView, List paramList) {}
  
  public void run()
  {
    synchronized (DanmuView.b(this.b))
    {
      DanmuView.b(this.b).addAll(this.a);
      synchronized (DanmuView.a(this.b))
      {
        DanmuView.a(this.b).addAll(this.a);
        this.b.postInvalidate();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4
 * JD-Core Version:    0.7.0.1
 */