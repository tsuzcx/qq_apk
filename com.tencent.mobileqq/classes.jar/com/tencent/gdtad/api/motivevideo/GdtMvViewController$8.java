package com.tencent.gdtad.api.motivevideo;

import aaqa;
import alap;
import android.media.AudioManager;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(aaqa paramaaqa) {}
  
  public void run()
  {
    int i = aaqa.a(this.this$0).getStreamVolume(3);
    aaqa localaaqa;
    if (aaqa.a(this.this$0) != null)
    {
      localaaqa = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localaaqa.a = bool;
      aaqa.a(this.this$0).a(this.this$0.a);
      aaqa.a(this.this$0, i, aaqa.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */