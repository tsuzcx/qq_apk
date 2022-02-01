package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import java.util.Comparator;

class QQGamePubAIOHelper$4
  implements Comparator<MessageForArkApp>
{
  QQGamePubAIOHelper$4(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public int a(MessageForArkApp paramMessageForArkApp1, MessageForArkApp paramMessageForArkApp2)
  {
    if ((paramMessageForArkApp1 != null) && (paramMessageForArkApp2 != null))
    {
      long l = paramMessageForArkApp1.time;
      return paramMessageForArkApp2.time < l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.4
 * JD-Core Version:    0.7.0.1
 */