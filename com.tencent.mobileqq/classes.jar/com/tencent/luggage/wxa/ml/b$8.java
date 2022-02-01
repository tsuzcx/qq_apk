package com.tencent.luggage.wxa.ml;

import android.widget.ProgressBar;
import com.tencent.luggage.wxa.ma.e.c;
import com.tencent.luggage.wxa.qz.o;

class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public void run()
  {
    b.b(this.a, true);
    if ((this.a.f != null) && (this.a.f.getVisibility() != 0))
    {
      o.d("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { this.a.v() });
      this.a.f.setVisibility(0);
    }
    if (this.a.p != null) {
      this.a.p.e(this.a.getSessionId(), this.a.getMediaId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b.8
 * JD-Core Version:    0.7.0.1
 */