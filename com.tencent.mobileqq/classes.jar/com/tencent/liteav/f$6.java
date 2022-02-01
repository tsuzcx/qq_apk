package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.liteav.basic.util.h;

class f$6
  implements Runnable
{
  f$6(f paramf, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    h.a(this.c.d, this.a, this.b);
    if ((this.a == 2103) && (f.f(this.c) != null)) {
      f.f(this.c).restartDecoder();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.f.6
 * JD-Core Version:    0.7.0.1
 */