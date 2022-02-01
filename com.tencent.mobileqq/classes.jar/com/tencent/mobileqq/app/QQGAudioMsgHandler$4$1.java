package com.tencent.mobileqq.app;

import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

class QQGAudioMsgHandler$4$1
  implements IGroupVideoWrapper.OnGVideoReadyListener
{
  QQGAudioMsgHandler$4$1(QQGAudioMsgHandler.4 param4) {}
  
  public void a(IGroupVideoWrapper paramIGroupVideoWrapper)
  {
    paramIGroupVideoWrapper.processS2C(this.a.a.a);
    paramIGroupVideoWrapper.uninitialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.4.1
 * JD-Core Version:    0.7.0.1
 */