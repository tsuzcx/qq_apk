package com.tencent.luggage.wxa.or;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Timer;

class g
{
  private int a = 0;
  private g.a b = null;
  private Timer c = null;
  
  private void b()
  {
    Timer localTimer = this.c;
    if (localTimer != null) {
      localTimer.cancel();
    }
    this.a = 0;
    this.b = null;
  }
  
  void a()
  {
    o.d("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
    t.a(new g.2(this));
  }
  
  void a(g.a parama)
  {
    t.a(new g.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.g
 * JD-Core Version:    0.7.0.1
 */