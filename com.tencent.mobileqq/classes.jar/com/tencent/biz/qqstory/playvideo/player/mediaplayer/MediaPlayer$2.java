package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import vtt;

class MediaPlayer$2
  implements Runnable
{
  MediaPlayer$2(MediaPlayer paramMediaPlayer) {}
  
  public void run()
  {
    try
    {
      this.this$0.a();
      if (this.this$0.h == 4) {
        this.this$0.a.sendEmptyMessage(1);
      }
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: cannot decode stream(s)", localIOException);
      this.this$0.a.sendMessage(this.this$0.a.obtainMessage(100, 1, -1004));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: something is in a wrong state", localIllegalStateException);
      this.this$0.a.sendMessage(this.this$0.a.obtainMessage(100, 1, 0));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: surface might be gone", localIllegalArgumentException);
      this.this$0.a.sendMessage(this.this$0.a.obtainMessage(100, 1, 0));
      return;
    }
    finally
    {
      MediaPlayer.a(this.this$0).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */