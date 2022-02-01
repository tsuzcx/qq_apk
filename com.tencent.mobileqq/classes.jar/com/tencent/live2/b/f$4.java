package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;

class f$4
  implements Runnable
{
  f$4(f paramf, f.b paramb, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    f.b localb = this.a;
    if ((localb != null) && (localb.g != null) && (this.a.f != null)) {
      this.a.f.onError(this.a.g, -1, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.4
 * JD-Core Version:    0.7.0.1
 */