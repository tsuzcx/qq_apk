package com.tencent.TMG.audio;

import com.tencent.TMG.utils.QLog;
import java.util.TimerTask;

class TraeMediaPlayer$1
  extends TimerTask
{
  TraeMediaPlayer$1(TraeMediaPlayer paramTraeMediaPlayer) {}
  
  public void run()
  {
    if (TraeMediaPlayer.access$000(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "TraeMediaPlay | play timeout");
      }
      if (TraeMediaPlayer.access$100(this.this$0) != null) {
        TraeMediaPlayer.access$100(this.this$0).onCompletion();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */