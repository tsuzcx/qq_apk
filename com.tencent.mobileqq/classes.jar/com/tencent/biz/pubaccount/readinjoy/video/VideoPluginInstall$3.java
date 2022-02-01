package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class VideoPluginInstall$3
  implements Handler.Callback
{
  VideoPluginInstall$3(VideoPluginInstall paramVideoPluginInstall) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          VideoPluginInstall.a(this.a, false);
          VideoPluginInstall.a(this.a).removeMessages(0);
        } while (VideoPluginInstall.a(this.a) == null);
        VideoPluginInstall.a(this.a).a(true);
        return true;
        VideoPluginInstall.a(this.a, false);
        VideoPluginInstall.a(this.a).removeMessages(1);
      } while (VideoPluginInstall.a(this.a) == null);
      VideoPluginInstall.a(this.a).a(false);
      return true;
    }
    VideoPluginInstall.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.3
 * JD-Core Version:    0.7.0.1
 */