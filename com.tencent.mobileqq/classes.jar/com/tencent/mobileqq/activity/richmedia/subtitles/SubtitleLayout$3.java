package com.tencent.mobileqq.activity.richmedia.subtitles;

import java.util.TimerTask;

class SubtitleLayout$3
  extends TimerTask
{
  SubtitleLayout$3(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (SubtitleLayout.a(this.this$0) == -1L)
      {
        SubtitleLayout.c(this.this$0);
        return;
      }
      this.this$0.postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout.3
 * JD-Core Version:    0.7.0.1
 */