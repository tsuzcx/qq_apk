package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import java.util.List;

class DanmuView$3
  implements Runnable
{
  DanmuView$3(DanmuView paramDanmuView, d paramd) {}
  
  public void run()
  {
    List localList = DanmuView.a(this.b);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < DanmuView.a(this.b).size())
        {
          if (this.a.e() > ((d)DanmuView.a(this.b).get(i)).e()) {
            continue;
          }
          DanmuView.a(this.b).add(i, this.a);
        }
        return;
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3
 * JD-Core Version:    0.7.0.1
 */