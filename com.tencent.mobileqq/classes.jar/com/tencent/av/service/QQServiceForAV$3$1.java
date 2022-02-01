package com.tencent.av.service;

import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

class QQServiceForAV$3$1
  implements IGroupVideoWrapper.OnGVideoReadyListener
{
  QQServiceForAV$3$1(QQServiceForAV.3 param3) {}
  
  public void a(IGroupVideoWrapper paramIGroupVideoWrapper)
  {
    paramIGroupVideoWrapper.onUpdateTroopList();
    paramIGroupVideoWrapper.uninitialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.3.1
 * JD-Core Version:    0.7.0.1
 */