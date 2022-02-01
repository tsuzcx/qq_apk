package com.tencent.luggage.wxa.ml;

import android.widget.ProgressBar;
import com.tencent.luggage.wxa.ma.e.c;
import com.tencent.luggage.wxa.qz.o;

class b$9
  implements Runnable
{
  b$9(b paramb) {}
  
  public void run()
  {
    if (!b.b(this.a)) {
      return;
    }
    b.b(this.a, false);
    if (this.a.p != null) {
      this.a.p.f(this.a.getSessionId(), this.a.getMediaId());
    }
    if ((this.a.f != null) && (this.a.f.getVisibility() != 8))
    {
      o.d("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { this.a.v() });
      this.a.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b.9
 * JD-Core Version:    0.7.0.1
 */