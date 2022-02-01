package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import java.util.Comparator;
import org.json.JSONObject;

class QQGamePubAIOHelper$3
  implements Comparator<MessageForArkApp>
{
  QQGamePubAIOHelper$3(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public int a(MessageForArkApp paramMessageForArkApp1, MessageForArkApp paramMessageForArkApp2)
  {
    int i = 0;
    try
    {
      long l1 = QQGamePubAIOHelper.a(paramMessageForArkApp1).optLong("time");
      long l2 = QQGamePubAIOHelper.a(paramMessageForArkApp2).optLong("time");
      if (l1 < l2) {
        i = 1;
      }
      while (l1 == l2) {
        return i;
      }
      return -1;
    }
    catch (Throwable paramMessageForArkApp1) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.3
 * JD-Core Version:    0.7.0.1
 */