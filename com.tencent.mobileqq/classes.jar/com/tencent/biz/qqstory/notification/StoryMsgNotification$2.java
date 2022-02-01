package com.tencent.biz.qqstory.notification;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import wyw;

public class StoryMsgNotification$2
  implements Runnable
{
  public StoryMsgNotification$2(wyw paramwyw) {}
  
  public void run()
  {
    wyw.jdField_a_of_type_AndroidUtilSparseArray.clear();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    int j = wyw.jdField_a_of_type_AndroidUtilSparseIntArray.size();
    int i = 0;
    while (i < j)
    {
      localQQNotificationManager.cancel("StoryMsgNotification", wyw.jdField_a_of_type_AndroidUtilSparseIntArray.get(wyw.jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.2
 * JD-Core Version:    0.7.0.1
 */