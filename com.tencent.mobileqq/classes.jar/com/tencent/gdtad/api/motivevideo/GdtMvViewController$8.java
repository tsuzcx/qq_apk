package com.tencent.gdtad.api.motivevideo;

import acow;
import amtv;
import android.media.AudioManager;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(acow paramacow) {}
  
  public void run()
  {
    int i = acow.a(this.this$0).getStreamVolume(3);
    acow localacow;
    if (acow.a(this.this$0) != null)
    {
      localacow = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localacow.a = bool;
      acow.a(this.this$0).a(this.this$0.a);
      acow.a(this.this$0, i, acow.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */