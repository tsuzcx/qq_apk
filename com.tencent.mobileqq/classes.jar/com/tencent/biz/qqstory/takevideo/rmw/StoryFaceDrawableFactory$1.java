package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Handler;
import android.os.Message;

class StoryFaceDrawableFactory$1
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
    }
    while ((paramMessage.what != 1002) || (this.a.a == null)) {
      return;
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.1
 * JD-Core Version:    0.7.0.1
 */