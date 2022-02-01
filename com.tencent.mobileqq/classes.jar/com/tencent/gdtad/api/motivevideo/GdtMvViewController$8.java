package com.tencent.gdtad.api.motivevideo;

import acsz;
import android.media.AudioManager;
import anfp;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(acsz paramacsz) {}
  
  public void run()
  {
    int i = acsz.a(this.this$0).getStreamVolume(3);
    acsz localacsz;
    if (acsz.a(this.this$0) != null)
    {
      localacsz = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localacsz.a = bool;
      acsz.a(this.this$0).a(this.this$0.a);
      acsz.a(this.this$0, i, acsz.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */