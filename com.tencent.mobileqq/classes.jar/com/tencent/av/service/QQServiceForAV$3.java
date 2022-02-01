package com.tencent.av.service;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.groupvideo.GroupVideoWrapper;

class QQServiceForAV$3
  extends MessageObserver
{
  QQServiceForAV$3(QQServiceForAV paramQQServiceForAV) {}
  
  public void onUpdateTroopList()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      new GroupVideoWrapper(localQQAppInterface).a(new QQServiceForAV.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.3
 * JD-Core Version:    0.7.0.1
 */