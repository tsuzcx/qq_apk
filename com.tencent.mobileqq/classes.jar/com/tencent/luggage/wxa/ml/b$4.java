package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v.a;

class b$4
  implements v.a
{
  b$4(b paramb) {}
  
  public boolean p_()
  {
    boolean bool = this.a.b();
    int i = this.a.getCurrPosMs();
    o.d("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { this.a.v(), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.a.k != null) && (i <= 50)) {
      this.a.k.a(0.0D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b.4
 * JD-Core Version:    0.7.0.1
 */