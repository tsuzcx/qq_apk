package com.tencent.luggage.wxa.ky;

import android.os.Handler;
import com.tencent.luggage.wxa.qz.o;

class b$a
  implements Runnable
{
  int a;
  int b = 0;
  
  b$a(b paramb) {}
  
  public void a()
  {
    this.b = 0;
    b.b(this.c).removeCallbacks(this);
  }
  
  public void b()
  {
    b.b(this.c).postDelayed(this, 250L);
  }
  
  public void run()
  {
    this.b += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CheckRotateTask] number=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  senorAngle=");
    localStringBuilder.append(this.a);
    o.d("MicroMsg.AppBrandLivePusherView", localStringBuilder.toString());
    int i = b.c(this.c);
    if (i == this.a)
    {
      b.a(this.c, i);
      return;
    }
    if (this.b < 8) {
      b.b(this.c).postDelayed(this, 250L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.b.a
 * JD-Core Version:    0.7.0.1
 */