package com.tencent.gdtad.api.motivevideo;

import ajeq;
import android.media.AudioManager;
import yvv;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(yvv paramyvv) {}
  
  public void run()
  {
    int i = yvv.a(this.this$0).getStreamVolume(3);
    yvv localyvv;
    if (yvv.a(this.this$0) != null)
    {
      localyvv = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localyvv.a = bool;
      yvv.a(this.this$0).a(this.this$0.a);
      yvv.a(this.this$0, i, yvv.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */