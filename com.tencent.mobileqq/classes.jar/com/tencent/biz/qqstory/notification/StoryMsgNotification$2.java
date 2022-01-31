package com.tencent.biz.qqstory.notification;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import tsg;

public class StoryMsgNotification$2
  implements Runnable
{
  public StoryMsgNotification$2(tsg paramtsg) {}
  
  public void run()
  {
    tsg.jdField_a_of_type_AndroidUtilSparseArray.clear();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    int j = tsg.jdField_a_of_type_AndroidUtilSparseIntArray.size();
    int i = 0;
    while (i < j)
    {
      localQQNotificationManager.cancel("StoryMsgNotification", tsg.jdField_a_of_type_AndroidUtilSparseIntArray.get(tsg.jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.2
 * JD-Core Version:    0.7.0.1
 */