package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ge.c;
import com.tencent.luggage.wxa.ge.c.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;

public class d
  implements c
{
  private c.a a;
  
  private String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1024) {
      return "VIDEO_ERROR";
    }
    if (paramInt1 == -1010) {
      return "MEDIA_ERR_SRC_NOT_SUPPORTED";
    }
    if (paramInt1 == -1007) {
      return "MEDIA_ERR_SRC_NOT_SUPPORTED";
    }
    if (paramInt1 == -1004)
    {
      if (!x.a(r.a())) {
        return "MEDIA_ERR_NETWORK";
      }
      return "MEDIA_ERR_DECODE";
    }
    if (!x.a(r.a())) {
      return "MEDIA_ERR_NETWORK";
    }
    return "MEDIA_ERR_DECODE";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a locala = this.a;
    if (locala != null) {
      locala.a(b(paramInt1, paramInt2), paramInt1, paramInt2);
    }
  }
  
  public void a(c.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.d
 * JD-Core Version:    0.7.0.1
 */