package com.tencent.gdtad.basics.motivevideo;

import android.media.AudioManager;

class GdtMvViewController$11
  implements Runnable
{
  GdtMvViewController$11(GdtMvViewController paramGdtMvViewController) {}
  
  public void run()
  {
    int i = GdtMvViewController.j(this.this$0).getStreamVolume(3);
    if (GdtMvViewController.k(this.this$0) != null)
    {
      localGdtMvViewController = this.this$0;
      boolean bool;
      if (i <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      localGdtMvViewController.a = bool;
      GdtMvViewController.k(this.this$0).setMute(this.this$0.a);
    }
    GdtMvViewController localGdtMvViewController = this.this$0;
    GdtMvViewController.a(localGdtMvViewController, i, GdtMvViewController.l(localGdtMvViewController), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.11
 * JD-Core Version:    0.7.0.1
 */