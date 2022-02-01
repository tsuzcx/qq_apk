package com.tencent.liteav.renderer;

import android.view.TextureView;

class d$4
  implements Runnable
{
  d$4(d paramd, boolean paramBoolean) {}
  
  public void run()
  {
    if (d.e(this.b) != null)
    {
      d locald = this.b;
      d.a(locald, Math.abs(d.f(locald)));
      if (this.a)
      {
        locald = this.b;
        d.a(locald, -d.f(locald));
      }
      d.e(this.b).setScaleX(d.f(this.b));
      d.e(this.b).setScaleY(Math.abs(d.f(this.b)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.d.4
 * JD-Core Version:    0.7.0.1
 */