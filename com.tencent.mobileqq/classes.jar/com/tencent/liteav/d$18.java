package com.tencent.liteav;

import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.h.a;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

class d$18
  implements h.a
{
  d$18(d paramd, WeakReference paramWeakReference) {}
  
  public void a(int paramInt)
  {
    h localh = d.r(this.b);
    o localo = (o)this.a.get();
    if ((localh != null) && (localo != null))
    {
      TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
      localTXSVideoFrame.width = localh.n();
      localTXSVideoFrame.height = localh.o();
      localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
      localo.onRenderVideoFrame(this.b.getID(), d.s(this.b), localTXSVideoFrame);
      d.a(this.b, localTXSVideoFrame.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.d.18
 * JD-Core Version:    0.7.0.1
 */