package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoPlayController$EventHandler
  extends Handler
{
  private VideoPlayController$EventHandler(VideoPlayController paramVideoPlayController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    StringBuilder localStringBuilder;
    if (i != 100)
    {
      if (i != 200)
      {
        switch (i)
        {
        default: 
          return;
        case 7: 
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDownloading isClickToStart=");
            localStringBuilder.append(VideoPlayController.a(this.a));
            QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
          }
          if ((this.a.g != null) && (VideoPlayController.a(this.a)))
          {
            this.a.g.b(this.a.a, paramMessage.arg1);
            if (VideoPlayController.b(this.a) != 4) {
              this.a.b(8);
            }
          }
          return;
        case 6: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
          }
          if ((this.a.c != null) && (this.a.f != null))
          {
            paramMessage = this.a;
            paramMessage.b = paramMessage.c.a(this.a.f);
            if ((this.a.b != null) && (this.a.f != null))
            {
              paramMessage = this.a;
              VideoPlayController.a(paramMessage, paramMessage.f);
            }
          }
          return;
        case 5: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
          }
          return;
        case 4: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
          }
          if (this.a.g != null) {
            this.a.g.F();
          }
        case 3: 
          return;
        case 2: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
          }
          VideoPlayController.a(this.a, true);
          this.a.a(0);
          this.a.b(0);
          if (this.a.g != null) {
            this.a.g.c(this.a.a);
          }
          VideoPlayController.a(this.a, 0);
          return;
        case 1: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("onPrepared  getAutoPlayFlag=");
            paramMessage.append(this.a.b());
            QLog.d("carverW VideoPlayController", 2, paramMessage.toString());
          }
          if (this.a.g != null) {
            this.a.g.a(this.a.a, this.a.r());
          }
          if (this.a.b())
          {
            this.a.n();
            this.a.a(false);
            return;
          }
          VideoPlayController.a(this.a, 3);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "MEDIA_PREPAREING ");
        }
        VideoPlayController.a(this.a, 2);
        return;
      }
      if (this.a.g != null)
      {
        if (paramMessage.arg1 == 929)
        {
          this.a.g.d(this.a.a);
          this.a.b(8);
          return;
        }
        if (paramMessage.arg1 == 92) {
          this.a.g.a(this.a.a, paramMessage.arg2);
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error (");
      localStringBuilder.append(paramMessage.arg1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramMessage.arg2);
      localStringBuilder.append(")");
      QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
    }
    this.a.a(paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController.EventHandler
 * JD-Core Version:    0.7.0.1
 */