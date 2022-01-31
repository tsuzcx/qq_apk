package com.tencent.gdtad.api.motivevideo;

import airs;
import android.media.AudioManager;
import yme;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(yme paramyme) {}
  
  public void run()
  {
    int i = yme.a(this.this$0).getStreamVolume(3);
    yme localyme;
    if (yme.a(this.this$0) != null)
    {
      localyme = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localyme.a = bool;
      yme.a(this.this$0).a(this.this$0.a);
      yme.a(this.this$0, i, yme.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */