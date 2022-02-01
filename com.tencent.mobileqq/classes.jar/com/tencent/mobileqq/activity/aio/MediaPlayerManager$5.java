package com.tencent.mobileqq.activity.aio;

import afca;

class MediaPlayerManager$5
  implements Runnable
{
  MediaPlayerManager$5(MediaPlayerManager paramMediaPlayerManager, int paramInt) {}
  
  public void run()
  {
    if (MediaPlayerManager.a(this.this$0) != null) {
      MediaPlayerManager.a(this.this$0).onPlayVolumeChanged(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.5
 * JD-Core Version:    0.7.0.1
 */