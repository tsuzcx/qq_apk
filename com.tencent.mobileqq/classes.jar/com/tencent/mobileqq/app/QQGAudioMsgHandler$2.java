package com.tencent.mobileqq.app;

import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

class QQGAudioMsgHandler$2
  implements IGroupVideoWrapper.OnGVideoReadyListener
{
  QQGAudioMsgHandler$2(QQGAudioMsgHandler paramQQGAudioMsgHandler) {}
  
  public void a(IGroupVideoWrapper paramIGroupVideoWrapper)
  {
    paramIGroupVideoWrapper.processS2C(this.a.a);
    paramIGroupVideoWrapper.uninitialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.2
 * JD-Core Version:    0.7.0.1
 */