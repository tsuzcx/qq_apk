package com.tencent.biz.qqstory.notification;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import tfk;

public class StoryMsgNotification$2
  implements Runnable
{
  public StoryMsgNotification$2(tfk paramtfk) {}
  
  public void run()
  {
    tfk.jdField_a_of_type_AndroidUtilSparseArray.clear();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    int j = tfk.jdField_a_of_type_AndroidUtilSparseIntArray.size();
    int i = 0;
    while (i < j)
    {
      localQQNotificationManager.cancel("StoryMsgNotification", tfk.jdField_a_of_type_AndroidUtilSparseIntArray.get(tfk.jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.2
 * JD-Core Version:    0.7.0.1
 */