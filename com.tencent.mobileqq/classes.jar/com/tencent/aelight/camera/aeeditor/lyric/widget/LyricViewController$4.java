package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;

class LyricViewController$4
  implements Runnable
{
  LyricViewController$4(LyricViewController paramLyricViewController, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.d != null) && (!this.this$0.d.isEmpty()))
    {
      this.this$0.e = (SystemClock.elapsedRealtime() - this.a);
      if ((this.this$0.f) && (this.this$0.g > 0))
      {
        LyricViewController localLyricViewController = this.this$0;
        localLyricViewController.e -= this.this$0.g;
      }
      LyricViewController.a(this.this$0, this.a, this.b);
      return;
    }
    Log.w("ModuleController", "seek before set lyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController.4
 * JD-Core Version:    0.7.0.1
 */