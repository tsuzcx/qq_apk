package com.google.android.exoplayer2.ext.mediaplayer;

import com.google.android.exoplayer2.ExoPlayer;

class ExoMediaPlayer$BufferRepeatListener
  implements Repeater.RepeatListener
{
  private ExoMediaPlayer$BufferRepeatListener(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public void onUpdate()
  {
    synchronized (this.this$0)
    {
      if (ExoMediaPlayer.access$2000(this.this$0)) {
        return;
      }
      if (ExoMediaPlayer.access$700(this.this$0) != null)
      {
        int i = ExoMediaPlayer.access$700(this.this$0).getPlaybackState();
        if (i != 1) {
          if ((i != 2) && (i != 3))
          {
            if (i != 4) {
              break label113;
            }
          }
          else
          {
            i = ExoMediaPlayer.access$2200(this.this$0);
            if (i == ExoMediaPlayer.access$2300(this.this$0)) {
              break label113;
            }
            ExoMediaPlayer.access$2400(this.this$0, i);
            ExoMediaPlayer.access$2302(this.this$0, i);
            break label113;
          }
        }
        ExoMediaPlayer.access$2100(this.this$0, false);
      }
      label113:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.BufferRepeatListener
 * JD-Core Version:    0.7.0.1
 */