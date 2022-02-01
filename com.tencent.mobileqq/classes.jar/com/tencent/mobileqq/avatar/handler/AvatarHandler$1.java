package com.tencent.mobileqq.avatar.handler;

import android.os.Looper;
import android.os.Message;
import mqq.os.MqqHandler;

class AvatarHandler$1
  extends MqqHandler
{
  AvatarHandler$1(AvatarHandler paramAvatarHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    AvatarHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.handler.AvatarHandler.1
 * JD-Core Version:    0.7.0.1
 */