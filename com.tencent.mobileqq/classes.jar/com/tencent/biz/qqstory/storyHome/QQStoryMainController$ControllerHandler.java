package com.tencent.biz.qqstory.storyHome;

import android.os.Handler;
import android.os.Message;

class QQStoryMainController$ControllerHandler
  extends Handler
{
  private QQStoryMainController$ControllerHandler(QQStoryMainController paramQQStoryMainController) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    this.a.i.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.ControllerHandler
 * JD-Core Version:    0.7.0.1
 */