package com.tencent.biz.qqstory.notification;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.notification.QQNotificationManager;

class StoryMsgNotification$2
  implements Runnable
{
  StoryMsgNotification$2(StoryMsgNotification paramStoryMsgNotification) {}
  
  public void run()
  {
    StoryMsgNotification.d.clear();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    int j = StoryMsgNotification.c.size();
    int i = 0;
    while (i < j)
    {
      localQQNotificationManager.cancel("StoryMsgNotification", StoryMsgNotification.c.get(StoryMsgNotification.c.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.2
 * JD-Core Version:    0.7.0.1
 */