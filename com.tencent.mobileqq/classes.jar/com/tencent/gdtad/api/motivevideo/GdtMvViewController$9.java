package com.tencent.gdtad.api.motivevideo;

import abpi;
import amaj;
import android.media.AudioManager;

public class GdtMvViewController$9
  implements Runnable
{
  public GdtMvViewController$9(abpi paramabpi) {}
  
  public void run()
  {
    int i = abpi.a(this.this$0).getStreamVolume(3);
    abpi localabpi;
    if (abpi.a(this.this$0) != null)
    {
      localabpi = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localabpi.a = bool;
      abpi.a(this.this$0).a(this.this$0.a);
      abpi.a(this.this$0, i, abpi.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.9
 * JD-Core Version:    0.7.0.1
 */