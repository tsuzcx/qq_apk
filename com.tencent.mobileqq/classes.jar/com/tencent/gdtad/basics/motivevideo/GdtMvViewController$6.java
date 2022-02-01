package com.tencent.gdtad.basics.motivevideo;

import java.lang.ref.WeakReference;

class GdtMvViewController$6
  implements Runnable
{
  GdtMvViewController$6(GdtMvViewController paramGdtMvViewController) {}
  
  public void run()
  {
    if (GdtMvViewController.d(this.this$0) == null) {
      return;
    }
    GdtMvViewController.Listener localListener = (GdtMvViewController.Listener)GdtMvViewController.d(this.this$0).get();
    if (localListener != null)
    {
      long l1;
      if (GdtMvViewController.e(this.this$0)) {
        l1 = GdtMvViewController.f(this.this$0);
      } else {
        l1 = GdtMvViewController.g(this.this$0) * 1000L;
      }
      long l2 = this.this$0.c();
      this.this$0.m();
      localListener.a((l1 - l2) / 1000L + 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.6
 * JD-Core Version:    0.7.0.1
 */