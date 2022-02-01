package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Message;

class VideoUIManager$1
  extends Handler
{
  VideoUIManager$1(VideoUIManager paramVideoUIManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 101: 
    case 102: 
      do
      {
        return;
        VideoUIManager.a(this.a);
        return;
        this.a.l();
        return;
        VideoUIManager.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (VideoUIManager.a(this.a) != 1);
      VideoUIManager.c(this.a);
      return;
    case 103: 
      VideoUIManager.a(this.a, 3);
      return;
    case 104: 
      VideoUIManager.d(this.a);
      return;
    }
    VideoUIManager.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.1
 * JD-Core Version:    0.7.0.1
 */