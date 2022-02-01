package com.tencent.liteav;

import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.h.a;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class TXCRenderAndDec$1
  implements h.a
{
  TXCRenderAndDec$1(TXCRenderAndDec paramTXCRenderAndDec, int paramInt) {}
  
  public void a(int paramInt)
  {
    h localh = TXCRenderAndDec.access$000(this.b);
    o localo = TXCRenderAndDec.access$100(this.b);
    if ((localh != null) && (localo != null))
    {
      TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
      localTXSVideoFrame.width = localh.n();
      localTXSVideoFrame.height = localh.o();
      localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
      localTXSVideoFrame.rotation = ((this.a + TXCRenderAndDec.access$200(this.b)) % 360);
      localo.onRenderVideoFrame(this.b.getID(), TXCRenderAndDec.access$300(this.b), localTXSVideoFrame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.TXCRenderAndDec.1
 * JD-Core Version:    0.7.0.1
 */