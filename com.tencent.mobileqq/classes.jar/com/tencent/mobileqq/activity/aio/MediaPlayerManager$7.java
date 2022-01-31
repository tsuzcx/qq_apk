package com.tencent.mobileqq.activity.aio;

import android.hardware.SensorManager;

class MediaPlayerManager$7
  implements Runnable
{
  MediaPlayerManager$7(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void run()
  {
    MediaPlayerManager.a(this.this$0).unregisterListener(MediaPlayerManager.a(this.this$0));
    MediaPlayerManager.a(this.this$0).unregisterListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.7
 * JD-Core Version:    0.7.0.1
 */