package com.tencent.gdtad.api.motivevideo;

import aall;
import akwa;
import android.media.AudioManager;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(aall paramaall) {}
  
  public void run()
  {
    int i = aall.a(this.this$0).getStreamVolume(3);
    aall localaall;
    if (aall.a(this.this$0) != null)
    {
      localaall = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localaall.a = bool;
      aall.a(this.this$0).a(this.this$0.a);
      aall.a(this.this$0, i, aall.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */