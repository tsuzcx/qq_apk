package com.tencent.gdtad.api.motivevideo;

import android.media.AudioManager;
import com.tencent.mobileqq.apollo.process.video.ICmGameVideoPlayer;

class GdtMvViewController$11
  implements Runnable
{
  GdtMvViewController$11(GdtMvViewController paramGdtMvViewController) {}
  
  public void run()
  {
    int i = GdtMvViewController.a(this.this$0).getStreamVolume(3);
    GdtMvViewController localGdtMvViewController;
    if (GdtMvViewController.a(this.this$0) != null)
    {
      localGdtMvViewController = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localGdtMvViewController.a = bool;
      GdtMvViewController.a(this.this$0).a(this.this$0.a);
      GdtMvViewController.a(this.this$0, i, GdtMvViewController.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.11
 * JD-Core Version:    0.7.0.1
 */