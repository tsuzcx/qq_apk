package com.tencent.av;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class VideoCallStateMonitor$TimerHandler
  extends Handler
{
  WeakReference<VideoCallStateMonitor> a;
  
  VideoCallStateMonitor$TimerHandler(VideoCallStateMonitor paramVideoCallStateMonitor)
  {
    this.a = new WeakReference(paramVideoCallStateMonitor);
  }
  
  public void a()
  {
    sendMessage(obtainMessage(1));
  }
  
  public void b()
  {
    sendMessage(obtainMessage(3));
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    VideoCallStateMonitor localVideoCallStateMonitor = (VideoCallStateMonitor)this.a.get();
    if (localVideoCallStateMonitor != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        VideoCallStateMonitor.a(localVideoCallStateMonitor, paramMessage.what);
      } while (VideoCallStateMonitor.a(localVideoCallStateMonitor) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    VideoCallStateMonitor.a(localVideoCallStateMonitor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor.TimerHandler
 * JD-Core Version:    0.7.0.1
 */