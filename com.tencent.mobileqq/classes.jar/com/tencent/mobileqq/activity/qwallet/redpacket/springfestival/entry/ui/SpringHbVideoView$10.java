package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class SpringHbVideoView$10
  implements Runnable
{
  SpringHbVideoView$10(SpringHbVideoView paramSpringHbVideoView) {}
  
  public void run()
  {
    if (SpringHbVideoView.a(this.this$0) != null)
    {
      SpringHbVideoView.a(this.this$0).stop();
      SpringHbVideoView.a(this.this$0).release();
      SpringHbVideoView.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView.10
 * JD-Core Version:    0.7.0.1
 */