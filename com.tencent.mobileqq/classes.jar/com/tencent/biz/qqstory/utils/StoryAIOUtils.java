package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class StoryAIOUtils
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StoryAIOUtils", 2, "refreshAIOStoryMessages");
      }
      paramQQAppInterface.removeMessages(267387141);
      paramQQAppInterface.sendMessageDelayed(paramQQAppInterface.obtainMessage(267387141), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.StoryAIOUtils
 * JD-Core Version:    0.7.0.1
 */