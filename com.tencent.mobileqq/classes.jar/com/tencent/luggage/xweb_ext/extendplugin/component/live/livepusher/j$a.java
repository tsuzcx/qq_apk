package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.os.Handler;

class j$a
  implements Runnable
{
  int a;
  int b = 0;
  
  j$a(j paramj) {}
  
  public void a()
  {
    this.b = 0;
    j.d(this.c).removeCallbacks(this);
  }
  
  public void b()
  {
    j.d(this.c).postDelayed(this, 250L);
  }
  
  public void run()
  {
    this.b += 1;
    int i = j.e(this.c);
    if (i == this.a)
    {
      j.a(this.c, i);
      return;
    }
    if (this.b < 8) {
      j.d(this.c).postDelayed(this, 250L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.a
 * JD-Core Version:    0.7.0.1
 */