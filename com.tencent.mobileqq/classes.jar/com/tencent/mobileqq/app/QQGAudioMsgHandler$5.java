package com.tencent.mobileqq.app;

import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

class QQGAudioMsgHandler$5
  implements IGroupVideoWrapper.OnGVideoReadyListener
{
  QQGAudioMsgHandler$5(QQGAudioMsgHandler paramQQGAudioMsgHandler, byte[] paramArrayOfByte) {}
  
  public void a(IGroupVideoWrapper paramIGroupVideoWrapper)
  {
    paramIGroupVideoWrapper.processS2C(this.a);
    paramIGroupVideoWrapper.uninitialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.5
 * JD-Core Version:    0.7.0.1
 */