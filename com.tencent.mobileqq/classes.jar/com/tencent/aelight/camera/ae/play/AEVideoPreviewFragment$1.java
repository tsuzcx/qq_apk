package com.tencent.aelight.camera.ae.play;

import android.widget.SeekBar;
import com.tencent.tavcut.player.MoviePlayer.onVideoProgressListener;

class AEVideoPreviewFragment$1
  implements MoviePlayer.onVideoProgressListener
{
  AEVideoPreviewFragment$1(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void updateVideoProgress(long paramLong)
  {
    if (this.this$0.tavCutVideoSession != null) {
      AEVideoPreviewFragment.access$000(this.this$0).setProgress((int)paramLong * 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */