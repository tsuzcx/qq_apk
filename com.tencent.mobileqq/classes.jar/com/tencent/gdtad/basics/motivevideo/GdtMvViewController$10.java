package com.tencent.gdtad.basics.motivevideo;

import android.media.AudioManager;
import com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer;

class GdtMvViewController$10
  implements Runnable
{
  GdtMvViewController$10(GdtMvViewController paramGdtMvViewController) {}
  
  public void run()
  {
    int i = GdtMvViewController.a(this.this$0).getStreamVolume(3);
    if (GdtMvViewController.a(this.this$0) != null)
    {
      localGdtMvViewController = this.this$0;
      boolean bool;
      if (i <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      localGdtMvViewController.a = bool;
      GdtMvViewController.a(this.this$0).setMute(this.this$0.a);
    }
    GdtMvViewController localGdtMvViewController = this.this$0;
    GdtMvViewController.a(localGdtMvViewController, i, GdtMvViewController.b(localGdtMvViewController), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.10
 * JD-Core Version:    0.7.0.1
 */