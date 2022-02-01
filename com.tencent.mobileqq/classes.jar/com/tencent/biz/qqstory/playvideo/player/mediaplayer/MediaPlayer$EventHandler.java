package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;

class MediaPlayer$EventHandler
  extends Handler
{
  private MediaPlayer$EventHandler(MediaPlayer paramMediaPlayer) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 100)
              {
                if (i != 200) {
                  return;
                }
                Log.d("Story-MediaPlayer", "onInfo");
                if (this.a.C != null) {
                  this.a.C.a_(this.a, paramMessage.arg1, paramMessage.arg2);
                }
                return;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Error (");
              localStringBuilder.append(paramMessage.arg1);
              localStringBuilder.append(",");
              localStringBuilder.append(paramMessage.arg2);
              localStringBuilder.append(")");
              Log.e("Story-MediaPlayer", localStringBuilder.toString());
              boolean bool;
              if (this.a.B != null) {
                bool = this.a.B.a(this.a, paramMessage.arg1, paramMessage.arg2);
              } else {
                bool = false;
              }
              if ((this.a.y != null) && (!bool)) {
                this.a.y.a(this.a);
              }
              this.a.c(false);
              return;
            }
            Log.d("Story-MediaPlayer", "onVideoSizeChanged");
            if (this.a.D != null) {
              this.a.D.a(this.a, paramMessage.arg1, paramMessage.arg2);
            }
            return;
          }
          Log.d("Story-MediaPlayer", "onSeekComplete");
          if (this.a.A != null) {
            this.a.A.a(this.a);
          }
          return;
        }
        if (this.a.E != null) {
          this.a.E.a(this.a, paramMessage.arg1);
        }
        this.a.t = paramMessage.arg1;
        return;
      }
      Log.d("Story-MediaPlayer", "onPlaybackComplete");
      if (this.a.y != null) {
        this.a.y.a(this.a);
      }
      this.a.c(false);
      return;
    }
    Log.d("Story-MediaPlayer", "onPrepared");
    if (this.a.x != null) {
      this.a.x.a_(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */