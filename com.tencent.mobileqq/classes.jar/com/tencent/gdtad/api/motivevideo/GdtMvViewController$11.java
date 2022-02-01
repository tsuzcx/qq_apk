package com.tencent.gdtad.api.motivevideo;

import acey;
import anaz;
import android.media.AudioManager;

public class GdtMvViewController$11
  implements Runnable
{
  public GdtMvViewController$11(acey paramacey) {}
  
  public void run()
  {
    int i = acey.a(this.this$0).getStreamVolume(3);
    acey localacey;
    if (acey.a(this.this$0) != null)
    {
      localacey = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localacey.a = bool;
      acey.a(this.this$0).a(this.this$0.a);
      acey.a(this.this$0, i, acey.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.11
 * JD-Core Version:    0.7.0.1
 */