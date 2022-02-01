package com.tencent.liteav;

import java.lang.ref.WeakReference;

class f$a
  implements Runnable
{
  private WeakReference<f> a;
  
  f$a(f paramf)
  {
    this.a = new WeakReference(paramf);
  }
  
  public void run()
  {
    f localf = (f)this.a.get();
    if (localf == null) {
      return;
    }
    localf.g();
    f.e(localf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.f.a
 * JD-Core Version:    0.7.0.1
 */