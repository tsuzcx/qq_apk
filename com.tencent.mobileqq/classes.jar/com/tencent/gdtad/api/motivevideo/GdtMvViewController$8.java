package com.tencent.gdtad.api.motivevideo;

import ajeo;
import android.media.AudioManager;
import yvs;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(yvs paramyvs) {}
  
  public void run()
  {
    int i = yvs.a(this.this$0).getStreamVolume(3);
    yvs localyvs;
    if (yvs.a(this.this$0) != null)
    {
      localyvs = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localyvs.a = bool;
      yvs.a(this.this$0).a(this.this$0.a);
      yvs.a(this.this$0, i, yvs.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */